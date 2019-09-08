import javax.swing.*;
public class Scroll extends JLabel implements Runnable
{
public String sName;
public Scroll(String name)
{
sName=name;
}
public void run()
{
try
{
int x=0;
for(x=0;x<500;x++)
{
this.setText(sName);
this.setBounds(x,270,210,40);
Thread.sleep(50);

}
}
catch(InterruptedException exception)
{
exception.printStackTrace();
}
}
} 