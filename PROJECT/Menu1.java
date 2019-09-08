import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Menu1 extends JFrame implements ActionListener 
{
JMenuBar menubar;
JMenu menu,menu2,menu3,menu4;
JMenuItem item,item2, item3, item4,item5,item6;
public static BufferedImage image;

public Menu1()
{


super("SCHOOL");
setSize(500,500);
setLayout(null);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

try
{
image=ImageIO.read(new File("school.jpg"));
}
catch(IOException e)
{}
ImageIcon icon=new ImageIcon(image.getScaledInstance(500,500,1));
JLabel label=new JLabel();
label.setIcon(icon);
label.setLayout(null);

JPanel p1=new JPanel(new FlowLayout());
p1.setBounds(0,30,500,470);
//frame.add(label);
p1.add(label);
this.setContentPane(p1);


menubar=new JMenuBar();
menubar.setSize(500,30);
menubar.setLocation(0,0);
label.add(menubar);

menu=new JMenu("ADMISSION");
menubar.add(menu);

item=new JMenuItem("Application form");
menu.add(item);
item.addActionListener(this);

item2=new JMenuItem("Check result");
menu.add(item2);
item2.addActionListener(this);
//Abc aa=new Abc();

menu2=new JMenu("HELP");
menubar.add(menu2);

item3=new JMenuItem("Feedback");
menu2.add(item3);
item3.addActionListener(this);

menu3=new JMenu("UTILITY");
menubar.add(menu3);

item4=new JMenuItem("Stopwatch");
menu3.add(item4);
item4.addActionListener(this);

item5=new JMenuItem("Calculator");
menu3.add(item5);
item5.addActionListener(this);

menu4=new JMenu("TEST");
menubar.add(menu4);

item6=new JMenuItem("Quiz");
menu4.add(item6);
item6.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
JOptionPane.showMessageDialog(null,e.getActionCommand());
if(e.getActionCommand().equals("Application form"))
{
Form of=new Form();
of.setVisible(true);
}
if(e.getActionCommand().equals("Check result"))
{
Check of1=new Check();
of1.setVisible(true);
}
if(e.getActionCommand().equals("Feedback"))
{
Help of2=new Help();
of2.setVisible(true);
}
if(e.getActionCommand().equals("Stopwatch"))
{
Stop of3=new Stop();
of3.setVisible(true);
}
if(e.getActionCommand().equals("Calculator"))
{
Calculator of4=new Calculator();
of4.setVisible(true);
}
if(e.getActionCommand().equals("Quiz"))
{
Quiz of5=new Quiz();
of5.setVisible(true);
}





}
}
