package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;

public class AdminVideoDetailAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
   
      String url = "/admin/video/detail.jsp";
      
      String vNum = request.getParameter("vNum");
      System.out.println(vNum);
      
      VideoDAO vDao = VideoDAO.getInstance();
      //조회수 올리기
      vDao.updateReadCount(vNum);      
      VideoVO vVo = vDao.selectOneVideoByNum(vNum);
      
      //detail의 value부분과 똑같이
      request.setAttribute("videoVO", vVo);
      

      System.out.println(vVo);
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      
   }

}