package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.NoticeDAO;
import com.forit.dto.NoticeVO;

public class AdminNoticeDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String url = "/admin/notice/detail.jsp";
		
		String nNum = request.getParameter("nNum");
		System.out.println(nNum);
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		//조회수 올리기
//		nDao.updateReadCount(nNum);
		
		NoticeVO nVo = nDao.selectOneNoticeByNum(nNum);
		
		//detail의 value부분과 똑같이
		request.setAttribute("noticeVO", nVo);
		

		System.out.println(nVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
