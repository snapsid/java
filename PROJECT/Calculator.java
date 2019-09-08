import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Calculator extends JFrame
{
private static JTextField t1,t2,t3;
public static BufferedImage image;
public static JLabel label;

public Calculator()
{

Abc ob=new Abc();

JFrame frame=new JFrame();
frame.setSize(500,500);
frame.setTitle("calculator");
frame.setLayout(null);
frame.setVisible(true);
frame.setCursor(Cursor.HAND_CURSOR);

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
p1.add(label);
frame.setContentPane(p1);


JLabel l1=new JLabel("First no.");
Font f = new Font("Lucida Console",Font.PLAIN,14);
l1.setFont(f);
l1.setBounds(30,25,100,25);
label.add(l1);

JLabel l2=new JLabel("Second no.");
Font ff=new Font("Lucida Calligraphy",Font.ITALIC,14);
l2.setFont(ff);
l2.setBounds(30,60,100,25);
label.add(l2);

t1=new JTextField();
t1.setBounds(120,25,50,25);
label.add(t1);

t2=new JTextField();
t2.setBounds(120,60,50,25);
label.add(t2);

JLabel result=new JLabel("Result: ");;
result.setBounds(30,90,100,25);
label.add(result);

t3=new JTextField();
t3.setBounds(120,90,50,25);
label.add(t3);

JButton ad=new JButton("ADD");
ad.setBounds(30,120,100,30);
label.add(ad);
ad.addActionListener(ob);

JButton sub=new JButton("SUBTRACT");
sub.setBounds(150,120,100,30);
label.add(sub);
sub.addActionListener(ob);

JButton mul=new JButton("MULTIPLY");
mul.setBounds(30,170,100,30);
label.add(mul);
mul.addActionListener(ob);

JButton div=new JButton("DIVIDE");
div.setBounds(150,170,100,30);
div.addActionListener(ob);
label.add(div);


}
private static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
int a=Integer.parseInt(t1.getText());
int b=Integer.parseInt(t2.getText());
String st=e.getActionCommand();
if(st.equals("ADD"))
{
Integer c=a+b;
t3.setText(c.toString());
}

if(st.equals("SUBTRACT"))
{
Integer c=a-b;
t3.setText(c.toString());
}

if(st.equals("MULTIPLY"))
{
Integer c=a*b;
t3.setText(c.toString());
}

if(st.equals("DIVIDE"))
{
Integer c=a/b;
t3.setText(c.toString());
}

}
}

}
