import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.sql.*;
class tic extends JFrame implements ActionListener,FocusListener
{
JButton b[]=new JButton[10];
JButton b10;
JLabel l1,l2;
Container con1=getContentPane();
String type="";
Random rand;
int c=0;
Connection con;
Statement stm;
java.util.Date d1=new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");
static void onButon(JButton bm)
{
bm.setText("x");
bm.setEnabled(false);
}
String player1="";
tic(String name)
{
player1=name;
type="computer";
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con1.setBackground(Color.black);

rand=new Random();

int t=0;
for(t=1;t<=9;t++)
{
b[t]=new JButton("");
}

b10=new JButton("New Game");

for(int p=1;p<=9;p++)
{
b[p].setFont(new Font("Segoe Print",Font.BOLD,25));
}

for(int u=1;u<=9;u++)
{
b[u].setForeground(Color.blue);
}

b10.setFont(new Font("Segoe Print",Font.BOLD,20));
b10.setForeground(Color.blue);

b[1].setBackground(Color.red);
b[3].setBackground(Color.red);
b[5].setBackground(Color.red);
b[7].setBackground(Color.red);
b[9].setBackground(Color.red);
b[2].setBackground(Color.white);
b[4].setBackground(Color.white);
b[6].setBackground(Color.white);
b[8].setBackground(Color.white);

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

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/tic_tac_toe","root","");
stm=con.createStatement();
}
catch(Exception e)
{
e.printStackTrace();
}


int al=0;
for(al=1;al<=9;al++)
b[al].addActionListener(this);

int fl=0;
for(fl=1;fl<=9;fl++)
b[fl].addFocusListener(this);

int po=0;
for(po=1;po<=9;po++)
b[po].setEnabled(false);

b10.addActionListener(this);

setVisible(true);
}


public void focusGained(FocusEvent fe)
{}

public void focusLost(FocusEvent fe)
{
try
{
if((fe.getSource()==b[1])||(fe.getSource()==b[2])||(fe.getSource()==b[3])||(fe.getSource()==b[4])||(fe.getSource()==b[5])||(fe.getSource()==b[6])||(fe.getSource()==b[7])||(fe.getSource()==b[8])||(fe.getSource()==b[9]))
{
if(((b[1].getText().equals("o"))&&(b[2].getText().equals("o"))&&(b[3].getText().equals("o")))||((b[4].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[6].getText().equals("o")))||((b[7].getText().equals("o"))&&(b[8].getText().equals("o"))&&(b[9].getText().equals("o")))||((b[1].getText().equals("o"))&&(b[4].getText().equals("o"))&&(b[7].getText().equals("o")))||((b[2].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[8].getText().equals("o")))||((b[3].getText().equals("o"))&&(b[6].getText().equals("o"))&&(b[9].getText().equals("o")))||((b[1].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[9].getText().equals("o")))||((b[3].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[7].getText().equals("o"))))
{
JOptionPane.showMessageDialog(this,"Computer Wins");
b10.doClick();

String se="insert into gamedata values('computer' ,'"+player1+"' , 'computer' , '"+gdate+"')";
stm.executeUpdate(se);
}
else if(((b[1].getText().equals("x"))&&(b[2].getText().equals("x"))&&(b[3].getText().equals("x")))||((b[4].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[6].getText().equals("x")))||((b[7].getText().equals("x"))&&(b[8].getText().equals("x"))&&(b[9].getText().equals("x")))||((b[1].getText().equals("x"))&&(b[4].getText().equals("x"))&&(b[7].getText().equals("x")))||((b[2].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[8].getText().equals("x")))||((b[3].getText().equals("x"))&&(b[6].getText().equals("x"))&&(b[9].getText().equals("x")))||((b[1].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[9].getText().equals("x")))||((b[3].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[7].getText().equals("x"))))
{
JOptionPane.showMessageDialog(this,"Congrats You Wins");
b10.doClick();

String se="insert into gamedata values('computer' ,'"+player1+"' , '"+player1+"' , '"+gdate+"')";
stm.executeUpdate(se);

}
//else if(!((b[1].getText().equals(""))&&(b[2].getText().equals(""))&&(b[3].getText().equals(""))&&(b[4].getText().equals(""))&&(b[5].getText().equals(""))&&(b[6].getText().equals(""))&&(b[7].getText().equals(""))&&(b[8].getText().equals(""))&&(b[9].getText().equals(""))))
//{
//JOptionPane.showMessageDialog(this,"Game Drawn");
//b10.doClick();
//}

}
}
catch(Exception eee)
{
eee.printStackTrace();
}
}


void turnChange()
{
try
{

if((b[1].getText().equals("o"))&&(b[2].getText().equals("o"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[2].getText().equals("o"))&&(b[3].getText().equals("o"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("o"))&&(b[3].getText().equals("o"))&&(b[2].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[2].setText("o");
b[2].setEnabled(false);
}

else if((b[1].getText().equals("o"))&&(b[4].getText().equals("o"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[4].getText().equals("o"))&&(b[7].getText().equals("o"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("o"))&&(b[7].getText().equals("o"))&&(b[4].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[4].setText("o");
b[4].setEnabled(false);
}

else if((b[4].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[6].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[6].setText("o");
b[6].setEnabled(false);
}

else if((b[5].getText().equals("o"))&&(b[6].getText().equals("o"))&&(b[4].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[4].setText("o");
b[4].setEnabled(false);
}

else if((b[4].getText().equals("o"))&&(b[6].getText().equals("o"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[2].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[8].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[8].setText("o");
b[8].setEnabled(false);
}

else if((b[5].getText().equals("o"))&&(b[8].getText().equals("o"))&&(b[2].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[2].setText("o");
b[2].setEnabled(false);
}

else if((b[2].getText().equals("o"))&&(b[8].getText().equals("o"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[7].getText().equals("o"))&&(b[8].getText().equals("o"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[8].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[7].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[8].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[8].setText("o");
b[8].setEnabled(false);
}

else if((b[3].getText().equals("o"))&&(b[6].getText().equals("o"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[6].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[3].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[6].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[6].setText("o");
b[6].setEnabled(false);
}

else if((b[3].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[5].getText().equals("o"))&&(b[7].getText().equals("o"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[3].getText().equals("o"))&&(b[7].getText().equals("o"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[1].getText().equals("o"))&&(b[5].getText().equals("o"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[5].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("o"))&&(b[9].getText().equals("o"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}





else if((b[1].getText().equals("x"))&&(b[2].getText().equals("x"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[2].getText().equals("x"))&&(b[3].getText().equals("x"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("x"))&&(b[3].getText().equals("x"))&&(b[2].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[2].setText("o");
b[2].setEnabled(false);
}

else if((b[1].getText().equals("x"))&&(b[4].getText().equals("x"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[4].getText().equals("x"))&&(b[7].getText().equals("x"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("x"))&&(b[7].getText().equals("x"))&&(b[4].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(1);
b[4].setText("o");
b[4].setEnabled(false);
}

else if((b[4].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[6].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[6].setText("o");
b[6].setEnabled(false);
}

else if((b[5].getText().equals("x"))&&(b[6].getText().equals("x"))&&(b[4].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[4].setText("o");
b[4].setEnabled(false);
}

else if((b[4].getText().equals("x"))&&(b[6].getText().equals("x"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[2].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[8].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[8].setText("o");
b[8].setEnabled(false);
}

else if((b[5].getText().equals("x"))&&(b[8].getText().equals("x"))&&(b[2].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[2].setText("o");
b[2].setEnabled(false);
}

else if((b[2].getText().equals("x"))&&(b[8].getText().equals("x"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[7].getText().equals("x"))&&(b[8].getText().equals("x"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[8].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[7].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[8].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[8].setText("o");
b[8].setEnabled(false);
}

else if((b[3].getText().equals("x"))&&(b[6].getText().equals("x"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[6].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[3].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[6].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[6].setText("o");
b[6].setEnabled(false);
}

else if((b[3].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[7].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[7].setText("o");
b[7].setEnabled(false);
}

else if((b[5].getText().equals("x"))&&(b[7].getText().equals("x"))&&(b[3].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[3].setText("o");
b[3].setEnabled(false);
}

else if((b[3].getText().equals("x"))&&(b[7].getText().equals("x"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}

else if((b[1].getText().equals("x"))&&(b[5].getText().equals("x"))&&(b[9].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[9].setText("o");
b[9].setEnabled(false);
}

else if((b[5].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[1].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[1].setText("o");
b[1].setEnabled(false);
}

else if((b[1].getText().equals("x"))&&(b[9].getText().equals("x"))&&(b[5].getText().equals("")))
{
TimeUnit.MILLISECONDS.sleep(100);
b[5].setText("o");
b[5].setEnabled(false);
}







else 
{
while((b[1].getText().equals(""))||(b[2].getText().equals(""))||(b[3].getText().equals(""))||(b[4].getText().equals(""))||(b[5].getText().equals(""))||(b[6].getText().equals(""))||(b[7].getText().equals(""))||(b[8].getText().equals(""))||(b[9].getText().equals("")))
{
int check=0;
check=rand.nextInt(9)+1;
if(b[check].getText().equals(""))
{
b[check].setText("o");
b[check].setEnabled(false);
break;
}
}
}
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
String gdate="";
public void actionPerformed(ActionEvent ae)
{
gdate=sdf.format(d1);
if(ae.getSource()==b[1])
{
onButon(b[1]);
turnChange();
}

if(ae.getSource()==b[2])
{
onButon(b[2]);
turnChange();
}

if(ae.getSource()==b[3])
{
onButon(b[3]);
turnChange();
}

if(ae.getSource()==b[4])
{
onButon(b[4]);
turnChange();
}

if(ae.getSource()==b[5])
{
onButon(b[5]);
turnChange();
}

if(ae.getSource()==b[6])
{
onButon(b[6]);
turnChange();
}

if(ae.getSource()==b[7])
{
onButon(b[7]);
turnChange();
}

if(ae.getSource()==b[8])
{
onButon(b[8]);
turnChange();
}

if(ae.getSource()==b[9])
{
onButon(b[9]);
turnChange();
}

if(ae.getSource()==b10)
{
int po=0;
for(po=1;po<=9;po++)
{
b[po].setEnabled(true);
b[po].setText("");
}

int c=0;
c=rand.nextInt(9)+1;
b[c].setText("o");
b[c].setEnabled(false);
}
}

public static void main(String op[])
{
new tic("");
}
}