import java.util.*;
import java.sql.*;
public class AddCourse{
	public void add(String pno) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Courses Available :");
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			String query="select * from course";
			ResultSet rs=st.executeQuery(query);
			System.out.println("c_id"+" "+"c_name");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			System.out.println("Enter the course id to add the course :");
			int n=sc.nextInt();
			rs=st.executeQuery(query);
			String course="";
			while(rs.next()) {
				if(rs.getInt(1)==n) {
					course=rs.getString(2);
					break;
				}
			}
			query="insert into usersdetails values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,pno);
			ps.setInt(2,n);
			ps.setString(3,course);
			ps.executeUpdate();
			System.out.println("A new course is added to your account successfully!");
			query="commit";
			st.execute(query);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
