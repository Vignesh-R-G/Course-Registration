import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin implements adminInterface{
	public void viewcourse() {
		try {
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			String query="select * from course";
			ResultSet rs=st.executeQuery(query);
			System.out.print("c_id   c_name");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Admin Page");
		String pswd="Hobartkings7*";
		System.out.println("Enter Admin password");
		String password=sc.nextLine();
		if(password.equals(pswd)) {
			System.out.println("Welcome Admin");
			while(true)
			{
				System.out.println("1.Add Course 2.Delete Course 3.View Course 4.Exit");
				System.out.println("Enter your choice[1/2/3/4]");
				int ch=sc.nextInt();
				if(ch==1)
				{
					try {
						String url="jdbc:mysql://localhost:3306/course";
						String userName="root";
						String passWord="Hobartkings7*";
						Connection con=DriverManager.getConnection(url,userName,passWord);
						String query="insert into course values(?,?)";
						PreparedStatement ps=con.prepareStatement(query);
						viewcourse();
						System.out.println("Enter the course id to add:");
						int id=sc.nextInt();
						System.out.println("Enter the course name to add:");
						sc.nextLine();
						String name=sc.nextLine();
						ps.setInt(1,id);
						ps.setString(2,name);
						ps.executeUpdate();
						query="commit";
						Statement st=con.createStatement();
						st.execute(query);
						System.out.println("Course Added Succesfully Admin !");
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
				else if(ch==2) {
					try {
						String url="jdbc:mysql://localhost:3306/course";
						String userName="root";
						String passWord="Hobartkings7*";
						Connection con=DriverManager.getConnection(url,userName,passWord);
						viewcourse();
						System.out.println("Enter the course id to delete:");
						int id=sc.nextInt();
						String query="delete from course where c_id="+id;
						Statement st=con.createStatement();
						st.executeUpdate(query);
						st.execute("commit");
						query="delete from usersdetails where c_id="+id;
						st.executeUpdate(query);
						st.execute("commit");
						System.out.println("Course deleted successfully Admin !");
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
				else if(ch==3) {
					viewcourse();
				}
				else
				{
					System.out.println("Thank You !");
					break;
				}
		}
			
		}
		else {
			System.out.println("Password Mismatched !");
			System.out.println("Terminated !!");
		}
	}
}
