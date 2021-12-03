package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.ArrayList;
import dto.PlaylistDto;

public class PlaylistDaoImpl implements PlaylistDao {
	private Connection conn; // DB 커넥션 연결 객체
	private static final String USERNAME = "root";// DBMS접속 시 아이디
	private static final String PASSWORD = "1234";// DBMS접속 시 비밀번호
	private static final String URL = "jdbc:mysql://localhost:3306/aidb";// DBMS접속할 db명

	public PlaylistDaoImpl() {
		// 디비 연결 부분
		// 디비 연결 부분
		try {
			System.out.println("생성자");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	@Override
	public void insert(PlaylistDto dto) {
		String sql = "INSERT INTO step_up_ost (Title, Artist, Album, Playtime) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getArtist());
			pstmt.setString(3, dto.getAlbum());
			pstmt.setString(4, dto.getPlaytime());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("데이터 삽입 성공!");

			}

		} catch (Exception e) {
			System.out.println("데이터 삽입 실패!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}

	@Override
	public PlaylistDto selectOne(int n) {
		String sql = "SELECT * FROM step_up_ost WHERE num = ?";
		PlaylistDto dto = new PlaylistDto();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("Title"));
				dto.setArtist(rs.getString("Artist"));
				dto.setAlbum(rs.getString("Album"));
				dto.setPlaytime(rs.getString("Playtime"));
			}

		} catch (Exception e) {
			System.out.println("SELECT 메서드 예외발생");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}
		return dto;
	}
	
	public int selectTitleArtist(String Title, String Artist) {
		String sql = "SELECT num FROM step_up_ost WHERE Title = ? AND Artist = ?";
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Title);
			pstmt.setString(2, Artist);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("num");
			}

		} catch (Exception e) {
			System.out.println("SELECT 메서드 예외발생");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}
		return num;
	}

	

	@Override
	public void update(PlaylistDto dto) {
		String sql = "UPDATE step_up_ost SET email = ? WHERE  num = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
//			pstmt.setString(1, dto.getEmail());
			pstmt.setInt(2, dto.getNum());
			pstmt.executeUpdate();
//			System.out.println("수정된 id: " + id);

		} catch (Exception e) {
			System.out.println("update 예외 발생");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}

	@Override
	public ArrayList<PlaylistDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
