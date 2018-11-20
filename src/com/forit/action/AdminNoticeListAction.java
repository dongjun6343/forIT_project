package com.forit.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.NoticeDAO;
import com.forit.dto.NoticeVO;

//게시글 전체 정보를 데이터베이스에서 얻어온다. 게시글리스트보기
public class AdminNoticeListAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/admin/notice/list.jsp";
      
      NoticeDAO nDao = NoticeDAO.getInstance();
      
      List<NoticeVO> noticeList = nDao.selectAllNotices();
      
      request.setAttribute("noticeList", noticeList);
      
      System.out.println(noticeList);
      
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
   
}