package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;


public class AdminVideoUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/video/modifyPage.jsp";
		
		String vNum = request.getParameter("vNum");
		
		System.out.println("vNumUpdateForm ==> " + vNum);
		
		VideoDAO vDao = VideoDAO.getInstance();
		
//		nDao.updateReadCount(nNum); 조회수올리기
		VideoVO vVo = vDao.selectOneVideoByNum(vNum); //상세보기
		
		request.setAttribute("videoVO", vVo);
		
		System.out.println(vVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		//new AdminAssignListAction().execute(request, response);
	}
}
