import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Help extends JFrame
{
public static BufferedImage image;
public static JLabel label;
public static JFrame frame;
public static JTextField t1;
public static JButton submit;

public Help()
{

Abc ob=new Abc();

frame=new JFrame("Feedback");
frame.setSize(500,500);
frame.setLayout(null);
frame.setVisible(true);

try
{
image=ImageIO.read(new File("fd.png"));
}
catch(IOException e)
{}
ImageIcon icon=new ImageIcon(image.getScaledInstance(500,500,1));
label=new JLabel();
label.setIcon(icon);
label.setLayout(null);

JPanel p1=new JPanel(new FlowLayout());
p1.setSize(500,500);
p1.add(label);
frame.setContentPane(p1);

JLabel label1=new JLabel("PLease give your valuable feedback:");
label1.setBounds(40,60,250,40);
label.add(label1);
label1.setForeground(Color.white);

t1=new JTextField();
t1.setBounds(40,120,350,150);
label.add(t1);

submit=new JButton("SUBMIT");
submit.setBounds(40,290,80,40);
label.add(submit);
submit.addActionListener(ob);

}

private static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{

String temp=e.getActionCommand();
if(temp.equals("SUBMIT"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\proj\\feedback.mdb";
Connection conn=DriverManager.getConnection(url,"","");
String str="insert into feed(feedback) values(?)";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setString(1,t1.getText());

stmt.executeUpdate();
conn.close();
JOptionPane.showMessageDialog(null,"SAVED");
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null,e1.getMessage());
}
}

}
}
}