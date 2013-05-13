package cn.edu.dhu.score.analyze.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.edu.dhu.score.analyze.dao.EtlDAO;

public class EtlDAOImpl implements EtlDAO {

	private static final Logger logger = LoggerFactory.getLogger(EtlDAOImpl.class.getName());

	/* JdbcTemplate */
	private JdbcTemplate jdbcTemplate;

	/* set to inject the proxy class of jdbcTemplate */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSidList(String tableName, final String fieldName) {
		List<String> idList = new ArrayList<String>();
		idList = (List<String>) jdbcTemplate.query("select DISTINCT " + fieldName + " from " + tableName, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String s_temp = rs.getString(fieldName);
				return s_temp;
			}
		});
		return idList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getScoreCluster(String tableName, final String itemIdName, String sid, String sidFieldName) {
		List<String> itemIdSet = new ArrayList<String>();
		logger.info("select " + itemIdName + " from " + tableName + " where " + sidFieldName + " = '" + sid+"'");

		itemIdSet = (ArrayList<String>) jdbcTemplate.query("select " + itemIdName + " from " + tableName + " where " + sidFieldName + " = '" + sid+"'", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				/LinkedHashSet<String> list = new LinkedHashSet<String>();
				String ii = rs.getString(1);
				String ss = ii+"l";
				String iis = rs.getString(itemIdName);
				String s_temp = rs.getString(1);
				return s_temp;
			}
		});
		return itemIdSet;
	}

	public boolean insertIntoScore(String tableName, String sidFieldName, final String sid, final String score) {
		final String addSql = "insert into " + tableName + "(SID,USERTYPE,GENDER,BIRTHDAY, PLACECODE,PLACE,COUNTRY,COLLEGE, MARJOR, SCORE) VALUES(?,?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(addSql, new String[] { "id" });// 返回id
				List<String> list = getSingleRecord("GPA", "sid", sid);
				for (int i = 0; i < list.size(); i++) {
					ps.setString(i + 1, list.get(i));
					// ps.setString(2, actor.getLastName());
				}
				ps.setString(10, score);
				return ps;
			}

		});
		System.out.println(keyHolder.getKey());
		if (keyHolder.getKey() != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<String> getSingleRecord(String tableName, final String fieldName, String sid) {
		final List<String> valuesList = new ArrayList<String>();
		jdbcTemplate.query("select * from " + tableName + " where " + fieldName + " ='" + sid + "' limit 1",new RowCallbackHandler() {
			  public void processRow(ResultSet rs) throws SQLException {
				// SID,USERTYPE,GENDER,BIRTHDAY,
				// PLACECODE,PLACE,COUNTRY,COLLEGE, MARJOR, CLAZZ
				valuesList.add(rs.getString("SID"));
				valuesList.add(rs.getString("USERTYPE"));
				valuesList.add(rs.getString("GENDER"));
				valuesList.add(rs.getString("BIRTHDAY"));
				valuesList.add(rs.getString("PLACECODE"));
				valuesList.add(rs.getString("PLACE"));
				valuesList.add(rs.getString("COUNTRY"));
				valuesList.add(rs.getString("COLLEGE"));
				valuesList.add(rs.getString("MARJOR"));
				//valuesList.add(rs.getString("CLAZZ")); 
			}
		});
		return valuesList;
	}
	/*
	 * 上面的都是为了给别的表使用，现在下面的类是给 SCORE 表专用.考虑分页效果
	 */
	//------------------------------------------------------
	public List<Map<String,String>> getItems(String tableName, int pageCount, long curPage) {
		String sql = 
		"SELECT TOP "+pageCount+" * FROM SCORE WHERE id NOT IN(SELECT TOP "+pageCount*(curPage-1)+" id FROM SCORE ORDER BY id)ORDER BY id";

		          return jdbcTemplate.query(sql, new RowMapper<Map<String,String>>() {
		              public Map<String,String> mapRow(ResultSet rs, int index) throws SQLException {
		            	  Map<String,String> student = new HashMap<String,String>();
		            	 //目前只取得 地域，成绩，生日
		            	 // student.put("id",rs.getString("ID"));
		            	 //student.put("",rs.getString("SID"));
		            	 //student.put("",rs.getString("USERTYPE"));
		            	 //student.put("",rs.getString("GENDER"));
		            	 student.put("birthday",rs.getString("BIRTHDAY"));
		            	 //student.put("",rs.getString("PLACECODE"));
		            	 student.put("place",rs.getString("PLACE"));
		            	 //student.put("",rs.getString("COUNTRY"));
		            	// student.put("college",rs.getString("COLLEGE"));
		            	 //student.put("",rs.getString("MARJOR"));
		            	 student.put("score",rs.getString("SCORE"));
		                return student;
		             }
		         });
	}
	
	public String getTest() {
		final StringBuffer sss = new StringBuffer();
		String sql = "select id from test limit 1";
			
		jdbcTemplate.query(sql,new RowCallbackHandler() {
			  public void processRow(ResultSet rs) throws SQLException {
			  
				  sss.append(rs.getString("id"));
			  }
		});
		return sss.toString();
	}

}