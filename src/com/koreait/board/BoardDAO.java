package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.db.Dbconn;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	public BoardDTO updateLike(BoardDTO board) {
		 try {
		    	conn = Dbconn.getConnection();
		    	if(conn!=null){
		    		  sql = "update tb_board set b_like=b_like+1 where b_idx=?";
		        	  pstmt = conn.prepareStatement(sql);
		        	  pstmt.setInt(1, board.getIdx());
		        	  pstmt.executeUpdate();
		        	  
		        	  
		        	  sql = "select b_like from tb_board where b_idx=?";
		        	  pstmt = conn.prepareStatement(sql);
		        	  pstmt.setInt(1, board.getIdx());
		        	  rs = pstmt.executeQuery();
		        	  
		        	  if(rs.next()){
		        		  board.setLike(rs.getInt("b_like"));
		        		  //out.print(board.getLike());
		        		  //b_like = rs.getInt("b_like");
		        		  //out.print(b_like);
		        	  }
		    	}
		    	
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
   	  	return board;

		 }

	 public int write(BoardDTO board) {
	      try {
	         conn = Dbconn.getConnection();
	         if (conn != null) {
	            sql = "insert into tb_board(b_userid, b_title, b_content, b_file) values(?, ?, ?,?)";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, board.getUserid());
	            pstmt.setString(2, board.getTitle());
	            pstmt.setString(3, board.getContent());
	            pstmt.setString(4, board.getFile());
	            if(pstmt.executeUpdate() > 0){
	               return 1;
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return 0;
	   }

	 
	 
	public int delete(BoardDTO board) {
		try {
			conn = Dbconn.getConnection();
			if (conn != null) {
				sql = "delete from tb_board where b_idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getIdx());
				if(pstmt.executeUpdate() > 0) {
					return 1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int edit(BoardDTO board) {
		try {
			conn = Dbconn.getConnection();
			if(conn != null){
				// 파일이 존재할 때
				if(board.getFile() != null && !board.getFile().equals("")){
					sql = "update tb_board set b_title=?, b_content=?, b_file=? where b_idx=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, board.getTitle());
					pstmt.setString(2, board.getContent());
					pstmt.setString(3, board.getFile());
					pstmt.setInt(4, board.getIdx());
				}else{	//파일이 존재하지 않을 때
					sql = "update tb_board set b_title=?, b_content=? where b_idx=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,board.getTitle());
					pstmt.setString(2, board.getContent());
					pstmt.setInt(3, board.getIdx());
				}
				pstmt.executeUpdate();
			}return 1;
		}catch(Exception e) {
		e.printStackTrace();
		}
		return 0;
	}
	
	
	public void view(BoardDTO board) {
		try{
			conn = Dbconn.getConnection();
			if(conn != null){
				sql = "update tb_board set b_hit = b_hit + 1 where b_idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getIdx());
				pstmt.executeUpdate();
				
				sql = "select b_idx, b_userid, b_title, b_content, b_regdate, b_like, b_hit, b_file from tb_board where b_idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getIdx());
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					board.setUserid(rs.getString("b_userid"));
					board.setTitle(rs.getString("b_title"));
					board.setContent(rs.getString("b_content"));
					board.setRegdate(rs.getString("b_regdate"));
					board.setLike(rs.getInt("b_like"));
					board.setHit(rs.getInt("b_hit"));
					board.setFile(rs.getString("b_file"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
}





