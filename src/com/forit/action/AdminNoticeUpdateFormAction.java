package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.NoticeDAO;
import com.forit.dto.NoticeVO;


public class AdminNoticeUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/notice/modifyPage.jsp";
		
		String nNum = request.getParameter("nNum");
		
		System.out.println("nNumUpdateForm ==> " + nNum);
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		
		nDao.updateReadCount(nNum);
		NoticeVO nVo = nDao.selectOneNoticeByNum(nNum); //상세보기
		
		request.setAttribute("noiceVO", nVo);
		
		System.out.println(nVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		//new AdminAssignListAction().execute(request, response);
	}
}
