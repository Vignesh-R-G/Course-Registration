import java.util.Scanner;

public class Course{
	int ch=0;
	public Course(String pno) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.Add Course 2.Delete Course 3.View Course 4.Exit");
			System.out.println("Enter your choice :[1/2/3/4]");
			ch=sc.nextInt();
			if(ch==1)
			{
				AddCourse addobj=new AddCourse();
				addobj.add(pno);
			}
			else if(ch==2) {
				DeleteCourse delobj=new DeleteCourse();
				delobj.del(pno);
			}
			else if(ch==3) {
				ViewCourse viewobj=new ViewCourse();
				viewobj.view(pno);
			}
			else
			{
				System.out.println("Thank You !");
				break;
			}
		}
	}
}
