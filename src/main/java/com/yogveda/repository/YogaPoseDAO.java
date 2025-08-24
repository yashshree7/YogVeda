package com.yogveda.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yogveda.model.YogaPose;

@Repository
public class YogaPoseDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	public YogaPoseDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//Maps a DB row to YogaPose object
	private static class YogaPoseRowMapper implements RowMapper<YogaPose> {
		@Override
		public YogaPose mapRow(ResultSet rs, int rowNum) throws SQLException{
			YogaPose p = new YogaPose();
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setDescription(rs.getString("description"));
			p.setBenefits(rs.getString("benefits"));
			p.setDifficulty(rs.getString("difficulty"));
			p.setDuration(rs.getInt("duration"));
			p.setImageUrl(rs.getString("image_url"));
			return p;
		}
	}
	
	//CRUD
	
	//Get all poses
	public List<YogaPose> findAll(){
		String sql = "SELECT * FROM yoga_poses ORDER BY id DESC";
		return jdbcTemplate.query(sql, new YogaPoseRowMapper());
	}
	
	//Get pose by Id
	public Optional<YogaPose> findById(Long id){
		String sql = "SELECT * FROM yoga_poses WHERE id = ?";
		List<YogaPose> list = jdbcTemplate.query(sql, new YogaPoseRowMapper(), id);
		return list.stream().findFirst();
	}
	
	//Insert pose
	public int insert(YogaPose pose) {
		String sql = "INSERT INTO yoga_poses (name, description, benefits, difficulty, duration, image_url) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,pose.getName(), pose.getDescription(), pose.getBenefits(), pose.getDifficulty(), pose.getDuration(), pose.getImageUrl());
	}

    //Update pose
    public int update(Long id, YogaPose pose) {
    	String sql = "UPDATE yoga_poses SET name = ?, description = ?, benefits = ?, difficulty = ?, duration = ?, image_url = ? WHERE id = ?";
        return jdbcTemplate.update(sql, pose.getName(), pose.getDescription(), pose.getBenefits(), pose.getDifficulty(), pose.getDuration(), pose.getImageUrl(), id);
    }
	
    //Delete pose
	public int delete(Long id) {
		String sql = "DELETE FROM yoga_poses WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}
}
