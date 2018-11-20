package com.forit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.forit.dto.NoticeVO;


public class NoticeDAO extends CommonDAO {
	private static NoticeDAO instance;
	
	public static NoticeDAO getInstance() {
		if (instance == null) {
			instance = new NoticeDAO();
		}
		return instance;
	}

	// 등록 조회
	public List<NoticeVO> selectAllNotices() {

		String sql = "SELECT NNUM"
				+ "        , NTITLE"
				+ "        , NDATE"
				+ "		   , NCONTENT"
				+ "		   , NCOUNT"
				+ "		   , NMUST"
				+ "		   , ADMINID FROM NOTICE";

		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();

				nVo.setnNum(rs.getInt("nNum"));
				nVo.setnTitle(rs.getString("nTitle"));
				nVo.setnDate(rs.getTimestamp("nDate"));
				nVo.setnContent(rs.getString("nContent"));
				nVo.setnCount(rs.getInt("nCount"));
				nVo.setnMust(rs.getString("nMust").charAt(0)); // string 형식을 char형으로 형변환
				nVo.setAdminId(rs.getString("adminId"));

				list.add(nVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 공지 등록
	public void insertNotice(NoticeVO nVo) {
		String sql = "insert into NOTICE (NNUM"
				   + "					, NTITLE"
				   + "					, NCONTENT"
				   + "					, NCOUNT"
				   + "					, NMUST"
				   + "					, ADMINID) "
				   + "			 values (NOTICE_SEQ.nextval"
				   + "                  , ?"
				   + "                  , ?"
				   + "                  , ?"
				   + "                  , ?"
				   + "					, ?)";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, nVo.getnTitle());
			stmt.setString(2, nVo.getnContent());
			stmt.setInt(3, nVo.getnCount());
			stmt.setLong(4, nVo.getnMust());
			stmt.setString(5, nVo.getAdminId());
			
			
/*//		stmt.setInt(1, nVo.getNNUM());
			stmt.setString(2, nVo.getnTitle());
//			stmt.setString(3, nVo.getNDATE().toString().substring(0, 19)); X
//			stmt.setTimestamp(3, nVo.getNDATE()); O sysdate로 불러오기 때문에 넣을 필요X
			stmt.setString(4, nVo.getnContent());
//			stmt.setInt(5, nVo.getNCOUNT());
//			stmt.setString(6, ("" + nVo.getnMust())); 코드화 default 값을 0으로 줌
			stmt.setString(7, nVo.getAdminId());*/

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			dbClose();
		}

	}

}