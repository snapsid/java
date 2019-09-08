import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class First extends JFrame
{
public static BufferedImage image;
public static JLabel label;
public static void main(String[] args)
{
Abc oo=new Abc(); 

JFrame frame=new JFrame("welcome");
frame.setSize(500,500);
frame.setLayout(null);
frame.setVisible(true);

try
{
image=ImageIO.read(new File("fi.jpg"));
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


JLabel l1=new JLabel("Select your choice:");
l1.setBounds(40,60,200,40);
l1.setForeground(Color.white);
label.add(l1);

JRadioButton b1=new JRadioButton("Student");
b1.setBounds(40,120,90,40);
label.add(b1);

JRadioButton b2=new JRadioButton("Faculty");
b2.setBounds(40,170,90,40);
label.add(b2);

JButton submit=new JButton(new ImageIcon("H:\\java pracitice codes\\proj\\ss.png"));
submit.setBounds(40,230,150,55);
label.add(submit);
submit.addActionListener(oo);

}

public static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JOptionPane.showMessageDialog(null,e.getActionCommand());
if(e.getActionCommand().equals(""))
{
Menu1 ob=new Menu1();
ob.setVisible(true);
}


}
}
}