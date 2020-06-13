import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class entry extends JFrame implements ItemListener,ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3;
ImageIcon i1;
JTable jt;
JScrollPane sp;
JButton b1,b2;
JRadioButton rb1,rb2;
Container con1=getContentPane();
Connection con;
Statement stm;
java.util.Date d1=new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy/MM/dd");
entry()
{
setSize(500,500);
setLayout(null);
con1.setBackground(Color.black);

jt=new JTable();
sp=new JScrollPane(jt);

i1=new ImageIcon("ml.jpg");
l6=new JLabel(i1);

l1=new JLabel("2 Players");
l2=new JLabel("Computer");
l3=new JLabel("Player 1");
l4=new JLabel("Player 2");
l5=new JLabel("Player  Name");

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);

rb1=new JRadioButton("2 Players");
rb2=new JRadioButton("Computer");

b1=new JButton("Start Game");
b2=new JButton("Satistics");
b1.setFont(new Font("Segoe Print",Font.BOLD,20));
b2.setFont(new Font("Segoe Print",Font.BOLD,20));


rb1.setFont(new Font("Segoe Print",Font.BOLD,25));
rb2.setFont(new Font("Segoe Print",Font.BOLD,25));

rb1.setForeground(Color.white);
rb2.setForeground(Color.white);

l3.setForeground(Color.red);
l5.setForeground(Color.red);
l4.setForeground(Color.red);

tf1.setBackground(Color.white);
tf2.setBackground(Color.white);
tf3.setBackground(Color.white);

tf1.setForeground(Color.blue);
tf2.setForeground(Color.blue);
tf3.setForeground(Color.blue);


l1.setFont(new Font("Segoe Print",Font.BOLD,22));
l2.setFont(new Font("Segoe Print",Font.BOLD,22));
l3.setFont(new Font("Segoe Print",Font.BOLD,22));
l4.setFont(new Font("Segoe Print",Font.BOLD,22));
l5.setFont(new Font("Segoe Print",Font.BOLD,22));

tf1.setFont(new Font("Times New Roman",Font.BOLD,25));
tf2.setFont(new Font("Times New Roman",Font.BOLD,25));
tf3.setFont(new Font("Times New Roman",Font.BOLD,25));

rb1.setOpaque(false);
rb2.setOpaque(false);

ButtonGroup bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);

add(rb1);
add(rb2);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(tf1);
add(tf2);
add(tf3);

add(b1);
add(b2);


rb1.setBounds(20,20,150,30);
rb2.setBounds(300,20,150,30);
l3.setBounds(20,60,150,30);
tf1.setBounds(20,95,200,30);
l4.setBounds(20,135,150,30);
tf2.setBounds(20,170,200,30);
l5.setBounds(300,60,200,30);
tf3.setBounds(300,95,180,30);
b1.setBounds(180,250,200,25);
b2.setBounds(200,285,160,25);
l6.setBounds(0,0,1360,750);

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

b1.addActionListener(this);
b2.addActionListener(this);

add(sp);
add(l6);
setVisible(true);
}
public void itemStateChanged(ItemEvent ie)
{}

String gdate="";
public void actionPerformed(ActionEvent ae)
{
int size=0;
int count=0;
int p=0;
try
{
if(ae.getSource()==b2)
{
ResultSet rs=stm.executeQuery("select count(*) from gamedata");
if(rs.next())
size=rs.getInt(1);
else 
JOptionPane.showMessageDialog(this,"No Record Exist");


if(size>0)
{
String so[]={"Player 1","Player 2","Won By","Date"};
Object obj[][]=new Object[size][4];

if(sp!=null)
remove(sp);

ResultSet rs1=stm.executeQuery("select * from gamedata");
while(rs1.next())
{
obj[p][0]=rs1.getString(1);
obj[p][1]=rs1.getString(2);
obj[p][2]=rs1.getString(3);
obj[p][3]=rs1.getDate(4);
p++;
}

DefaultTableModel model1=new DefaultTableModel(obj,so);
jt=new JTable(model1)
{
public boolean isCellEditable(int r,int c)
{
if(c==6)
return true;
else 
return false;
}
};

sp=new JScrollPane(jt);
sp.setBounds(600,50,500,30*(size+1));
add(sp);
}
setExtendedState(JFrame.MAXIMIZED_BOTH);

}



if(ae.getSource()==b1)
{
gdate=sdf.format(d1);
if(rb1.isSelected())
{
if((tf1.getText().equals(""))||(tf2.getText().equals("")))
{
count=1;
JOptionPane.showMessageDialog(this,"Kindly Fill The Names");
}
if(count==0)
{
String se="insert into gamedata values('"+tf1.getText()+"' , '"+tf2.getText()+"', 'None' , '"+gdate+"')";
stm.executeUpdate(se);
new tic_tac_toe(tf1.getText(),tf2.getText());
}
}
else if(rb2.isSelected())
{
if(tf3.getText().equals(""))
{
count=2;
JOptionPane.showMessageDialog(this,"Kindly Fill The Name");
}
else
{
String se="insert into gamedata values('computer' ,'"+tf3.getText()+"' , 'None' , '"+gdate+"')";
//stm.executeUpdate(se);
new tic(tf3.getText());
}
}
}
}
catch(Exception ee)
{
ee.printStackTrace();
}
}
public static void main(String kl[])
{
new entry();
}
}