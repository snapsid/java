class GradeBook1
{
String courseName;
public void setCourseName(String name)
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