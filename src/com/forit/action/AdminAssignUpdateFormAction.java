package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.AssignmentDAO;
import com.forit.dto.AssignmentVO;

public class AdminAssignUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/assignment/modifyPage.jsp";
		String assNum = request.getParameter("assNum");
		
		AssignmentDAO aDao = AssignmentDAO.getInstance();
		
		aDao.updateReadCount(assNum);
		
		AssignmentVO aVo = aDao.selectOneAssignementByNum(assNum);
		
		request.setAttribute("assignment", aVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		//new AdminAssignListAction().execute(request, response);
	}
}
