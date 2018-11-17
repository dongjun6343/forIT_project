package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.AssignmentDAO;
import com.forit.dto.AssignmentVO;

public class AdminAssignDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/admin/assignment/detail.jsp";
		
		String assNum = request.getParameter("assNum");
		System.out.println(assNum);
		
		AssignmentDAO aDao = AssignmentDAO.getInstance();
//		aDao.updateReadCount(num);
		
		AssignmentVO aVo = aDao.selectOneAssignementByNum(assNum);
	
		request.setAttribute("AssignmentVO", aVo);
		

		System.out.println(aVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
