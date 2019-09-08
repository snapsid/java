import java.util.Scanner;
public class add
{
public static void main(String[] args)
{
System.out.println("enter 2 integers");
Scanner ob=new Scanner(System.in);
int a=ob.nextInt();
int b=ob.nextInt();
int sum=a+b;
System.out.printf("sum is %d ", sum);
}
}