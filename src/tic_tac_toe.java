import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class tic_tac_toe extends JFrame implements ActionListener,FocusListener
{
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
JLabel l1;
ImageIcon i1;
Container con=getContentPane();
String type="";
Random rand;
int c=0;
String player1="",player2="";
tic_tac_toe(String name1,String name2)
{
player1=name1;
player2=name2;
type="player";
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con.setBackground(Color.black);

rand=new Random();

i1=new ImageIcon("tictac.png");
l1=new JLabel(i1);

b1=new JButton();
b2=new JButton();
b3=new JButton();
b4=new JButton();
b5=new JButton();
b6=new JButton();
b7=new JButton();
b8=new JButton();
b9=new JButton();
b10=new JButton("New Game");


b1.setFont(new Font("Segoe Print",Font.BOLD,20));
b2.setFont(new Font("Segoe Print",Font.BOLD,20));
b3.setFont(new Font("Segoe Print",Font.BOLD,20));
b4.setFont(new Font("Segoe Print",Font.BOLD,20));
b5.setFont(new Font("Segoe Print",Font.BOLD,20));
b6.setFont(new Font("Segoe Print",Font.BOLD,20));
b7.setFont(new Font("Segoe Print",Font.BOLD,20));
b8.setFont(new Font("Segoe Print",Font.BOLD,20));
b9.setFont(new Font("Segoe Print",Font.BOLD,20));
b10.setFont(new Font("Segoe Print",Font.BOLD,20));

b1.setBackground(Color.red);
b3.setBackground(Color.red);
b5.setBackground(Color.red);
b7.setBackground(Color.red);
b9.setBackground(Color.red);
b2.setBackground(Color.white);
b4.setBackground(Color.white);
b6.setBackground(Color.white);
b8.setBackground(Color.white);


add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);
add(b8);
add(b9);
add(b10);


b1.setBounds(300,170,50,50);
b2.setBounds(355,170,50,50);
b3.setBounds(410,170,50,50);
b4.setBounds(300,225,50,50);
b5.setBounds(355,225,50,50);
b6.setBounds(410,225,50,50);
b7.setBounds(300,280,50,50);
b8.setBounds(355,280,50,50);
b9.setBounds(410,280,50,50);
b10.setBounds(310,350,150,30);
l1.setBounds(0,0,1360,760);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);


b1.addFocusListener(this);
b2.addFocusListener(this);
b3.addFocusListener(this);
b4.addFocusListener(this);
b5.addFocusListener(this);
b6.addFocusListener(this);
b7.addFocusListener(this);
b8.addFocusListener(this);
b9.addFocusListener(this);


//add(l1);
setVisible(true);
}
public void focusGained(FocusEvent fe)
{}
public void focusLost(FocusEvent fe)
{
if((fe.getSource()==b1)||(fe.getSource()==b2)||(fe.getSource()==b3)||(fe.getSource()==b4)||(fe.getSource()==b5)||(fe.getSource()==b6)||(fe.getSource()==b7)||(fe.getSource()==b8)||(fe.getSource()==b9))
{
if(((b1.getText().equals(zero))&&(b2.getText().equals(zero))&&(b3.getText().equals(zero)))||((b4.getText().equals(zero))&&(b5.getText().equals(zero))&&(b6.getText().equals(zero)))||((b7.getText().equals(zero))&&(b8.getText().equals(zero))&&(b9.getText().equals(zero)))||((b1.getText().equals(zero))&&(b4.getText().equals(zero))&&(b7.getText().equals(zero)))||((b2.getText().equals(zero))&&(b5.getText().equals(zero))&&(b8.getText().equals(zero)))||((b3.getText().equals(zero))&&(b6.getText().equals(zero))&&(b9.getText().equals(zero)))||((b1.getText().equals(zero))&&(b5.getText().equals(zero))&&(b9.getText().equals(zero)))||((b3.getText().equals(zero))&&(b5.getText().equals(zero))&&(b7.getText().equals(zero))))
{

if(type.equals("player"))
JOptionPane.showMessageDialog(this,player1+" wins");
else 
JOptionPane.showMessageDialog(this,"Computer Wins");

b1.setText("");
b2.setText("");
b3.setText("");
b4.setText("");
b5.setText("");
b6.setText("");
b7.setText("");
b8.setText("");
b9.setText("");

}
else if(((b1.getText().equals(cross))&&(b2.getText().equals(cross))&&(b3.getText().equals(cross)))||((b4.getText().equals(cross))&&(b5.getText().equals(cross))&&(b6.getText().equals(cross)))||((b7.getText().equals(cross))&&(b8.getText().equals(cross))&&(b9.getText().equals(cross)))||((b1.getText().equals(cross))&&(b4.getText().equals(cross))&&(b7.getText().equals(cross)))||((b2.getText().equals(cross))&&(b5.getText().equals(cross))&&(b8.getText().equals(cross)))||((b3.getText().equals(cross))&&(b6.getText().equals(cross))&&(b9.getText().equals(cross)))||((b1.getText().equals(cross))&&(b5.getText().equals(cross))&&(b9.getText().equals(cross)))||((b3.getText().equals(cross))&&(b5.getText().equals(cross))&&(b7.getText().equals(cross))))
{

if(type.equals("player"))
JOptionPane.showMessageDialog(this,player2+" wins");
else
JOptionPane.showMessageDialog(this,"You Wins");

b1.setText("");
b2.setText("");
b3.setText("");
b4.setText("");
b5.setText("");
b6.setText("");
b7.setText("");
b8.setText("");
b9.setText("");

}
}
}


int a=0;
String zero=String.valueOf(0);
String cross="x";
public void actionPerformed(ActionEvent ae)
{
if(type.equals("player"))
{
if(ae.getSource()==b1)
{
if(a==0)
{
b1.setText(String.valueOf(0));
a=1;
}
else
{
b1.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b1.setEnabled(false);
}

if(ae.getSource()==b2)
{
if(a==0)
{
b2.setText(String.valueOf(0));
a=1;
}
else
{
b2.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b2.setEnabled(false);
}


if(ae.getSource()==b3)
{
if(a==0)
{
b3.setText(String.valueOf(0));
a=1;
}
else
{
b3.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b3.setEnabled(false);
}


if(ae.getSource()==b4)
{
if(a==0)
{
b4.setText(String.valueOf(0));
a=1;
}
else
{
b4.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b4.setEnabled(false);
}


if(ae.getSource()==b5)
{
if(a==0)
{
b5.setText(String.valueOf(0));
a=1;
}
else
{
b5.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b5.setEnabled(false);
}


if(ae.getSource()==b6)
{
if(a==0)
{
b6.setText(String.valueOf(0));
a=1;
}
else
{
b6.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b6.setEnabled(false);
}


if(ae.getSource()==b7)
{
if(a==0)
{
b7.setText(String.valueOf(0));
a=1;
}
else
{
b7.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b7.setEnabled(false);
}


if(ae.getSource()==b8)
{
if(a==0)
{
b8.setText(String.valueOf(0));
a=1;
}
else
{
b8.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b8.setEnabled(false);
}


if(ae.getSource()==b9)
{
if(a==0)
{
b9.setText(String.valueOf(0));
a=1;
}
else
{
b9.setText("x");
a=0;
}
//l2.setForeground(Color.green);
b9.setEnabled(false);
}
}
else if(type.equals("computer"))
{
}





if(ae.getSource()==b10)
{
b1.setText("");
b2.setText("");
b3.setText("");
b4.setText("");
b5.setText("");
b6.setText("");
b7.setText("");
b8.setText("");
b9.setText("");

b1.setEnabled(true);
b2.setEnabled(true);
b3.setEnabled(true);
b4.setEnabled(true);
b5.setEnabled(true);
b6.setEnabled(true);
b7.setEnabled(true);
b8.setEnabled(true);
b9.setEnabled(true);

a=0;


}
}
public static void main(String op[])
{
new tic_tac_toe("","");
}
}

