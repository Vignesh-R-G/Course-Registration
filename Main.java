import java.sql.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Welcome Are you an Admin/User ?");
			System.out.println("Enter your choice:[1/2]");
			int choice=sc.nextInt();
			if(choice==1) {
				Admin adobj=new Admin();
				adobj.login();
			}
			else {
				System.out.println("Enter your choice:[1/2]");
				System.out.println("1.SignUp 2.Login");
				int ch=sc.nextInt();
				if(ch==1) {
					SignUp signupobj=new SignUp();
					signupobj.signup();
				}
				else {
					Login loginobj=new Login();
					loginobj.login();
				}
			}
	}

}
