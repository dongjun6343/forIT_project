package com.forit.action;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.AssignmentDAO;
import com.forit.dto.AssignmentVO;

public class AdminAssignUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		

//		AssignmentDAO aDao = AssignmentDAO.getInstance();

		// aDao.updateReadCount(assNum);
		// AssignmentVO aVo = aDao.selectOneAssignementByNum(assNum);

		AssignmentVO aVo = new AssignmentVO();

		request.setCharacterEncoding("UTF-8");
		String assNum = request.getParameter("assNum");
		System.out.println("assNumUpdate ==> " + assNum);
		String assTitle = request.getParameter("assTitle");
		String assContent = request.getParameter("assContent");
		String adminId = request.getParameter("adminid");

		//객체 셋팅
		//업데이트 주체가 될 assNum
	
//		aVo.setAssNum(Integer.parseInt(request.getParameter("assNum")));
//		aVo.setAssTitle(request.getParameter("assTitle"));
//		aVo.setAssContent(request.getParameter("assContent"));
//		aVo.setAdminId(request.getParameter("adminId"));
		aVo.setAssNum(Integer.valueOf(assNum));
		aVo.setAssTitle(assTitle);
		aVo.setAssContent(assContent);
		aVo.setAdminId(adminId);
		
		request.setAttribute("AssignmentVO", aVo);

		System.out.println(aVo);
		
		//실제 데이터 Update DAO
		AssignmentDAO.getInstance().updateAssignment(aVo);
		

		new AdminAssignListAction().execute(request, response);
	}
}
