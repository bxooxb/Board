package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class ListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 페이징 기법
		Paging paging = new Paging();
		
		// 1. 전체 게시물의 수
		int su = DAO.getCount();
		paging.setTotalRecored(su);
		
		// 2. 전체 게시물의 수를 가지고 전체 페이지의 수를 구하자 
		paging.setTotalPage(paging.getTotalRecored()/paging.getNumPerpage());
		
		// 나눈 나머지가 존재하면 한페이지를 추가 한다.
		if(paging.getTotalRecored()%paging.getNumPerpage() != 0) {
			paging.setTotalPage(paging.getTotalPage()+1);
		}
		
		// 3. 현재 페이지 구하기 
		String cPage = request.getParameter("cPage");
		if(cPage == null) {
			paging.setNowPage(1);
		}else {
			paging.setNowPage(Integer.parseInt(cPage));
		}
		
		// 4. 시작번호, 끝번호 
		paging.setBegin((paging.getNowPage()-1)*paging.getNumPerpage()+1);
		paging.setEnd((paging.getBegin()-1)+paging.getNumPerpage());
		
		// 5. 시작블록, 끝블록
		paging.setBeginBlock((int)((paging.getNowPage()-1)/paging.getPagePerBlock())*paging.getPagePerBlock()+1);
		paging.setEndBlock(paging.getBeginBlock()+paging.getPagePerBlock()-1);
		
		// 주의 사항
		if(paging.getEndBlock()> paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
				
		// DB처리(시작번호, 끝번호)
		List<VO> list = DAO.getList(paging.getBegin(), paging.getEnd());
		
		// 저장(list, paging)
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		return "view/list.jsp";
	}
}










