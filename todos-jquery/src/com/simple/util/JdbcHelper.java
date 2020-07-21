package com.simple.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBCë¥? ???©í?? DB Access ?????? ?¨ì???????? ?¬í???´ë???? ??????.
 * @author JHTA
 *
 */
public class JdbcHelper {
	
	/**
	 * INSERT ?????? ????????.
	 * @param sql ?¤í???? ì¿¼ë¦¬
	 * @param params ì¿¼ë¦¬ ?¤í???? ?????? ê°?, ???µí?? ?? ????.
	 * @throws SQLException
	 */
	public static void insert(String sql, Object... params) {
		executeUpdate(sql, params);		
	} 
	
	/**
	 * UPDATE ?????? ????????.
	 * @param sql ?¤í???? ì¿¼ë¦¬
	 * @param params ì¿¼ë¦¬ ?¤í???? ?????? ê°?, ???µí?? ?? ????.
	 * @throws SQLException
	 */
	public static void update(String sql, Object... params) {
		executeUpdate(sql, params);
	} 
	
	/**
	 * DELETE ?????? ????????.
	 * @param sql ?¤í???? ì¿¼ë¦¬
	 * @param params ì¿¼ë¦¬ ?¤í???? ?????? ê°?, ???µí?? ?? ????.
	 * @throws SQLException
	 */
	public static void delete(String sql, Object... params) {
		executeUpdate(sql, params);
	} 
	
	/**
	 * SELECT ?????? ????????.<br />
	 * ?¨ì?? ???? ì¡°í???´ì?? ë°???????.
	 * @param <T> ì¡°í???? ??ì½??? ????ë¥? ???¥í?? ê°?ì²´ì?? ????
	 * @param sql ?¤í???? SQL ì¿¼ë¦¬
	 * @param rowMapper ResultSet?? ê°?ì²´ì?? ë§¤í?????¤ë?? RowMapper êµ¬í??ê°?ì²?
	 * @param params ì¿¼ë¦¬ ?¤í???? ?????? ê°?, ???µí?? ?? ????.
	 * @return ì¡°í???? ê²°ê³¼, ì¡°í???? ê°??? ???? ê²½ì?? null?? ë°?????ê³?, ???? ?´ì?? ì¡°í?????? ê²½ì?? ???¸ë?? ë°??????¨ë??.
	 * @throws SQLException
	 */
	public static <T> T selectOne(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> result = executeQuery(sql, rowMapper, params);
		if (result.isEmpty()) {
			return null;
		} 
		if (result.size() > 1) {
			throw new RuntimeException("???? ?´ì???? ê²°ê³¼ê°? ì¡°í???????µë????.");
		}
		return result.get(0);
	}
	
	/**
	 * SELECT ?????? ????????.<br />
	 * ?¬ë?? ???? ì¡°í???´ì?? ë°???????.
	 * @param <T> ì¡°í???? ??ì½??? ????ë¥? ???¥í?? ê°?ì²´ì?? ????
	 * @param sql ?¤í???? SQL ì¿¼ë¦¬
	 * @param rowMapper ResultSet?? ê°?ì²´ì?? ë§¤í?????¤ë?? RowMapper êµ¬í??ê°?ì²?
	 * @param params ì¿¼ë¦¬ ?¤í???? ?????? ê°?, ???µí?? ?? ????.
	 * @return ì¡°í???? ê²°ê³¼, ì¡°í???? ê°??? ???? ê²½ì?? ë¹? Listê°?ì²´ê? ë°???????.
	 * @throws SQLException
	 */
	public static <T> List<T> selectList(String sql, RowMapper<T> rowMapper, Object... params) {
		return executeQuery(sql, rowMapper, params);
	}
	
	private static void before(String sql) throws SQLException {
		ThreadRepository.remove();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		ThreadRepository.setConnection(connection);
		ThreadRepository.setPreparedStatement(pstmt);
	}
	
	private static void setParams(Object...params) throws SQLException {
		if (params.length != 0) {
			
			PreparedStatement pstmt = ThreadRepository.getPreparedsStatement();
			for (int i=0; i<params.length; i++) {
				Object param = params[i];
				if (param instanceof String) {
					pstmt.setString(i+1, (String) param);
				} else if (param instanceof Integer) {
					pstmt.setInt(i+1, (Integer) param);
				} else if (param instanceof Long) {
					pstmt.setLong(i+1, (Long) param);
				} else if (param instanceof Double) {
					pstmt.setDouble(i+1, (Double) param);
				} else if (param instanceof Date) {
					java.sql.Date date = new java.sql.Date(((Date) param).getTime());
					pstmt.setDate(i+1, date);
				}
			}
		}
	}
	
	private static void after()  {
		Connection connection = ThreadRepository.getConnection();
		PreparedStatement pstmt = ThreadRepository.getPreparedsStatement();
		ResultSet rs = ThreadRepository.getResultSet();
		
		try {
			if (rs != null) {
				rs.close();
			}			
		} catch (SQLException e) {}
		try {
			if (pstmt != null) {
				pstmt.close();
			}		
		} catch (SQLException e) {}
		try {
			if (connection != null) {
				connection.close();
			}		
		} catch (SQLException e) {}
	}
	
	private static void executeUpdate() throws SQLException {
		ThreadRepository.getPreparedsStatement().executeUpdate();
	}
	
	private static void executeUpdate(String sql, Object...params) {
		try {
			before(sql);
			setParams(params);
			executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			after();
		}
	}

	private static ResultSet executeQuery() throws SQLException {
		ResultSet rs = ThreadRepository.getPreparedsStatement().executeQuery();
		ThreadRepository.setResultSet(rs);
		return rs;
	}
	
	private static <T> List<T> resultSetHandering(ResultSet rs, RowMapper<T> rowMapper) throws SQLException {
		List<T> result = new ArrayList<T>();
		while (rs.next()) {
			result.add(rowMapper.mapRow(rs));
		}
		return result;
	}
	
	private static <T> List<T> executeQuery(RowMapper<T> rowMapper) throws SQLException {
		return resultSetHandering(executeQuery(), rowMapper);
	}
	
	private static <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object...params) {
		try {
			List<T> result = null;
			before(sql);
			setParams(params);
			result = executeQuery(rowMapper);
			
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			after();			
		}
	}
	
	private static class ThreadRepository {
		private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>() {
			protected Map<String, Object> initialValue() {
				return new HashMap<>();
			}
		};
		
		public static Connection getConnection() {
			return (Connection) threadLocal.get().get("connection");
		}
		
		public static PreparedStatement getPreparedsStatement() {
			return (PreparedStatement) threadLocal.get().get("pstmt");
		}
		
		public static ResultSet getResultSet() {
			return (ResultSet) threadLocal.get().get("rs");
		}
		
		public static void setConnection(Connection connection) {
			threadLocal.get().put("connection", connection);
		}
		
		public static void setPreparedStatement(PreparedStatement pstmt) {
			threadLocal.get().put("pstmt", pstmt);
		}
		
		public static void setResultSet(ResultSet rs) {
			threadLocal.get().put("rs", rs);
		}
		
		public static void remove() {
			threadLocal.remove();
		}
	}
	
	/**
	 * ResultSetë¥? ì§????? ?????? ê°?ì²´ë? ë§¤í?????¨ë??.
	 * @author JHTA
	 *
	 * @param <T> ResultSet?¼ë? ì¡°í???? ?°ì?´í?°ë?? ???¥í?? ê°?ì²´ì?? ????
	 */
	public static interface RowMapper<T> {
		/**
		 * ResultSet?¼ë? ì¡°í???? ??ì½??? ????ë¥? ì§????? ê°?ì²´ì?? ?´ì???? ë°???????.
		 * @param rs ResultSetê°?ì²?
		 * @return ??ì½???ê°? ???¥ë?? ê°?ì²?
		 * @throws SQLException
		 */
		T mapRow(ResultSet rs) throws SQLException;
	}
	
}
