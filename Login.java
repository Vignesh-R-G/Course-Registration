import java.util.Scanner;
import java.sql.*;
public class Login{
	public void login() {
		System.out.println("Welcome to Login Page");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name :");
		String name=sc.nextLine();
		System.out.println("Enter your Email-ID :");
		String email=sc.nextLine();
		try {
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			String query="select * from signuptab";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			String pno="";
			boolean flag=false;
			while(rs.next()) {
				if(email.equals(rs.getString(3)))
				{
					pno=rs.getString(2);
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("You have logged in successfully !");
				
				Course c=new Course(pno);
			}
			else {
				System.out.println("No user Found");
				System.out.println("Please create your account");
				SignUp signupobj=new SignUp();
				signupobj.signup();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
