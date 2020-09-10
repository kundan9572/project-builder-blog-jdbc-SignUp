package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.User;
import utility.ConnectionManager;

public class UserDAO {
	ConnectionManager cm = new ConnectionManager();

	
	public int SignUp(User user) throws SQLException, ClassNotFoundException, IOException {
		
		String email=user.getEmail();
		String password=user.getPassword();
		LocalDate date=user.getDate();
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "INSERT INTO USERSDETAIL(EMAIL,PASSWORD,DATE_OF_LOGIN) VALUES(?,?,?)";
		
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setString(1,email);
		st.setString(2,password);
		st.setDate(3,Date.valueOf(date));
		
		st.executeUpdate();
		cm.getConnection().close();
		
		return 1;
		
		
		
		
		
	}
	
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, IOException {
		
		String email = user.getEmail();
		String password=user.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM USERSDETAIL");
		
		while(rs.next()) {
			
			if(email.equals(rs.getString("EMAIL")))
			{
				if(password.equals(rs.getString("PASSWORD"))) {
					return true ;
				}
			}
		}
		return false;
		
		
		
		
	}
}
