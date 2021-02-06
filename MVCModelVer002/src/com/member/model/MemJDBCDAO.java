package com.member.model;

import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

public class MemJDBCDAO implements MemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hairtopia?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO MEMBER (mem_name, mem_email, mem_pswd) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT mem_name, mem_email, mem_pswd FROM MEMBER";
	private static final String GET_ONE_STMT = "SELECT mem_name, mem_email, mem_pswd FROM MEMBER where mem_no = ?";
	private static final String GET_staff_ByStaffno_STMT = "SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";

//	private static final String DELETE_EMPs = "DELETE FROM emp2 where deptno = ?";
	private static final String DELETE = "DELETE FROM MEMBER where mem_no = ?";

	private static final String UPDATE = "UPDATE MEMBER set mem_name=?, mem_email=?, mem_pswd= ? where mem_no = ?";

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
				memVO.setMemName(rs.getString("mem_name"));
				memVO.setMemEmail(rs.getString("mem_email"));
				memVO.setMemPswd(rs.getString("mem_pswd"));
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
				memVO = new MemVO();
				memVO.setMemName(rs.getString("mem_name"));
				memVO.setMemEmail(rs.getString("mem_email"));
				memVO.setMemPswd(rs.getString("mem_pswd"));
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

		// update test
//			MemVO memVO1 = new MemVO();
//			memVO1.setMemNo(2);
//			memVO1.setMemName("KING2");
//			memVO1.setMemEmail("PRESIDENT2@sss");
//			memVO1.setMemPswd("123456");
//			dao.update(memVO1);

		// 查詢
//		MemVO memVO = dao.findByPrimaryKey(2);
//		System.out.print(memVO.getMemNo() + ", ");
//		System.out.print(memVO.getMemName() + ", ");
//		System.out.print(memVO.getMemEmail() + ", ");
//		System.out.println(memVO.getMemPswd());
//		System.out.println("---------------------");

		// get all
		List<MemVO> list = dao.getAll();
		for (MemVO mem : list) {
			System.out.print(mem.getMemName() + ", ");
			System.out.print(mem.getMemEmail() + ", ");
			System.out.println(mem.getMemPswd());
			System.out.println("---------------------");
		}
		// delete
//		dao.delete(7);
	}

}
