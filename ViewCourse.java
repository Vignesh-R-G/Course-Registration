import java.util.*;
import java.sql.*;
public class ViewCourse {
	public void view(String pno) {
		try {
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			String query="select distinct (c_id),c_name from usersdetails where pno="+pno+" order by c_id";
			ResultSet rs=st.executeQuery(query);
			System.out.println("Your courses are: ");
			System.out.println("c_id   c_name");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
