package com.forit.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.NoticeDAO;
import com.forit.dto.NoticeVO;


//관리자가 등록하기 버튼을 눌렀을 때(입력한 디비정보를 데이터베이스에 추가한다.)
public class AdminNoticeRegisterAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub

//	   	String url = "adminNotice?command=admin_notice_list";
         
      
         // NoticeVO 객체 생성
         NoticeVO nVo = new NoticeVO();
        
         
//       String nNum = request.getParameter("nNum"); 시퀀스로 숫자 올림
         String nTitle = request.getParameter("nTitle");
         String nContent = request.getParameter("nContent");
         String adminId = "admin";
         
         
         System.out.println("nTitle : " + nTitle);
	      System.out.println("nContent : " + nContent);
	      System.out.println("adminId : " + adminId);
         // Parameter 출력
//         System.out.println("nNum : " + nNum); 시퀀스로 숫자 올림
         
         // 객체 세팅
         nVo.setnTitle(nTitle);
         nVo.setnContent(nContent);
         nVo.setAdminId(adminId);
      
         
         NoticeDAO nDao = NoticeDAO.getInstance();
         
         nDao.insertNotice(nVo);
         
         request.setAttribute("msg", "글을 작성했습니다.");
        
         //AssignNoticeAction불러오기(List에 디비가 담겨있음)
         new AdminNoticeListAction().execute(request, response);
         
      }
   }
   
