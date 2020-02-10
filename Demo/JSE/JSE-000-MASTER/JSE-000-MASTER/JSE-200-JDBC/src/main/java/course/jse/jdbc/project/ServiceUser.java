package course.jse.jdbc.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import course.jse.jdbc.utils.DbUtils;

public class ServiceUser {
	
	
	public ModelUser findUser(int id) {

		Connection conn = null;
		ModelUser found = null;
		
		try {
			conn = DbUtils.createConnection();
			Statement cmd = conn.createStatement();
			String sql = "SELECT * from User where id= " + id;
			ResultSet res = cmd.executeQuery(sql);
			if (res.next()) {
				found = new ModelUser();
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
			DbUtils.closeConnection(conn);
		}
		return found;
	}
	
	
	
	public void saveUser(ModelUser newModelUser) {

		Connection conn = null;

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
	}
	
	
	public ModelUser updateUser(int id) {

		Connection conn = null;
		ModelUser found = null;
		
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
	}
	
	
	

	
	public void deleteUser(int id) {
		 
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
		
	}
	
}
