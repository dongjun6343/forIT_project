package com.forit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.forit.dto.AssignmentVO;
import com.forit.util.Paging;

public class AssignmentDAO extends CommonDAO {
   private static AssignmentDAO instance;
   
   public static AssignmentDAO getInstance(){
      if(instance == null){
         instance = new AssignmentDAO();
      }
      return instance;
   }
   
   //과제 조회
   public List<AssignmentVO> selectAllAssignments() {
       
        String sql = "SELECT ASSNUM,ASSTITLE,ASSDATE,ASSCONTENT,ASSCOUNT,ASSACTIVE,ADMINID FROM ASSIGNMENT";
         
         List<AssignmentVO> list = new ArrayList<AssignmentVO>();
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;

         try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
               AssignmentVO aVo = new AssignmentVO();
               
               aVo.setAssNum(rs.getInt("assNum"));
               aVo.setAssTitle(rs.getString("assTitle"));
               aVo.setAssDate(rs.getTimestamp("assDate"));
               aVo.setAssContent(rs.getString("assContent"));
               aVo.setAssCount(rs.getInt("assCount"));
               //String 형식을 char형으로 변환
               aVo.setAssActive(rs.getString("assActive").charAt(0));
               aVo.setAdminId(rs.getString("adminId"));
               
               
               list.add(aVo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
         return list;
      }


   public List<AssignmentVO> selectAllAssignmentsPerPage(Paging paging) {
       
        String sql = "SELECT ASS.*"
              + "       FROM (SELECT ROWNUM RNUM"
              + "                  , ASS.ASSNUM"
              + "                  , ASS.ASSTITLE"
              + "                  , ASS.ASSDATE"
              + "                  , ASS.ASSCONTENT"
              + "                  , ASS.ASSCOUNT"
              + "                  , ASS.ASSACTIVE"
              + "                  , ASS.ADMINID"
              + "               FROM ASSIGNMENT ASS"
              + "              ORDER BY ASS.ASSNUM DESC) ASS"
              + "      WHERE ASS.RNUM BETWEEN ? AND ?";
         
         List<AssignmentVO> list = new ArrayList<AssignmentVO>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;

         try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            
            
            
            stmt.setInt(1, ((paging.getPageNum() - 1) * 10) + 1);
            stmt.setInt(2, ((paging.getPageNum() - 1) * 10) + 1 + 9);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               AssignmentVO aVo = new AssignmentVO();
               
               aVo.setAssNum(rs.getInt("assNum"));
               aVo.setAssTitle(rs.getString("assTitle"));
               aVo.setAssDate(rs.getTimestamp("assDate"));
               aVo.setAssContent(rs.getString("assContent"));
               aVo.setAssCount(rs.getInt("assCount"));
               //String 형식을 char형으로 변환
               aVo.setAssActive(rs.getString("assActive").charAt(0));
               aVo.setAdminId(rs.getString("adminId"));
               
               
               list.add(aVo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
         return list;
      }
   
   
   public Paging selectAssRowCount(Paging paging)
   {
      int cnt = 0;
      
      String sql = "SELECT COUNT(*) CNT"
            + "     FROM ASSIGNMENT";
      
      Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         try
         {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
               cnt = rs.getInt("CNT");
               paging.setNumOfRow(cnt);;
            }
            
         }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
         finally
         {
            dbClose();
         }
         
         return paging;
   }
   
   //과제 등록
   public void insertAssignment(AssignmentVO aVo){
       String sql = "insert into ASSIGNMENT( " 
                + "ASSNUM,ASSTITLE,ASSCONTENT,ASSCOUNT,ASSACTIVE,ADMINID)"
                  + "values (ASSIGNMENT_SEQ.nextval,?,?,?,?,?)";
   
       Connection conn = null;
       PreparedStatement stmt = null;
       
       try{
          conn = getConnection();
          stmt = conn.prepareStatement(sql);
          
//          st.setInt(1, aVo.getASSNUM());
          
          stmt.setString(1, aVo.getAssTitle());
          stmt.setString(2, aVo.getAssContent());
          stmt.setInt(3, aVo.getAssCount());
          stmt.setLong(4, aVo.getAssActive());
          stmt.setString(5, aVo.getAdminId());
          
          stmt.executeUpdate();
          
       }catch(SQLException e){
          e.printStackTrace();
       
       }finally{
          dbClose();
       }    
       
   }
   //상세보기 : 글 번호로 찾아온다 : 실패 null;
   public AssignmentVO selectOneAssignementByNum(String assNum){
      String sql = "SELECT ASSNUM,ASSTITLE,ASSDATE,ASSCONTENT,ASSCOUNT,ASSACTIVE,ADMINID FROM ASSIGNMENT where ASSNUM = ?";
      
      AssignmentVO aVo = null;
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
   
      try{
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, assNum);
         
         rs = stmt.executeQuery();
         
         if(rs.next()){
            aVo = new AssignmentVO();
             aVo.setAssNum(rs.getInt("assNum"));
               aVo.setAssTitle(rs.getString("assTitle"));
               aVo.setAssDate(rs.getTimestamp("assDate"));
               aVo.setAssContent(rs.getString("assContent"));
               aVo.setAssCount(rs.getInt("assCount"));
               aVo.setAssActive(rs.getString("assActive").charAt(0));
               aVo.setAdminId(rs.getString("adminId"));
         }
         
      }catch(SQLException e){
         e.printStackTrace();
      }
      return aVo;
   }   
   
   //게시글 삭제하기.
   public void deleteAssignment(String assNum){
      String sql = "delete ASSIGNMENT WHERE ASSNUM=?";
      
      Connection conn = null;
      PreparedStatement stmt = null;
      try{
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
         
         stmt.setString(1, assNum);
         
      }catch(SQLException e){
         e.printStackTrace();
      }
   
   }
//오늘의과제 조회수 올리기
   public void updateReadCount(String assNum){
      String sql = "update ASSIGNMENT set ASSCOUNT=ASSCOUNT+1 where ASSNUM=?";
      
      Connection conn = null;
      PreparedStatement stmt = null;
      try{
         conn = getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, assNum);
         stmt.executeQuery();
         
      }catch(SQLException e){
         e.printStackTrace();
      }finally{
          dbClose();
      }
    }
//오늘의 과제 수정
   public void updateAssignment(AssignmentVO aVo) {
      String sql = "UPDATE ASSIGNMENT SET ASSTITLE=?,ASSCONTENT=? WHERE ASSNUM=?";
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, aVo.getAssTitle());
         pstmt.setString(2, aVo.getAssContent());
         pstmt.setInt(3, aVo.getAssNum());
         
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
   }
}