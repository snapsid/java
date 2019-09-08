import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Form
{
private static JTextField t1,t2,t3;
public static void main(String[] args)
{

Abc abc=new Abc(); 

JFrame frame=new JFrame();
frame.setSize(500,500);
frame.setLayout(null);
frame.setVisible(true);

JLabel id=new JLabel("USERID:");
id.setBounds(30,30,100,30);
frame.add(id);

JLabel name=new JLabel("USERNAME:");
name.setBounds(30,70,100,30);
frame.add(name);

JLabel pas=new JLabel("PASSWORD:");
pas.setBounds(30,110,100,30);
frame.add(pas);

t1=new JTextField();
t1.setBounds(150,30,100,30);
frame.add(t1);

t2=new JTextField();
t2.setBounds(150,70,100,30);
frame.add(t2);

t3=new JTextField();
t3.setBounds(150,110,100,30);
frame.add(t3);

JButton save=new JButton("SAVE");
save.setBounds(40,160,80,40);
frame.add(save);
save.addActionListener(abc);

JButton search=new JButton("SEARCH");
search.setBounds(140,160,100,40);
frame.add(search);
search.addActionListener(abc);

}
private static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JButton temp = (JButton) e.getSource();
String st= temp.getText();
if(st.equals("SAVE"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\form.mdb";
Connection conn=DriverManager.getConnection(url,"","");
String str="insert into data(USERID,USERNAME,PASSWORD) values(?,?,?)";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setInt(1,Integer.parseInt(t1.getText()));
stmt.setString(2,t2.getText());
stmt.setString(3,t3.getText());
stmt.executeUpdate();
JOptionPane.showMessageDialog(null,"saved");
conn.close();
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null,e1.getMessage());
}
}
if(st.equals("SEARCH"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\form.mdb";
Connection conn=DriverManager.getConnection(url,"","");
String str="select * from data where USERID=?";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setInt(1,Integer.parseInt(t1.getText()));

ResultSet rs=stmt.executeQuery();
if(rs.next())
{
t2.setText(rs.getString("USERNAME"));
t3.setText(rs.getString("PASSWORD"));
}
else
{
JOptionPane.showMessageDialog(null,"User not found");
}
conn.close();
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null,e1.getMessage());
}
}
}
}
}