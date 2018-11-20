package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.VideoDAO;
import com.forit.dto.VideoVO;
//관리자가 등록하기 버튼을 눌렀을 때(입력한 디비정보를 데이터베이스에 추가한다.)
public class AdminVideoRegisterAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
 
	   	 System.out.println("강의자료 등록 액션 진입");
         // StudentVO 객체 생성
         VideoVO vVo = new VideoVO();
         
         //파라미터의 이름과 id는 같아야한다. register.jsp
         String vTitle = request.getParameter("vTitle");
         String vContent = request.getParameter("vContent");
         String vSubject = request.getParameter("vSubject");
         String vUrl = request.getParameter("vUrl");
         String adminId = "admin";
         
         // 객체 세팅
         vVo.setvTitle(vTitle);
         vVo.setvContent(vContent);
         vVo.setvSubject(vSubject);
         vVo.setvUrl(vUrl);
         vVo.setAdminID(adminId);
         
         VideoDAO vDao = VideoDAO.getInstance();
         
         vDao.insertVideo(vVo);
         
	      new AdminVideoListAction().execute(request, response);

         
      }
   }
   
