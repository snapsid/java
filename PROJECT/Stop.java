import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Stop extends JFrame
{
public static JFrame frame;
public static JButton start;
public static BufferedImage image;
public static JLabel label;

public Stop()
{

Abc ob =new Abc();

frame=new JFrame("Stopwatch");
frame.setSize(500,500);
frame.setLayout(null);
frame.setVisible(true);
frame.setCursor(Cursor.HAND_CURSOR);

try
{
image=ImageIO.read(new File("watch.png"));
}
catch(IOException e)
{}
ImageIcon icon=new ImageIcon(image);
label=new JLabel();
label.setIcon(icon);


JPanel p1=new JPanel(new FlowLayout());
p1.setSize(500,500);
p1.add(label);
frame.setContentPane(p1);


start=new JButton("Start");
start.setBounds(140,220,80,50);
label.add(start);
start.addActionListener(ob);

}
public static class Abc implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JOptionPane.showMessageDialog(null,e.getActionCommand());
if(e.getActionCommand().equals("Start"))
{
ThreadLabel counterLabel=new ThreadLabel("Sec.: ",1);
counterLabel.setText("hello");
counterLabel.setForeground(Color.white);
counterLabel.setBounds(160,150,80,50);
label.add(counterLabel);
new Thread(counterLabel).start();
}


}
}

}