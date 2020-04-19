package com.amsidh.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.amsidh.mvc.dtos.Circle;

public class CircleDaoImpl {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void createCircle()
	{
		String sql="CREATE TABLE CIRCLE (CIRCLEID INTEGER,CIRCLENAME VARCHAR(50))";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sql);
	}
	
	public boolean saveCircle(Circle circle)
	{
	    String sql="INSERT INTO CIRCLE VALUES(:circleId,:circleName)";
	    Map<String,Object> paramMap=new HashMap<String, Object>();
	    paramMap.put("circleId", circle.getCircleId());
	    paramMap.put("circleName", circle.getCircleName());
	    namedParameterJdbcTemplate.update(sql, paramMap);
		return true;
	}
	
	public Circle getCircleByCircleId(Integer circleId)
	{
		String sql="SELECT * FROM CIRCLE WHERE CIRCLEID = :circleId";
		Map<String,Object> paramMap=new HashMap<String, Object>();
	    paramMap.put("circleId", circleId);
	    return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new CircleRowMapper());
	}
	
	public List<Circle> getAllCircle()
	{
		String sql="SELECT * FROM CIRCLE WHERE CIRCLEID > :circleId";
		Map<String,Object> paramMap=new HashMap<String, Object>();
	    paramMap.put("circleId", 0);
	    return namedParameterJdbcTemplate.query(sql, paramMap, new CircleRowMapper());
		
		
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
  private static final class CircleRowMapper implements RowMapper<Circle>
  {

	@Override
	public Circle mapRow(ResultSet rst, int rowNumber) throws SQLException {
		Circle circle=new Circle();
		circle.setCircleId(rst.getInt("CIRCLEID"));
		circle.setCircleName(rst.getString("CIRCLENAME"));
		return circle;
	}
	  
  }
}
