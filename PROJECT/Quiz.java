import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.sql.*;

public class Quiz extends JFrame
{
public static JTextField t1,t2;
public static JComboBox l1,l2,l3,l4,l5;
public static Integer temp;
public static BufferedImage image;
public static JLabel label;
public Quiz()
{

Abc aa=new Abc();
Ab ab=new Ab();

JFrame frame =new JFrame("QUIZ");
frame.setVisible(true);
frame.setSize(520,550);
frame.setLayout(null);

try
{
image=ImageIO.read(new File("quiz.png"));
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

JLabel roll=new JLabel("ROLL NO.:");
roll.setBounds(40,30,60,40);
label.add(roll);

JLabel max=new JLabel("Max marks 100");
max.setBounds(300,30,150,40);
label.add(max);

t1=new JTextField();
t1.setBounds(120,30,60,40);
label.add(t1);

JLabel q1=new JLabel("1.How many days do we have in a week??");
q1.setBounds(40,90,280,40);
label.add(q1);

l1=new JComboBox();
l1.setBounds(340,90,50,40);
l1.addItem("null");
l1.addItem("4");
l1.addItem("6");
l1.addItem("7");
l1.addItem("8");
label.add(l1);
l1.addItemListener(aa);

JLabel q2=new JLabel("2. How many days are there in a year?");
q2.setBounds(40,150,280,40);
label.add(q2);

l2=new JComboBox();
l2.setBounds(340,150,50,40);
l2.addItem("null");
l2.addItem("362");
l2.addItem("363");
l2.addItem("364");
l2.addItem("365");
label.add(l2);
l2.addItemListener(aa);

JLabel q3=new JLabel("3. How many months do we have in a year?");
q3.setBounds(40,210,280,40);
label.add(q3);

l3=new JComboBox();
l3.setBounds(340,210,50,40);
l3.addItem("null");
l3.addItem("10");
l3.addItem("11");
l3.addItem("12");
l3.addItem("13");
label.add(l3);
l3.addItemListener(aa);

JLabel q4=new JLabel("4.How many colors are there in a rainbow?");
q4.setBounds(40,270,280,40);
label.add(q4);

l4=new JComboBox();
l4.setBounds(340,270,50,40);
l4.addItem("null");
l4.addItem("4");
l4.addItem("5");
l4.addItem("6");
l4.addItem("7");
label.add(l4);
l4.addItemListener(aa);

JLabel q5=new JLabel("5.Which day comes after Friday?");
q5.setBounds(40,330,280,40);
label.add(q5);

l5=new JComboBox();
l5.setBounds(340,330,50,40);
l5.addItem("null");
l5.addItem("monday");
l5.addItem("tuesday");
l5.addItem("saturday");
l5.addItem("sunday");
label.add(l5);
l5.addItemListener(aa);

JLabel result=new JLabel("RESULT:");
result.setBounds(40,390,60,40);
label.add(result);

t2=new JTextField();
t2.setBounds(120,390,60,40);
label.add(t2);

JButton save=new JButton("SAVE");
save.setBounds(310,390,80,40);
label.add(save);
save.addActionListener(ab);
}

public static class Abc implements ItemListener
{
public void itemStateChanged(ItemEvent e)
{
String st1=(String)l1.getSelectedItem();
String st2=(String)l2.getSelectedItem();
String st3=(String)l3.getSelectedItem();
String st4=(String)l4.getSelectedItem();
String st5=(String)l5.getSelectedItem();

temp=0;
if(st1.equals("7"))
{
temp=temp+20;
//t2.setText(temp);
}

if(st2.equals("365"))
{
temp=temp+20;
//t2.setText(temp);
}

if(st3.equals("12"))
{
temp=temp+20;
//t2.setText(temp);
}

if(st4.equals("7"))
{
temp=temp+20;
//t2.setText(temp);
}

if(st5.equals("saturday"))
{
//temp="c";
temp=temp+20;
}
//String tt=(String)getText(tem);
//t2.setText(temp.toString());
}
}
private static class Ab implements ActionListener
{

public void actionPerformed(ActionEvent e)
{
JOptionPane.showMessageDialog(null,e.getActionCommand());
if(e.getActionCommand().equals("SAVE"))
{
t2.setText(temp.toString());
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=H:\\java pracitice codes\\proj\\quiz.mdb";
Connection conn=DriverManager.getConnection(url,"","");
String str="insert into result(roll,marks) values(?,?)";
PreparedStatement stmt=conn.prepareStatement(str);
stmt.setString(1,t1.getText());
stmt.setString(2,t2.getText());

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

