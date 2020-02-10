package com.ht.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ht.common.model.User;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDao {

	@Autowired
	private DataSource datasource;
	
	public void setDatasource(DataSource datasource) {
		log.info("Spring called setDatasource.. ");
		this.datasource = datasource;
	}


	
	public void saveUser(User newModelUser) {

		Connection conn = null;

		try {
			conn = datasource.getConnection();
			Statement cmd = conn.createStatement();
			String sql = "INSERT INTO `user` ( `fname`, `lname`, `username`, `password`, `email`, `role`) VALUES(" 
					+ "'" + newModelUser.getFname() + "', " 
					+ "'" + newModelUser.getLname() + "', "
					+ "'" + newModelUser.getUsername() + "', "
					+ "'" + newModelUser.getPassword() + "', "
					+ "'" + newModelUser.getEmail() + "', "
					+ "'" + newModelUser.getRole() + "') ";

			int rowsUpdated = cmd.executeUpdate(sql);
			System.out.println(rowsUpdated + "user added");

		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					log.info("connection closed");
				} catch (Exception e) {
					/* ignore close errors */ }
			}
		}
	}
	
	
	public User updateUser(int id) {
		throw new UnsupportedOperationException("updateUser is not yet implemented");
		/*
		Connection conn = null;
		User found = null;
		
		try {
			conn = DbUtils.createConnection();
			Statement cmd = conn.createStatement();
			String sql = "INSERT INTO `user` ( `fname`, `lname`, `username`, `password`, `email`, `role`) VALUES(" 
					+ "'" + newModelUser.getFname() + "', " 
					+ "'" + newModelUser.getLname() + "', "
					+ "'" + newModelUser.getUsername() + "', "
					+ "'" + newModelUser.getPassword() + "', "
					+ "'" + newModelUser.getEmail() + "', "
					+ "'" + newModelUser.getRole() + "') ";

			int rowsUpdated = cmd.executeUpdate(sql);
			System.out.println("Updated (added) " + rowsUpdated + "rows in Cd Table");

		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}
		return found;
		*/
	}
	
	public User findUser(int id) {
		throw new UnsupportedOperationException("updateUser is not yet implemented");
		/*
		Connection conn = null;
		User found = null;
		
		try {
			conn = datasource.getConnection();
			Statement cmd = conn.createStatement();
			String sql = "SELECT * from User where id= " + id;
			ResultSet res = cmd.executeQuery(sql);
			if (res.next()) {
				found = new User();
				found.setId(res.getInt("id"));
				found.setFname(res.getString("fname"));
				found.setLname(res.getString("lname"));
				found.setUsername(res.getString("username"));
				found.setPassword(res.getString("password"));
				found.setEmail(res.getString("email"));
				found.setRole(res.getString("role"));
			}
		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					log.info("connection closed");
				} catch (Exception e) {
					 }
			}
		}
		return found;*/
	}
	

	
	public void deleteUser(int id) {
		 
		throw new UnsupportedOperationException("updateUser is not yet implemented");
		/*
		Connection conn = null;
			
		try {
				
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "delete from user where id= " + id;
			cmd.executeUpdate(sql);

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			 DbUtils.closeConnection(conn);    
		}
		*/
	}


}
