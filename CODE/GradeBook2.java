import java.util.Scanner;
public class GradeBook2
{
public static void main(String[] args)
{
Scanner input=new Scanner(System.in);
System.out.println("enter ccourse name");
String a=input.nextLine();
GradeBook1 ob = new GradeBook1();
ob.setCourseName(a);
ob.display();
}
}