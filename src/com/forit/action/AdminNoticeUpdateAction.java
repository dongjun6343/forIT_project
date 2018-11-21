package com.forit.action;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.forit.dao.NoticeDAO;
import com.forit.dto.NoticeVO;

public class AdminNoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		NoticeVO nVo = new NoticeVO();

		
		String nNum = request.getParameter("nNum");
		System.out.println("nNumUpdate ==> " + nNum);
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String adminId = request.getParameter("adminId");

		//객체 셋팅
		nVo.setnNum(Integer.parseInt(nNum));
		nVo.setnTitle(nTitle);
		nVo.setnContent(nContent);
		nVo.setAdminId(adminId);
		
		
		
		request.setAttribute("noticeVO", nVo);

		System.out.println(nVo);
		
		//실제 데이터 Update DAO
		NoticeDAO.getInstance().updateNotice(nVo);
		

		new AdminNoticeListAction().execute(request, response);
	}
}
