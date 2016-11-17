package com.prongbang.sec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prongbang.sec.dao.AuthoritiesDao;
import com.prongbang.sec.model.Authorities;
import com.prongbang.sec.utils.MapperUtil;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public int add(Authorities entity) throws Exception {
		
		String sql = "INSERT INTO authorities (username, authority) VALUES (?, ?)";

		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, entity.getUsername());
				ps.setString(2, entity.getAuthority());

				return ps;
			}
		});

		return result;
	}

	@Override
	public int update(Authorities entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Authorities entity) throws Exception {
		 
		String sql = "DELETE FROM authorities WHERE username = ?"; 
		
		return jdbcTemplate.update(sql, entity.getUsername());
	}

	@Override
	public List<Authorities> findAll() throws Exception {

		try {
			
			String sql = "SELECT username, authority FROM authorities";
			
			return jdbcTemplate.query(sql, new AuthoritiesMapper());
			
		} catch(EmptyResultDataAccessException e) {
			
			return null;
		}
	}

	@Override
	public Authorities findById(Authorities entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authorities> findByUsername(String username) throws Exception {
		
		try {
			
			String sql = "SELECT username, authority FROM authorities WHERE username = :username";
			
			Map<String, String> paramMap = new HashMap<String, String>();
			
			paramMap.put("username", username);
		
			return namedParameterJdbcTemplate.query(sql, paramMap, new AuthoritiesMapper());
			
		} catch(EmptyResultDataAccessException e) {
			
			return null;
		}
	}
	
	private static final class AuthoritiesMapper implements RowMapper<Authorities> {
		@Override
		public Authorities mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Authorities auth = new Authorities();
			auth.setUsername(MapperUtil.getString(rs, "username"));
			auth.setAuthority(MapperUtil.getString(rs, "authority"));
		
			return auth;
		}
	}
	
}
