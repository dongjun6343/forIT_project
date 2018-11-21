package com.forit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.forit.dto.VideoVO;

public class VideoDAO extends CommonDAO {
   private static VideoDAO instance;
   
   public static VideoDAO getInstance(){
      if(instance == null){
         instance = new VideoDAO();
      }
      return instance;
   }
   
   //강의자료 조회
   public List<VideoVO> selectAllVideos() {
       
         String sql = "SELECT VNUM "
         			+ "     , VTITLE"
         			+ "		, VDATE"
         			+ "		, VCONTENT"
         			+ "		, VSUBJECT"
         			+ "		, VURL"
         			+ "		, VCONTENT"
         			+ "		, ADMINID "
         			+ "  FROM VIDEO";
         
         List<VideoVO> list = new ArrayList<VideoVO>();
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;

         try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
               VideoVO vVo = new VideoVO();
               
               vVo.setvNum(rs.getInt("vNum"));
               vVo.setvTitle(rs.getString("vTitle"));
               vVo.setvDate(rs.getTimestamp("vDate"));
               vVo.setvContent(rs.getString("vContent"));
               vVo.setvSubject(rs.getString("vSubject"));
               vVo.setvUrl(rs.getString("vUrl"));
               vVo.setvCount(rs.getInt("vCount"));
               vVo.setadminID(rs.getString("adminId"));
                
               
               list.add(vVo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            dbClose();
         }
         return list;
      }


   //과제 등록
   public void insertVideo(VideoVO vVo){
       String sql = "insert into VIDEO(VNUM"
       			  + "				 , VTITLE"
       			  + "				 , VCONTENT"
       			  + "				 , VSUBJECT"
       			  + "				 , VURL"
       			  + "                , ADMINID) "
       			  + "values (VIDEO_SEQ.nextval, ?, ?, ?, ?, ?)";
      // VIDEO_SEQ.nextval
       
       Connection conn = null;
       PreparedStatement stmt = null;
       
       try{
          conn = getConnection();
          stmt = conn.prepareStatement(sql);
          
          stmt.setString(1, vVo.getvTitle());
          stmt.setString(2, vVo.getvContent());
          stmt.setString(3, vVo.getvSubject()); // code string 확인
          stmt.setString(4, vVo.getvUrl());
          stmt.setString(5, vVo.getadminId());
          
          stmt.executeUpdate();
          
       }catch(SQLException e){
          e.printStackTrace();
       
       }finally{
          dbClose();
       }    
       
   }
}