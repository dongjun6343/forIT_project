package com.forit.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forit.action.Action;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main") //이게 주소
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//command : jsp 페이지에 있는 것을 가져오는 것
		//String command에 로그인이 찍힘 .sysout 하면 로그인이 찍힘/
		String command = request.getParameter("command");
		System.out.println("MainServlet에서 요청을 받음을 확인 : " + command);
		
	if(command == null) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		}else if(command.equals("loginForm")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else {
			//액션팩토리로 가겠다.
			ActionFactory af = ActionFactory.getInstance();
			Action action = af.getAction(command);
			
			if(action != null){
				action.execute(request, response);
			}
		}

	}

	/**
	 * @see HttpServSlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//doPost get으로 감 메소드니까.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
