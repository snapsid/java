import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Form extends JFrame
{
public static BufferedImage image;
public static JTextField f1,f2,f3,f4;
public static JLabel label;
public Form()
{
Abc ob=new Abc();
JFrame frame=new JFrame("FORM");
frame.setVisible(true);
frame.setLayout(null);
frame.setSize(500,500);

/*JLabel ad=new JLabel("ADMISSION FORM");
ad.setBounds(200,30,200,100);
frame.add(ad);
*/

try
{
image=ImageIO.read(new File("form.jpg"));
}
catch(IOException e)
{}
ImageIcon icon=new ImageIcon(image.getScaledInstance(500,500,1));
label=new JLabel();
label.setIcon(icon);
label.setLayout(null);

JPanel p1=new JPanel(new FlowLayout());
p1.setSize(500,500);
//frame.add(label);
p1.add(label);
frame.setContentPane(p1);

JLabel name=new JLabel("NAME:");
name.setBounds(40,100,100,40);
label.add(name);

f1=new JTextField();
f1.setBounds(160,100,100,40);
label.add(f1);

JLabel contact=new JLabel("CONTACT NO.:");
contact.setBounds(40,160,100,40);
label.add(contact);

f2=new JTextField();
f2.setBounds(160,160,100,40);
label.add(f2);

JLabel roll=new JLabel("ROLL NO.:");
roll.setBounds(40,220,100,40);
label.add(roll);

f3=new JTextField();
f3.setBounds(160,220,100,40);
label.add(f3);

JLabel cla=new JLabel("CLASS:");
cla.setBounds(40,280,100,40);
label.add(cla);

f4=new JTextField();
f4.setBounds(160,280,100,40);
label.add(f4);

JButton save=new JButton("SAVE");
label.add(save);
save.setBounds(40,350,80,40);
save.addActionListener(ob);

JButton delete=new JButton("DELETE");
label.add(delete);
delete.setBounds(130,350,80,40);
delete.addActionListener(ob);

JButton search=new JButton("SEARCH");
label.add(search);
search.setBounds(220,350,90,40);
search.addActionListener(ob);



}

private static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{

String temp=e.getActionCommand();
if(temp.equals("SAVE"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\proj\\ff.mdb";
Connection conn=DriverManager.getConnection(url,"","");
String str="insert into Table1 (NAME,CONTACT,ROLL,CLASS) values(?,?,?,?)";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setString(1,f1.getText());
stmt.setString(2,f2.getText());
stmt.setString(3,f3.getText());
stmt.setString(4,f4.getText());

stmt.executeUpdate();
conn.close();
JOptionPane.showMessageDialog(null,"SAVED");
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null,e1.getMessage());
}
}
if(temp.equals("SEARCH"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\proj\\ff.mdb";
Connection conn= DriverManager.getConnection(url,"","");
String str="select * from Table1 where NAME=?";
PreparedStatement stmt=conn.prepareStatement(str);

stmt.setString(1,f1.getText());

ResultSet rs=stmt.executeQuery();
if(rs.next())
{
f2.setText(rs.getString("CONTACT"));
f3.setText(rs.getString("ROLL"));
f4.setText(rs.getString("CLASS"));
}
else
{
JOptionPane.showMessageDialog(null,"user not found");
}
conn.close();


}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null, e1.getMessage());
}
}

if(temp.equals("DELETE"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\proj\\ff.mdb";
Connection conn= DriverManager.getConnection(url,"","");
String str="delete from Table1 where NAME=?";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setString(1,f1.getText());
stmt.executeUpdate();
conn.close();
JOptionPane.showMessageDialog(null,"DELETED");

}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null, e1.getMessage());
}

}

}
}
} 
