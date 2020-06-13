import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class tic_tac extends JFrame implements ActionListener,FocusListener
{
JButton b[]=new JButton[10];
JButton b10;
JLabel l1,l2;
Container con=getContentPane();
String type="";
Random rand;
int c=0;
tic_tac()
{
type="computer";
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con.setBackground(Color.black);

rand=new Random();

l1=new JLabel("Player 1");
l2=new JLabel("Player 2");

l1.setFont(new Font("Segoe Print",Font.BOLD,25));
l2.setFont(new Font("Segoe Print",Font.BOLD,25));

int t=0;
for(t=1;t<=9;t++)
{
b[t]=new JButton("");
}

b10=new JButton("New Game");

for(int p=1;p<=9;p++)
{
b[p].setFont(new Font("Segoe Print",Font.BOLD,20));
}

b10.setFont(new Font("Segoe Print",Font.BOLD,20));

b[1].setBackground(Color.red);
b[3].setBackground(Color.red);
b[5].setBackground(Color.red);
b[7].setBackground(Color.red);
b[9].setBackground(Color.red);
b[2].setBackground(Color.white);
b[4].setBackground(Color.white);
b[6].setBackground(Color.white);
b[8].setBackground(Color.white);


add(l1);
add(l2);
add(b[1]);
add(b[2]);
add(b[3]);
add(b[4]);
add(b[5]);
add(b[6]);
add(b[7]);
add(b[8]);
add(b[9]);
add(b10);


l1.setBounds(100,100,250,30);
l2.setBounds(300,100,250,30);
b[1].setBounds(300,170,50,50);
b[2].setBounds(355,170,50,50);
b[3].setBounds(410,170,50,50);
b[4].setBounds(300,225,50,50);
b[5].setBounds(355,225,50,50);
b[6].setBounds(410,225,50,50);
b[7].setBounds(300,280,50,50);
b[8].setBounds(355,280,50,50);
b[9].setBounds(410,280,50,50);
b10.setBounds(310,350,150,30);


b[1].addActionListener(this);
b[2].addActionListener(this);
b[3].addActionListener(this);
b[4].addActionListener(this);
b[5].addActionListener(this);
b[6].addActionListener(this);
b[7].addActionListener(this);
b[8].addActionListener(this);
b[9].addActionListener(this);
b10.addActionListener(this);


b[1].addFocusListener(this);
b[2].addFocusListener(this);
b[3].addFocusListener(this);
b[4].addFocusListener(this);
b[5].addFocusListener(this);
b[6].addFocusListener(this);
b[7].addFocusListener(this);
b[8].addFocusListener(this);
b[9].addFocusListener(this);



setVisible(true);
}
public void focusGained(FocusEvent fe)
{}
public void focusLost(FocusEvent fe)
{

int y=0;
if((fe.getSource()==b[1])||(fe.getSource()==b[2])||(fe.getSource()==b[3])||(fe.getSource()==b[4])||(fe.getSource()==b[5])||(fe.getSource()==b[6])||(fe.getSource()==b[7])||(fe.getSource()==b[8])||(fe.getSource()==b[9]))
{
while((b[1].getText().equals(""))||(b[2].getText().equals(""))||(b[3].getText().equals(""))||(b[4].getText().equals(""))||(b[5].getText().equals(""))||(b[6].getText().equals(""))||(b[7].getText().equals(""))||(b[8].getText().equals(""))||(b[9].getText().equals("")))
{
y=rand.nextInt(9)+1;
if(b[y].getText().equals(""))
{
if(a==0)
{
b[y].setText(String.valueOf(0));
a=1;
b[y].setEnabled(false);
break;
}
else
{
b[y].setText("x");
a=0;
b[y].setEnabled(false);
break;
}
}
}
}




if((fe.getSource()==b[1])||(fe.getSource()==b[2])||(fe.getSource()==b[3])||(fe.getSource()==b[4])||(fe.getSource()==b[5])||(fe.getSource()==b[6])||(fe.getSource()==b[7])||(fe.getSource()==b[8])||(fe.getSource()==b[9]))
{
if(((b[1].getText().equals(zero))&&(b[2].getText().equals(zero))&&(b[3].getText().equals(zero)))||((b[4].getText().equals(zero))&&(b[5].getText().equals(zero))&&(b[6].getText().equals(zero)))||((b[7].getText().equals(zero))&&(b[8].getText().equals(zero))&&(b[9].getText().equals(zero)))||((b[1].getText().equals(zero))&&(b[4].getText().equals(zero))&&(b[7].getText().equals(zero)))||((b[2].getText().equals(zero))&&(b[5].getText().equals(zero))&&(b[8].getText().equals(zero)))||((b[3].getText().equals(zero))&&(b[6].getText().equals(zero))&&(b[9].getText().equals(zero)))||((b[1].getText().equals(zero))&&(b[5].getText().equals(zero))&&(b[9].getText().equals(zero)))||((b[3].getText().equals(zero))&&(b[5].getText().equals(zero))&&(b[7].getText().equals(zero))))
{
if(type.equals("player"))
JOptionPane.showMessageDialog(this,"Player 1 wins");
else 
JOptionPane.showMessageDialog(this,"  Computer Wins");
 
for(int g=1;g<=9;g++)
{
b[g].setEnabled(false);
}
}
else if(((b[1].getText().equals(cross))&&(b[2].getText().equals(cross))&&(b[3].getText().equals(cross)))||((b[4].getText().equals(cross))&&(b[5].getText().equals(cross))&&(b[6].getText().equals(cross)))||((b[7].getText().equals(cross))&&(b[8].getText().equals(cross))&&(b[9].getText().equals(cross)))||((b[1].getText().equals(cross))&&(b[4].getText().equals(cross))&&(b[7].getText().equals(cross)))||((b[2].getText().equals(cross))&&(b[5].getText().equals(cross))&&(b[8].getText().equals(cross)))||((b[3].getText().equals(cross))&&(b[6].getText().equals(cross))&&(b[9].getText().equals(cross)))||((b[1].getText().equals(cross))&&(b[5].getText().equals(cross))&&(b[9].getText().equals(cross)))||((b[3].getText().equals(cross))&&(b[5].getText().equals(cross))&&(b[7].getText().equals(cross))))
{ 

if(type.equals("player"))
JOptionPane.showMessageDialog(this,"Player 2 wins");
else
JOptionPane.showMessageDialog(this,"You Wins");

for(int k=1;k<=9;k++)
{
b[k].setEnabled(false);
}
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
if(ae.getSource()==b[1])
{
if(a==0)
{
b[1].setText(String.valueOf(0));
a=1;
}
else
{
b[1].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[1].setEnabled(false);
}

if(ae.getSource()==b[2])
{
if(a==0)
{
b[2].setText(String.valueOf(0));
a=1;
}
else
{
b[2].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[2].setEnabled(false);
}


if(ae.getSource()==b[3])
{
if(a==0)
{
b[3].setText(String.valueOf(0));
a=1;
}
else
{
b[3].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[3].setEnabled(false);
}


if(ae.getSource()==b[4])
{
if(a==0)
{
b[4].setText(String.valueOf(0));
a=1;
}
else
{
b[4].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[4].setEnabled(false);
}


if(ae.getSource()==b[5])
{
if(a==0)
{
b[5].setText(String.valueOf(0));
a=1;
}
else
{
b[5].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[5].setEnabled(false);
}


if(ae.getSource()==b[6])
{
if(a==0)
{
b[6].setText(String.valueOf(0));
a=1;
}
else
{
b[6].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[6].setEnabled(false);
}


if(ae.getSource()==b[7])
{
if(a==0)
{
b[7].setText(String.valueOf(0));
a=1;
}
else
{
b[7].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[7].setEnabled(false);
}


if(ae.getSource()==b[8])
{
if(a==0)
{
b[8].setText(String.valueOf(0));
a=1;
}
else
{
b[8].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[8].setEnabled(false);
}


if(ae.getSource()==b[9])
{
if(a==0)
{
b[9].setText(String.valueOf(0));
a=1;
}
else
{
b[9].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[9].setEnabled(false);
}
}
else if(type.equals("computer"))
{

if(ae.getSource()==b[1])
{
if(a==0)
{
b[1].setText(String.valueOf(0));
a=1;
}
else
{
b[1].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[1].setEnabled(false);
}

if(ae.getSource()==b[2])
{
if(a==0)
{
b[2].setText(String.valueOf(0));
a=1;
}
else
{
b[2].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[2].setEnabled(false);
}


if(ae.getSource()==b[3])
{
if(a==0)
{
b[3].setText(String.valueOf(0));
a=1;
}
else
{
b[3].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[3].setEnabled(false);
}


if(ae.getSource()==b[4])
{
if(a==0)
{
b[4].setText(String.valueOf(0));
a=1;
}
else
{
b[4].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[4].setEnabled(false);
}


if(ae.getSource()==b[5])
{
if(a==0)
{
b[5].setText(String.valueOf(0));
a=1;
}
else
{
b[5].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[5].setEnabled(false);
}


if(ae.getSource()==b[6])
{
if(a==0)
{
b[6].setText(String.valueOf(0));
a=1;
}
else
{
b[6].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[6].setEnabled(false);
}


if(ae.getSource()==b[7])
{
if(a==0)
{
b[7].setText(String.valueOf(0));
a=1;
}
else
{
b[7].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[7].setEnabled(false);
}


if(ae.getSource()==b[8])
{
if(a==0)
{
b[8].setText(String.valueOf(0));
a=1;
}
else
{
b[8].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[8].setEnabled(false);
}


if(ae.getSource()==b[9])
{
if(a==0)
{
b[9].setText(String.valueOf(0));
a=1;
}
else
{
b[9].setText("x");
a=0;
}
//l2.setForeground(Color.green);
b[9].setEnabled(false);
}



}




if(ae.getSource()==b10)
{
b[1].setText("");
b[2].setText("");
b[3].setText("");
b[4].setText("");
b[5].setText("");
b[6].setText("");
b[7].setText("");
b[8].setText("");
b[9].setText("");

for(int f=1;f<=9;f++)
{
b[f].setEnabled(true);
}

a=0;

c=rand.nextInt(9)+1;
b[c].setText(String.valueOf(0));
b[c].setEnabled(false);

}
}
public static void main(String op[])
{
new tic_tac();
}
}

