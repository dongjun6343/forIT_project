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
                  + "      , VDATE"
                  + "      , VCONTENT"
                  + "      , VSUBJECT"
                  + "      , VURL"
                  + "      , VCOUNT"
                  + "      , ADMINID "
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
               vVo.setAdminID(rs.getString("adminId"));
                
               
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
                  + "             , VTITLE"
                  + "             , VCONTENT"
                  + "             , VSUBJECT"
                  + "             , VURL"
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
          stmt.setString(5, vVo.getAdminId());
          
          stmt.executeUpdate();
          
       }catch(SQLException e){
          e.printStackTrace();
       
       }finally{
          dbClose();
       }    
       
   }
 //강의자료 상세보기 : 글 번호로 찾아온다 : 실패 null;
 	public VideoVO selectOneVideoByNum(String vNum){
 		String sql = "SELECT VNUM "
                + "     , VTITLE"
                + "      , VDATE"
                + "      , VCONTENT"
                + "      , VSUBJECT"
                + "      , VURL"
                + "      , VCOUNT"
                + "      , ADMINID "
                + "  FROM VIDEO where VNUM = ?";
 		
 		VideoVO vVo = null;
 		Connection conn = null;
 		PreparedStatement stmt = null;
 		ResultSet rs = null;
 	
 		try{
 			conn = getConnection();
 			stmt = conn.prepareStatement(sql);
 			
 			stmt.setString(1, vNum);
 			
 			rs = stmt.executeQuery();
 			
 			if(rs.next()){
 				vVo = new VideoVO();
 				vVo.setvNum(rs.getInt("vNum"));
                vVo.setvTitle(rs.getString("vTitle"));
                vVo.setvDate(rs.getTimestamp("vDate"));
                vVo.setvContent(rs.getString("vContent"));
                vVo.setvSubject(rs.getString("vSubject"));
                vVo.setvUrl(rs.getString("vUrl"));
                vVo.setvCount(rs.getInt("vCount"));
                vVo.setAdminID(rs.getString("adminId"));
 			}
 		}catch(SQLException e){
 			e.printStackTrace();
 		}
 		return vVo;
 	}
 	//비디오 수정
	public void updateVideo(VideoVO vVo){
		String sql = "UPDATE NOTICE SET VTITEL=?,VCONTENT=?,VSUBJECT=?,VURL=? WHERE VNUM=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vVo.getvTitle());
			stmt.setString(2, vVo.getvContent());
			stmt.setString(3, vVo.getvSubject());
			stmt.setString(4, vVo.getvUrl());
			stmt.setInt(5, vVo.getvNum());
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbClose();
		}
	}
}