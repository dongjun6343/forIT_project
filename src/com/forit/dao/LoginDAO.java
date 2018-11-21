//로그인 DAO
package com.forit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.forit.dto.AdminVO;

public class LoginDAO extends CommonDAO {
   private static LoginDAO instance;

   public static LoginDAO getInstance() {
      if (instance == null) {
         instance = new LoginDAO();
      }
      return instance;
   }

//   public boolean logincheck(String no, String pass)   {
//      boolean res = false;
//    Connection conn = getConnection();
//    ResultSet rs = null; //조회 결과값
//    PreparedStatement st;
//     
//    try   {
//       st = conn.prepareStatement ("SELECT ADNAME FROM ADMIN WHERE ADMINID=? AND ADMINPW=?");
//       st.setString(1,no);
//       st.setString(2,pass);
//       rs = st.executeQuery();   //쿼리문 실행
//       
//   if (rs.next())   {
//      
//   res = true;
//   return res;
//    }
//    dbClose();
//   
//   }   catch   (SQLException e)   {
//      e.printStackTrace();
//   }
//   return res;
//    }

   public AdminVO loginCheck(AdminVO aVo) {
      Connection conn = getConnection();

      ResultSet rs = null; // 조회 결과값
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT ADNAME FROM ADMIN WHERE ADMINID = ? AND ADMINPW = ?");
         //전달받은 id, pass DB 검색
         st.setString(1, aVo.getAdminId());
         st.setString(2, aVo.getAdminPw());
         
       System.out.println(aVo.getAdminId());
       System.out.println(aVo.getAdminPw());
         rs = st.executeQuery(); // 쿼리문 실행

         if (rs.next()) {
            aVo.setAdName(rs.getString("ADNAME"));
         }

         dbClose();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return aVo;
   }

/*
   public AdminVO getloginInfo(String user) {
      AdminVO ad = new AdminVO();

      Connection conn = getConnection();

      ResultSet rs = null; // 조회 결과값
      PreparedStatement st;

      try {
         st = conn.prepareStatement("SELECT ADNAME FROM ADMIN WHERE ADMINID=? AND ADMINPW=?");
         st.setString(1, user);
         rs = st.executeQuery(); // 쿼리문 실행

         if (rs.next()) {
            ad.setADMINID(rs.getString("ADMIN_ID"));
            ad.setADMINPW(rs.getString("ADMIN_PW"));
            ad.setADNAME(rs.getString("AD_NAME"));
         }

         dbClose();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return ad;
   } */
}