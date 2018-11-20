package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminNoticeRegFormAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   
   String url = "admin/notice/register.jsp";
      
//      NoticeVO nVo = new NoticeVO();
      
//      //입력받아온 name과 파라미터 값과 같아야한다.
//      nVo.setNTITLE(request.getParameter("nTitle"));
//      nVo.setNCONTENT(request.getParameter("nContent"));
//      
//      NoticeDao nDao = NoticeDao.getInstance();
//      nDao.insertNotice(nVo);
//   
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }

}