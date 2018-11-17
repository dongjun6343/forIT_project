package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAssignmentRegFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "admin/assignment/register.jsp";
		
/*		AssignmentVO aVo = new AssignmentVO();
    
		aVo.setAssTitle(request.getParameter("asstitle"));
		aVo.setAssContent(request.getParameter("asscontent"));*/
    
//		AssignmentVO aDao = AssignmentVO.getInstance();
//		aDao.insertAssignment(aVo);
//	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}