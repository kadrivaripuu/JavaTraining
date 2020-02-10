package course.jse.jdbc.lab;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import course.jse.jdbc.utils.DbUtils;

public class CdDao {

	public void saveCd(Cd newCd) {

		Connection conn = null;

		try {
			conn = DbUtils.createConnection();
			Statement cmd = conn.createStatement();
			String sql = "INSERT INTO `cd` " + "( `Artist`, " + "`Company`, " + "`Price`, " + "`Title`, "
					+ "`Country`, " + "`Year`, " + "`Quantity`, " + "`Version`) " + "VALUES(" + "'" + newCd.getArtist()
					+ "', " + "'" + newCd.getCompany() + "', " + newCd.getPrice() + ", " + "'" + newCd.getTitle()
					+ "', " + "'" + newCd.getCountry() + "', " + newCd.getYear() + ", " + newCd.getQuantity() + ", "
					+ newCd.getVersion() + ") ";

			int rowsUpdated = cmd.executeUpdate(sql);
			System.out.println("Updated (added) " + rowsUpdated + "rows in Cd Table");

		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

	}
	
	
	

	public Cd findById(Long id) {
		Connection conn = null;
		Cd found = null;

		try {
			conn = DbUtils.createConnection();
			Statement cmd = conn.createStatement();
			String sql = "select * from cd where id= " + id;
			ResultSet res = cmd.executeQuery(sql);
			if (res.next()) {
				found = new Cd();
				found.setId(res.getLong("id"));
				found.setArtist(res.getString("artist"));
				found.setCompany(res.getString("company"));
				found.setCountry(res.getString("country"));
				found.setPrice(res.getDouble("price"));
				found.setQuantity(res.getInt("quantity"));
				found.setTitle(res.getString("title"));
				found.setVersion(res.getLong("version"));
				found.setYear(res.getInt("year"));
			}

		}

		catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}
		
		return found;
	}
	
	
	

	public Cd findByPrice (Double price) {
		Connection conn = null;
		Cd found = null;
			
		try {	
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "select * from cd where price= " + price;
//			int current = cmd.getFetchSize();
			ResultSet res = cmd.executeQuery(sql);

//			private Map<String, List<Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
//			    ResultSetMetaData md = rs.getMetaData();
//			    int columns = md.getColumnCount();
//			    Map<String, List<Object>> map = new HashMap<>(columns);
//			    for (int i = 1; i <= columns; ++i) {
//			        map.put(md.getColumnName(i), new ArrayList<>());
//			    }
//			    while (rs.next()) {
//			        for (int i = 1; i <= columns; ++i) {
//			            map.get(md.getColumnName(i)).add(rs.getObject(i));
//			        }
//			    }
//
//			    return map;
//			}

				if (res.next()) {
					found = new Cd();
					found.setId(res.getLong("id"));
					found.setArtist(res.getString("artist"));
					found.setCompany(res.getString("company"));
					found.setCountry(res.getString("country"));
					found.setPrice(res.getDouble("price"));
					found.setQuantity(res.getInt("quantity"));
					found.setTitle(res.getString("title"));
					found.setVersion(res.getLong("version"));
					found.setYear(res.getInt("year"));
				}	
		}

	catch (Exception e){
		System.err.println("Impossible to connect to Database");
		e.printStackTrace();
	} finally {
		DbUtils.closeConnection(conn);
	} 
		
	return found;
}

	
	
	public void deleteCd(long id) {
		 
		Connection conn = null;
			
		try {
				
			conn = DbUtils.createConnection();
			
			Statement cmd = conn.createStatement();
			String sql = "delete from cd where id= " + id;

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