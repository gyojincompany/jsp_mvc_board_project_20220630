package com.gyojincompany.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {

	DataSource datasource;//server context.xml 확인

	public BDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/odbo");
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void write(String bname, String btitle, String bcontent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO mvc_board(bname,btitle,bcontent,bhit) VALUES (?,?,?,0)";
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
