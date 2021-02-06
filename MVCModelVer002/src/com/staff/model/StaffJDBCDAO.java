package com.staff.model;

import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

public class StaffJDBCDAO implements StaffDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO staff (staaccnt,stapswd) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT stano , staaccnt, stapswd FROM staff";
	private static final String GET_ONE_STMT = "SELECT stano , staaccnt, stapswd FROM staff where stano = ?";
	private static final String GET_staff_ByStaffno_STMT = "SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";

//	private static final String DELETE_EMPs = "DELETE FROM emp2 where deptno = ?";
	private static final String DELETE = "DELETE FROM staff where stano = ?";

	private static final String UPDATE = "UPDATE staff set staaccnt=?, stapswd=? where stano = ?";

	@Override
	public void insert(StaffVO staffVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, staffVO.getStaaccnt());
			pstmt.setString(2, staffVO.getStapswd());

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
	public void update(StaffVO staffVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, staffVO.getStaaccnt());
			pstmt.setString(2, staffVO.getStapswd());
			pstmt.setInt(3, staffVO.getStano());

			int a = pstmt.executeUpdate();
			System.out.println(a);

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
	public void delete(Integer staffno) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, staffno);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public StaffVO findByPrimaryKey(Integer staffno) {
		StaffVO staffVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, staffno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				staffVO = new StaffVO();
				staffVO.setStano(rs.getInt("stano"));
				staffVO.setStaaccnt(rs.getString("staaccnt"));
				staffVO.setStapswd(rs.getString("stapswd"));
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
		return staffVO;
	}

	@Override
	public List<StaffVO> getAll() {
		List<StaffVO> list = new ArrayList<StaffVO>();
		StaffVO staffVO = null;
		
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
				staffVO = new StaffVO();
				staffVO.setStano(rs.getInt("stano"));
				staffVO.setStaaccnt(rs.getString("staaccnt"));
				staffVO.setStapswd(rs.getString("stapswd"));
				list.add(staffVO);
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



	public static void main(String[] args) {
		StaffJDBCDAO dao = new StaffJDBCDAO();

//		System.out.println(123);

		// insert test
//			StaffVO staffVO1 = new StaffVO();
//			staffVO1.setStaaccnt("Sandy");
//			staffVO1.setStapswd("123456");
//			dao.insert(staffVO1);

		// update test
//			StaffVO staffVO1 = new StaffVO();
//			staffVO1.setStano(2);
//			staffVO1.setStaaccnt("王枝1");
//			staffVO1.setStapswd("654321");
//			dao.update(staffVO1);

		// 查詢
//		StaffVO staffVO = dao.findByPrimaryKey(5);
//		System.out.print(staffVO.getStano() + ", ");
//		System.out.print(staffVO.getStaaccnt() + ", ");
//		System.out.println(staffVO.getStapswd());
//		System.out.println("---------------------");
		
		//get all
//		List<StaffVO> list = dao.getAll();
//		for(StaffVO staff:list) {
//			System.out.print(staff.getStano() + ", ");
//			System.out.print(staff.getStaaccnt() + ", ");
//			System.out.println(staff.getStapswd());
//			System.out.println("---------------------"); 
//		}
		//delete
//		dao.delete(5);
	}

}
