public class Cons1
{
String courseName;
public Cons1(String name)
{
courseName=name;
}
public String getCourseName()
{
return courseName;
}
public void display()
{
System.out.printf("name is %s ", getCourseName());
}
}