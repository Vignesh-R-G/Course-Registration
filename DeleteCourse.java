import java.sql.*;
import java.util.*;
public class DeleteCourse {
	public void del(String pno) {
		Scanner sc=new Scanner(System.in);
		try {
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			ViewCourse obj=new ViewCourse();
			obj.view(pno);
			System.out.println("Enter the course id to delete");
			int n=sc.nextInt();
			String query="delete from usersdetails where pno="+pno+" and c_id="+n;
			st.executeUpdate(query);
			System.out.println("Course is deleted from your account successfully!");
			query="commit";
			st.execute(query);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
