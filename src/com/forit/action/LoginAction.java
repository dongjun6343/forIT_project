//로그인액션
package com.forit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.forit.dao.LoginDAO;
import com.forit.dto.AdminVO;

public class LoginAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
	  
	  String url = "noticeServlet?command=notice";

      HttpSession session = request.getSession();
      
      //이미 로그인 한 Session => LoginUser

      if (session.getAttribute("LoginUser") != null) {
         
         RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         dispatcher.forward(request, response);
         
      } else {
         
         //신규로그인
         
         AdminVO aVo = new AdminVO();
         LoginDAO lDao = LoginDAO.getInstance();

         aVo.setAdminId(request.getParameter("adminid"));
         aVo.setAdminPw(request.getParameter("adminpw"));

         System.out.println(lDao.loginCheck(aVo));
         aVo = lDao.loginCheck(aVo);
         
         if(aVo.getAdName() != null){
            //계정 확인 완료
            session.setAttribute("LoginUser", aVo);
            System.out.println(aVo);
            
         }else{
            //로그인 계정 없음
            request.setAttribute("message", "존재하지 않는 회원입니다.");
            url = "/admin/login/login.jsp";
            
         }
         
         //RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         

/*         switch (mDao.loginCheck(mVo)) {
         
         case 1: {
            AdminVO sessionVo = mDao.getAdminid(mVo);
            session.setAttribute("LoginUser", sessionVo);
            System.out.println(sessionVo);
            break;
         }
         case 0: {
            request.setAttribute("message", "비밀번호를 확인하세여.");
            url = "main.do?command=loginform";
            break;
         }
         case -1: {
            request.setAttribute("message", "존재하지 않는 회원입니다.");
            url = "main.do?command=loginform";
            break;

         }
         default:
            request.setAttribute("message", "오류가 발생했습니다.");

         }*/

      }
   }
}
   
   
   
   
   
   