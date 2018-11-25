package com.forit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.VideoDAO;

public class AdminVideoDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("강의자료 삭제 액션 진입");
		// 글 번호를 가져옴
		String vNum = request.getParameter("vNum");
		VideoDAO vDao = VideoDAO.getInstance();

		vDao.deleteVideo(vNum);
    
		System.out.println("videodeleteNum : " + vNum);

		new AdminVideoListAction().execute(request, response);
	}

}