import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Check extends JFrame
{
public static BufferedImage image;
public static JTextField f1,f2,f3;
public static JFrame frame;
private static JLabel label;
public static JButton b1;

public Check()
{


Abc ob=new Abc();
Mo mm=new Mo();


frame=new JFrame("Check");
frame.setVisible(true);
frame.setLayout(null);
frame.setSize(500,500);

try
{
image=ImageIO.read(new File("check.jpg"));
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

JLabel l1=new JLabel("Enter your class:");
label.add(l1);
l1.setForeground(Color.red);
l1.setBounds(40,50,100,40);

f1=new JTextField();
label.add(f1);
f1.setBounds(160,50,70,40);


JLabel l2=new JLabel("Enter your %:");
label.add(l2);
l2.setForeground(Color.red);
l2.setBounds(40,110,100,40);

f2=new JTextField();
label.add(f2);
f2.setBounds(160,110,70,40);

JLabel l3=new JLabel("Your grade is:");
label.add(l3);
l3.setForeground(Color.red);
l3.setBounds(40,170,100,40);


f3=new JTextField();
label.add(f3);
f3.setBounds(160,170,70,40);

b1=new JButton("CHECK");
b1.setBounds(40,220,80,40);
label.add(b1);
b1.addActionListener(ob);
b1.addMouseListener(mm);



}
public static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{

Scroll ob1=new Scroll("**Congratulations you are qualified**");
Scroll ob2=new Scroll("**Failed**");

String v;
int a=Integer.parseInt(f2.getText());
if(a>90)
{
v="A";
f3.setText(v);
}
else if(a>80)
{
v="B";
f3.setText(v);
}
else if(a>70)
{
v="C";
f3.setText(v);
}
else
{
v="F";
f3.setText(v);
}
if(a>70)
{
//frame.getContentPane().add(ob1);
label.add(ob1);
new Thread(ob1).start();
}
else
{
label.add(ob2);
new Thread(ob2).start();
}
}
}

public static class Mo implements MouseListener
{
public void mouseClicked (MouseEvent e)
{

}
public void mouseEntered (MouseEvent e)
{
b1.setForeground(Color.blue);
}

public void mouseExited (MouseEvent e)
{

}

public void mousePressed (MouseEvent e)
{

}
public void mouseReleased (MouseEvent e)
{
}
}
}

