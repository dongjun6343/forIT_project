package com.forit.action;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;

public class AdminVideoUpdateAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   

      //registerAction과유사.
      
      VideoVO vVo = new VideoVO();
      
      String vNum = request.getParameter("vNum");
      String vTitle = request.getParameter("vTitle");
        String vContent = request.getParameter("vContent");
        String vSubject = request.getParameter("vSubject");
        String vUrl = request.getParameter("vUrl");
        String adminId = request.getParameter("adminid");

      //객체 셋팅
        vVo.setvNum(Integer.parseInt(vNum));
        vVo.setvTitle(vTitle);
        vVo.setvContent(vContent);
        vVo.setvSubject(vSubject);
        vVo.setvUrl(vUrl);
        vVo.setAdminID(adminId);
        
      request.setAttribute("videoVO", vVo);

      System.out.println(vVo);
      
      //실제 데이터 Update DAO
      VideoDAO.getInstance().updateVideo(vVo);

      new AdminVideoListAction().execute(request, response);
   }
}