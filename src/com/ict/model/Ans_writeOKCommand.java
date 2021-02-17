package com.ict.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Ans_writeOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("/upload");
			MultipartRequest mr = new MultipartRequest(request, path,
					100*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			String cPage = mr.getParameter("cPage");
			
			// 원글과 관련된 기본 정보 업데이트(setp.lev를 1씩 증가 )
			int groups = Integer.parseInt(mr.getParameter("groups"));
			int step = Integer.parseInt(mr.getParameter("step"));
			int lev = Integer.parseInt(mr.getParameter("lev"));
			
			// 61 , 0 , 0 
			// step, lev를 1씩 증가
			lev++;
			step++;
			
			// 61, 1 , 1 
			
			// DB에 groups를 이용한 lev를 업데이트
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("groups", groups);
			map.put("lev", lev);
			int result = DAO.getUp_lev(map);
			
			// 댓글 삽입 
			VO vo = new VO();
			vo.setWriter(mr.getParameter("writer"));
			vo.setTitle(mr.getParameter("title"));
			vo.setContent(mr.getParameter("content"));
			vo.setPwd(mr.getParameter("pwd"));
			vo.setGroups(String.valueOf(groups)); // 61
			vo.setStep(String.valueOf(step));     // 1
			vo.setLev(String.valueOf(lev));       // 1
			
			if(mr.getFile("file_name") != null) {
				vo.setFile_name(mr.getFilesystemName("file_name"));
			}else {
				vo.setFile_name("");
			}
			result = DAO.getAnsInsert(vo);
			
			return "MyController?cmd=list&cPage="+cPage;
		} catch (Exception e) {
		}
		return null;
	}
}
