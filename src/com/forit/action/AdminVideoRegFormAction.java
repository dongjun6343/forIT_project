package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;

public class AdminVideoRegFormAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
   String url = "/admin/video/register.jsp";
      
      VideoVO vVo = new VideoVO();
      
      //입력받아온 name과 파라미터
      vVo.setvTitle(request.getParameter("videoTitle"));
      vVo.setvContent(request.getParameter("videoContent"));
    
      VideoDAO vDao = VideoDAO.getInstance();
      vDao.insertVideo(vVo);
   
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }

}