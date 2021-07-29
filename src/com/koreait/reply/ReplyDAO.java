package com.koreait.reply;

import com.koreait.board.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.db.Dbconn;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";

	public void view_reply(ReplyDTO reply, BoardDTO board) {
		try {
			conn = Dbconn.getConnection();
			if (conn != null) {
				sql = "select re_idx, re_userid, re_content, re_regdate from tb_reply where re_boardidx=? order by re_idx desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getIdx());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					reply.setRe_idx(rs.getInt("re_idx"));
					reply.setRe_userid(rs.getString("re_userid"));
					reply.setRe_content(rs.getString("re_content"));
					reply.setRe_regdate(rs.getString("re_regdate"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int add_reply(ReplyDTO reply, BoardDTO board) {
		try {

			conn = Dbconn.getConnection();
			if (conn != null) {
				sql = "insert into tb_reply (re_userid, re_content, re_boardidx) values (?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getUserid());
				pstmt.setString(2, reply.getRe_content());
				pstmt.setInt(3, board.getIdx());
				if(pstmt.executeUpdate() >0) {
					return 1;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
