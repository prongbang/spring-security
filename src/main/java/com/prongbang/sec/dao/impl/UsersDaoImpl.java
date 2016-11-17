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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.prongbang.sec.dao.UsersDao;
import com.prongbang.sec.model.Users;
import com.prongbang.sec.utils.HashingUtil;
import com.prongbang.sec.utils.MapUtil;
import com.prongbang.sec.utils.MapperUtil;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int add(Users entity) throws Exception {

		String sql = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";

		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, entity.getUsername());
				ps.setString(2, HashingUtil.sha256(entity.getPassword()));
				ps.setInt(3, entity.isEnabled());

				return ps;
			}
		});

		return result;
	}

	@Override
	public int update(Users entity) throws Exception {

		int index = 1;
		StringBuilder sql = new StringBuilder();
		Map<String, Object> mapIndex = new HashMap<String, Object>();

		sql.append(" UPDATE users SET ");

		if (entity.getPassword() != null) {
			sql.append(" password = ?, ");
			mapIndex.put("password", index++);
		}

		if (entity.isEnabled() != null) {
			sql.append(" enabled = ?, ");
			mapIndex.put("enabled", index++);
		}

		sql.deleteCharAt(sql.lastIndexOf(","));

		sql.append(" WHERE username = ? ");
		mapIndex.put("username", index++);

		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(sql.toString());

				Integer idxUser = MapUtil.getInteger(mapIndex, "username");
				Integer idxPass = MapUtil.getInteger(mapIndex, "password");
				Integer idxEnab = MapUtil.getInteger(mapIndex, "enabled");

				if (idxUser != null) {
					ps.setString(idxUser, entity.getUsername());
				}

				if (idxPass != null) {
					ps.setString(idxPass, HashingUtil.sha256(entity.getPassword()));
				}

				if (idxEnab != null) {
					ps.setInt(idxEnab, entity.isEnabled());
				}

				return ps;
			}

		});

		return result;
	}

	@Override
	public int delete(Users entity) throws Exception {
		
		String sql = "DELETE FROM users WHERE username = ?";
		
		return jdbcTemplate.update(sql, entity.getUsername());
	}

	@Override
	public List<Users> findAll() throws Exception {

		try {
			
			String sql = "SELECT username, password, enabled FROM users";
	
			return jdbcTemplate.queryForList(sql, Users.class);
			
		} catch(EmptyResultDataAccessException e) {
			
			return null;
		}
	}

	@Override
	public Users findById(Users entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByUsername(String username) throws Exception {

		try {
			
			String sql = "SELECT username, password, enabled FROM users WHERE username = :username";

			Map<String, String> paramMap = new HashMap<String, String>();

			paramMap.put("username", username);

			SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
			
			return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UsersMapper());
			
		} catch(EmptyResultDataAccessException e) {
			
			return null;
		}
	}

	private static final class UsersMapper implements RowMapper<Users> {
		@Override
		public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

			Users user = new Users();
			user.setUsername(MapperUtil.getString(rs, "username"));
			user.setPassword(MapperUtil.getString(rs, "password"));
			user.setEnabled(MapperUtil.getInteger(rs, "enabled"));

			return user;
		}
	}

}
