package com.forit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.AssignmentDAO;



public class AdminAssignDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String assNum = request.getParameter("assNum");
		
		AssignmentDAO aDao = AssignmentDAO.getInstance();
		aDao.deleteAssignment(assNum);
		
		new AdminAssignListAction().execute(request, response);
	}

}
