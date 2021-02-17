package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DeleteOKCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String cPage = request.getParameter("cPage");
		int result = DAO.getDelete(idx);

		// 원본글이면 전체 댓글 삭제
		HttpSession session = request.getSession();
		VO vo = (VO) session.getAttribute("vo");
		String groups = vo.getGroups();
		String step = vo.getStep();
		String lev = vo.getLev();

		if (step.equals("0") && lev.equals("0")) {
			// 관련 댓글 모두 삭제
			result = DAO.getDeleteAll(groups);
		} else {
			result = DAO.getDelete(idx);
		}
		request.setAttribute("cPage", cPage);
		return "MyController?cmd=list";

		// return "MyController?cmd=list&cPage="+cPage;
	}
}
