package com.forit.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;

//게시글 전체 정보를 데이터베이스에서 얻어온다. 게시글리스트보기
public class AdminVideoListAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/admin/video/list.jsp";
      
      VideoDAO vDao = VideoDAO.getInstance();
      
      /*List<VideoVO> videoList = vDao.selectAllVideos();*/
      List<VideoVO> videoList = new ArrayList<VideoVO>();
      
      
      videoList = 	vDao.selectAllVideos();
      request.setAttribute("videoList", videoList);
      System.out.println(videoList);
      
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);//url을 찍어줘야됨
      dispatcher.forward(request, response);
   }
   
}

