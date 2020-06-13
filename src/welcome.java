import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class welcome extends JFrame implements Runnable
{
JLabel l1,l2;
ImageIcon i1,i2;
Thread t1;
welcome()
{
setSize(760,760);
setLayout(null);

i1=new ImageIcon("TicTacToe.jpg");
i2=new ImageIcon("jkl.jpg");

l1=new JLabel(i1);
l2=new JLabel(i2);

t1=new Thread(this);



add(l1);
add(l2);
l1.setBounds(0,0,760,760);


setVisible(true);
t1.start();
}
public void run()
{
try
{
if(Thread.currentThread()==t1)
{

Thread.sleep(10);
new entry();
this.dispose();
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String hj[])
{
new welcome();
}
}