import javax.swing.*;
class ThreadLabel extends JLabel implements Runnable
{
private int mCount,mStep;
private String threadName;

public ThreadLabel(String name, int mStart)
{
threadName=name;
mCount=mStart;
mStep=mStart;
}
public void run()
{
try
{
while(mCount<=(2000+mStep))
{
this.setText(threadName+""+mCount);
Thread.sleep(1000);
mCount=mCount+1;
}
}
catch(InterruptedException exception)
{
exception.printStackTrace();
}
}
}