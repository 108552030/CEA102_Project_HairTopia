package com.member.model;

import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

public class MemJDBCDAO implements MemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hairtopia?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	// memNo,memName,memGender,memPic,memInform,memEmail,memPswd,memPhone,memAddr,memBal,memStatus,memEndDate,
	// memCode

	private static final String INSERT_STMT = "INSERT INTO MEMBER (memName, memEmail, memPswd) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM MEMBER";
	private static final String GET_ONE_STMT = "SELECT memNO, memName, memEmail, memPswd FROM MEMBER WHERE memNO = ?";
	private static final String VALIDATE_STMT = "SELECT * FROM MEMBER WHERE memEmail=? AND memPswd=?";
	private static final String DELETE = "DELETE FROM MEMBER WHERE memNO = ?";
	private static final String UPDATE = "UPDATE MEMBER set memName=?, memEmail=?, memPswd= ? WHERE memNO = ?";

	@Override
	public void insert(MemVO memVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, memVO.getMemName());
			pstmt.setString(2, memVO.getMemEmail());
			pstmt.setString(3, memVO.getMemPswd());
//			pstmt.setString(12, memVO.getMemCode());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(MemVO memVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memVO.getMemName());
			pstmt.setString(2, memVO.getMemEmail());
			pstmt.setString(3, memVO.getMemPswd());
			pstmt.setInt(4, memVO.getMemNo());

			int a = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer memNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public MemVO findByPrimaryKey(Integer memNo) {
		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				memVO = new MemVO();
				memVO.setMemNo(rs.getInt("memNO"));
				memVO.setMemName(rs.getString("memName"));
				memVO.setMemEmail(rs.getString("memEmail"));
				memVO.setMemPswd(rs.getString("memPswd"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memVO;
	}

	@Override
	public List<MemVO> getAll() {
		List<MemVO> list = new ArrayList<MemVO>();
		MemVO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				//memName,memGender,memPic,memInform,memEmail,memPswd,memPhone,memAddr,memBal,memStatus,memEndDate, memCode
				memVO = new MemVO();
				memVO.setMemNo(rs.getInt("memNo"));
				memVO.setMemName(rs.getString("memName"));
				memVO.setMemGender(rs.getInt("memGender"));
//				memVO.setMemPic(rs.getBytes("memPic"));
				memVO.setMemInform(rs.getString("memInform"));
				memVO.setMemEmail(rs.getString("memEmail"));
				memVO.setMemPswd(rs.getString("memPswd"));
				memVO.setMemPhone(rs.getString("memPhone"));
				memVO.setMemAddr(rs.getString("memAddr"));
				memVO.setMemBal(rs.getInt("memBal"));
				memVO.setMemStatus(rs.getInt("memStatus"));
				memVO.setMemEndDate(rs.getDate("memEndDate"));
				memVO.setMemCode(rs.getString("memCode"));
				
				list.add(memVO);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public boolean validate(MemVO memVO) {
		return false;
	}

	public static void main(String[] args) {
		MemJDBCDAO dao = new MemJDBCDAO();

//		System.out.println(123);

//		 insert test
//			MemVO memVO1 = new MemVO();
//			memVO1.setMemName("Sandy");
//			memVO1.setMemEmail("PRESIDENT7@sss");
//			memVO1.setMemPswd("123456");
//			dao.insert(memVO1);

//		 update test
//			MemVO memVO1 = new MemVO();
//			memVO1.setMemNo(12);
//			memVO1.setMemName("KING2");
//			memVO1.setMemEmail("PRESIDENT2312@sss");
//			memVO1.setMemPswd("123456");
//			dao.update(memVO1);

		// 查詢
//		MemVO memVO = dao.findByPrimaryKey(2);
//		System.out.print(memVO.getMemNo() + ", ");
//		System.out.print(memVO.getMemName() + ", ");
//		System.out.print(memVO.getMemGender() + ", ");
//		System.out.print(memVO.getMemPic() + ", ");
//		System.out.print(memVO.getMemInform() + ", ");
//		System.out.print(memVO.getMemEmail()+ ", ");
//		System.out.print(memVO.getMemPswd() + ", ");
//		System.out.print(memVO.getMemPhone() + ", ");
//		System.out.print(memVO.getMemAddr() + ", ");
//		System.out.print(memVO.getMemBal() + ", ");
//		System.out.print(memVO.getMemStatus() + ", ");
//		System.out.print(memVO.getMemEndDate()+ ", ");
//		System.out.println(memVO.getMemCode());
//		System.out.println("--------------------------------------------------------------------------------------");

		// get all
//		List<MemVO> list = dao.getAll();
//		for (MemVO mem : list) {
//			System.out.print(mem.getMemNo() + ", ");
//			System.out.print(mem.getMemName() + ", ");
//			System.out.print(mem.getMemGender() + ", ");
//			System.out.print(mem.getMemPic() + ", ");
//			System.out.print(mem.getMemInform() + ", ");
//			System.out.print(mem.getMemEmail()+ ", ");
//			System.out.print(mem.getMemPswd() + ", ");
//			System.out.print(mem.getMemPhone() + ", ");
//			System.out.print(mem.getMemAddr() + ", ");
//			System.out.print(mem.getMemBal() + ", ");
//			System.out.print(mem.getMemStatus() + ", ");
//			System.out.print(mem.getMemEndDate()+ ", ");
//			System.out.println(mem.getMemCode());
//			System.out.println("--------------------------------------------------------------------------------------");
//		}
		// delete
		dao.delete(12);
	}

}
