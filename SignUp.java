import java.sql.*;
import java.util.*;
public class SignUp {
	public void signup() {
		System.out.println("Welcome to Signup Page");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name :");
		String name=sc.nextLine();
		System.out.println("Enter your Mobile Number :");
		String pno=sc.nextLine();
		System.out.println("Enter your Email-ID :");
		String email=sc.nextLine();
		try {
			String url="jdbc:mysql://localhost:3306/course";
			String userName="root";
			String password="Hobartkings7*";
			Connection con=DriverManager.getConnection(url,userName,password);
			String checkquery="select * from signuptab";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(checkquery);
			boolean isPnoFound=false;
			boolean isEmailFound=false;
			while(rs.next()) {
				if((rs.getString(2).equals(pno))){
					isPnoFound=true;
					break;
				}
				if((rs.getString(2).equals(pno))){
					isEmailFound=true;
					break;
				}
			}
			if(isPnoFound) {
				System.out.println("Mobile Number already exist");
				System.out.println("Please try again...");
			}
			else if(isPnoFound) {
				System.out.println("Email Id already exist");
				System.out.println("Please try again...");
			}
			else {
			String query="insert into signuptab values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,pno);
			ps.setString(3,email);
			ps.executeUpdate();//number of affected rows will be returned
			System.out.println("Hey Dude !  You have created your account successfully !");
			Course c=new Course(pno);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
