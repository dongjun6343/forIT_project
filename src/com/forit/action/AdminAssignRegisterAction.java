package com.forit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.dao.AssignmentDAO;
import com.forit.dto.AssignmentVO;
//관리자가 등록하기 버튼을 눌렀을 때(입력한 디비정보를 데이터베이스에 추가한다.)
public class AdminAssignRegisterAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		String url = "/admin/assignment/list.jsp";
			
		
	      // StudentVO 객체 생성
	      AssignmentVO aVo = new AssignmentVO();
	      
	      //파라미터의 이름과 id는 같아야한다. register.jsp
//	      request.setCharacterEncoding("UTF-8");
//	      String assNum = request.getParameter("assignNum");
	      String assTitle = request.getParameter("assignTitle");
	      String assContent = request.getParameter("assignContent");
	      String adminId = request.getParameter("adminid");
	      
	   // Parameter 출력
//	      System.out.println("assNum : " + assNum);
	      System.out.println("assignTitle : " + assTitle);
	      System.out.println("assignContent : " + assContent);
	      System.out.println("adminId : " + adminId);
	      
	      // 객체 세팅
	      aVo.setAssTitle(assTitle);
	      aVo.setAssContent(assContent);
	      aVo.setAdminId(adminId);
	      AssignmentDAO aDao = AssignmentDAO.getInstance();
	      
	      aDao.insertAssignment(aVo);

		  request.setAttribute("msg", "글을 작성했습니다");
//			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//			dispatcher.forward(request, response);
	      
	      //AssignListAction불러오기(List에 디비가 담겨있음)
	      new AdminAssignListAction().execute(request, response);
		}
	}
	

