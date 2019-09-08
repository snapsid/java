import javax.swing.*;
import java.awt.*;

public class A2
{
public static void main(String[] args)
{
JFrame frame=new JFrame("calc");
frame.setVisible(true);
frame.setSize(500,500);
frame.setLayout(null);


JLabel l1=new JLabel("Number 1:");
l1.setBounds(30,30,90,30);
frame.add(l1);

JTextField b1=new JTextField();
b1.setBounds(150,30,90,30);
frame.add(b1);

JLabel l2=new JLabel("Number 2:");
l2.setBounds(30,80,90,30);
frame.add(l2);

JTextField b2=new JTextField();
b2.setBounds(150,80,90,30);
frame.add(b2);

JLabel l3=new JLabel("Result");
l3.setBounds(30,120,90,30);
frame.add(l3);

JTextField b3=new JTextField();
b3.setBounds(150,120,90,30);
frame.add(b3);

JButton bb1=new JButton("Add");
bb1.setBounds(30,170,60,40);
frame.add(bb1);
}
}