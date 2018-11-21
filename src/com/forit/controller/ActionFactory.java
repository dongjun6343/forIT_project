package com.forit.controller;

import com.forit.action.Action;
import com.forit.action.AdminAssignDeleteAction;
import com.forit.action.AdminAssignDetailAction;
import com.forit.action.AdminAssignListAction;
import com.forit.action.AdminAssignRegisterAction;
import com.forit.action.AdminAssignUpdateAction;
import com.forit.action.AdminAssignUpdateFormAction;
import com.forit.action.AdminAssignmentRegFormAction;
import com.forit.action.AdminNoticeDetailAction;
import com.forit.action.AdminNoticeListAction;
import com.forit.action.AdminNoticeRegFormAction;
import com.forit.action.AdminNoticeRegisterAction;
import com.forit.action.AdminNoticeUpdateAction;
import com.forit.action.AdminNoticeUpdateFormAction;
import com.forit.action.AdminVideoDetailAction;
import com.forit.action.AdminVideoListAction;
import com.forit.action.AdminVideoRegFormAction;
import com.forit.action.AdminVideoRegisterAction;
import com.forit.action.AdminVideoUpdateAction;
import com.forit.action.AdminVideoUpdateFormAction;
import com.forit.action.ClubIntroAction;
import com.forit.action.LoginAction;
import com.forit.action.MainAction;
import com.forit.action.VideoListAction;


/**
 * request로 받아온 매개변수의 command의 값으로 각 기능을 수행할 액션을 분기하는 클래스 <br>
 * action추가 시 최대한 기능별로 정렬될 수 있도록 한다. 수정이 잦은 class이므로 주의하여 편집!!
 * 
 * @author cho
 *
 */
public class ActionFactory {

   private static ActionFactory instance = new ActionFactory();

   private ActionFactory() {
      super();
   }

   public static ActionFactory getInstance() {
      return instance;
   }

   public Action getAction(String command) {
      Action action = null;

      System.out.println("ActionFactory : " + command);
      
      if (command.equals("main")) {

         action = new MainAction();
         //로그인을 눌렀을 때
      }   else if (command.equals("login")){
         
         action = new LoginAction();
         
      }    else if (command.equals("videoList")){
         
         action = new VideoListAction();
      }    //등록누르고 register폼으로
         else if (command.equals("adminAssignmentReg")){
         
         action = new AdminAssignmentRegFormAction();
         
         //등록을 누르면 리스트보여줌
      }    else if (command.equals("adminAssignRegister")){
         
         action = new AdminAssignRegisterAction();
         //오늘의과제 상세보기
      }   else if (command.equals("adminAssignDetail")){
         
         action = new AdminAssignDetailAction();
         //오늘의 과제 리스트
      }   else if (command.equals("adminAssignList")){
         
         action = new AdminAssignListAction();
         //오늘의 과제 수정 화면으로 이동 
      }   else if (command.equals("adminAssignModifyForm")){
         
         action = new AdminAssignUpdateFormAction();      
         //오늘의 과제 수정
      }   else if (command.equals("adminAssignModify")){
         
         action = new AdminAssignUpdateAction();
      
      }   else if (command.equals("adminAssignDelete")){
         
         action = new AdminAssignDeleteAction();
      
      }   else if (command.equals("clubIntro")){
         
         action = new ClubIntroAction();
         
         
         
         
         
         
         //공지사항 등록
      }   else if (command.equals("adminNoticeRegister")){
         
         action = new AdminNoticeRegisterAction();
         //공지사항 등록폼
      }   else if (command.equals("adminNoticeRegForm")){
            
         action = new AdminNoticeRegFormAction();   
         //공지사항 리스트
      }   else if (command.equals("adminNoticeList")){
            
         action = new AdminNoticeListAction();
         //공지사항 수정폼으로 이동   
      }   else if (command.equals("adminNoticeModifyForm")){
         
         action = new AdminNoticeUpdateFormAction();      
         //공지사항 과제 수정
      }   else if (command.equals("adminNoticeModify")){
               
         action = new AdminNoticeUpdateAction();
         //공지사항 상세보기
      }   else if (command.equals("adminNoticeDetail")){
            
         action = new AdminNoticeDetailAction();      
            
      
            
            
         //관리자강의자료 등록
      }   else if (command.equals("adminVideoRegister")){
         
         action = new AdminVideoRegisterAction();
         
         //강의자료리스트
      }   else if (command.equals("adminVideoList")){
         
         action = new AdminVideoListAction();
         //강의자료 등록폼
      }   else if (command.equals("adminVideoRegForm")){
         
         action = new AdminVideoRegFormAction();   
         //강의자료 상세보기
      }   else if (command.equals("adminVideoDetail")){
         
         action = new AdminVideoDetailAction();   
         //강의자료 수정폼
      }   else if (command.equals("adminVideoModifyForm")){
         
         action = new AdminVideoUpdateFormAction();   
         //강의자료 수정
      }   else if (command.equals("adminVideoModify")){
         
         action = new AdminVideoUpdateAction();   
         
      }
      
      
      
      
      return action;
   }

}