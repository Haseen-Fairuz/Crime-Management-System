import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
class CrimeRecord implements ActionListener
{
  String id,cnm,nm,date,status;
  String pid,pass,pnm;
  JFrame f1,f2,f3;
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
  JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
  TextField p1;
  JRadioButton r1,r2;
  ButtonGroup bg1,bg2;
  JPanel pa1;
  JButton submit,display,edit,update,p_update,b1,b2,b3,b4;
  DefaultTableModel model=new DefaultTableModel();
  JTable jtbl=new JTable(model);
  JScrollPane sp=new JScrollPane(jtbl);
  CrimeRecord()
  {
   f1=new JFrame("Login Page");
   f2=new JFrame("Crime Records");
   f3=new JFrame("Table");
   f1.setLayout(null);
   f2.setLayout(null);
   f3.setLayout(null);
   l1=new JLabel("POLICE LOGIN");
   l2=new JLabel("Login ID:");     //user id,police id
   l3=new JLabel("Password:");
   l4=new JLabel("case id:");
   l5=new JLabel("case name:");
   l6=new JLabel("accused:");
   l7=new JLabel("date:");
   l8=new JLabel("status:");
   l9=new JLabel("case id:");
   l10=new JLabel("new status:");
   l11=new JLabel("police id:");
   l12=new JLabel("name:");
   l13=new JLabel("password:");
   l14=new JLabel("case id:");
   t1=new JTextField(15);          //id entry
   t2=new JTextField(15);
   t3=new JTextField(15);
   t4=new JTextField(15);
   t5=new JTextField(15);
   t6=new JTextField(15);
   t7=new JTextField(15);
   t8=new JTextField(15);
   t9=new JTextField(15);
   t10=new JTextField(15);
   t11=new JTextField(15);
   t12=new JTextField(15);            
   p1=new TextField(15); //password entry
   p1.setEchoChar('*');   
   submit=new JButton("Submit");  
   display=new JButton("Display");
   edit=new JButton("Edit Status");
   update=new JButton("Update");
   b1=new JButton("SUBMIT");
   b2=new JButton("Edit");
   b3=new JButton("Ok");
   b4=new JButton("Select");
   p_update=new JButton("Police Update");
   pa1=new JPanel();
   r1=new JRadioButton("display all");
   r2=new JRadioButton("select by id");
 
   bg1=new ButtonGroup();
   bg1.add(r1);bg1.add(r2);
   pa1.add(r1);pa1.add(r2);
   l1.setBounds(100,10,100,30);
   l2.setBounds(20,50,100,30);
   t1.setBounds(150,50,200,30);
   l3.setBounds(20,90,100,30);
   p1.setBounds(150,90,200,30);
   submit.setBounds(100,140,100,30);
   display.setBounds(20,50,100,30);
   edit.setBounds(150,50,150,30);
   update.setBounds(330,50,100,30);
   p_update.setBounds(450,50,150,30);
   pa1.setBounds(50,100,300,40);
   l4.setBounds(20,100,100,30);
   l5.setBounds(20,140,100,30);
   l6.setBounds(20,180,100,30);
   l7.setBounds(20,220,100,30);
   l8.setBounds(20,260,100,30);
   l9.setBounds(20,100,100,30);
   l10.setBounds(20,140,100,30);
   t2.setBounds(120,100,200,30);
   t3.setBounds(120,140,200,30);
   t4.setBounds(120,180,200,30);
   t5.setBounds(120,220,200,30);
   t6.setBounds(120,260,200,30);
   t7.setBounds(120,100,200,30);
   t8.setBounds(120,140,200,30);
   l11.setBounds(20,100,100,30);
   l12.setBounds(20,140,100,30);
   l13.setBounds(20,180,100,30);
   t9.setBounds(120,100,200,30);
   t10.setBounds(120,140,200,30);
   t11.setBounds(120,180,200,30);
   b1.setBounds(120,300,100,30);
   b2.setBounds(120,180,100,30);
   b3.setBounds(120,220,100,30);
   l14.setBounds(20,140,100,30);
   t12.setBounds(120,140,200,30);
   b4.setBounds(120,180,100,30);
   sp.setBounds(20,50,500,400);
   submit.addActionListener(this);
   display.addActionListener(this);
   edit.addActionListener(this);
   update.addActionListener(this);
   b1.addActionListener(this);
   b2.addActionListener(this);
   p_update.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   r1.addActionListener(this);
   r2.addActionListener(this);
   
   f1.add(l1);f1.add(l2);
   f1.add(l3);f1.add(t1);
   f1.add(p1);
   f1.add(submit);f2.add(display);
   f2.add(edit);f2.add(update);
   f2.add(p_update);
   f2.add(pa1);f2.add(l4);
   f2.add(l5);f2.add(l6);
   f2.add(l7);f2.add(t2);
   f2.add(t3);f2.add(t4);
   f2.add(t5);f2.add(b1);
   f2.add(l8);f2.add(t6);
   f2.add(l9);f2.add(l10);
   f2.add(t7);f2.add(t8);
   f2.add(b2);f2.add(b4);
   f2.add(b3);f2.add(l11);
   f2.add(l12);f2.add(l13);
   f2.add(t9);f2.add(t10);
   f2.add(t11);f2.add(b3);
   f3.add(sp);f2.add(l14);
   f2.add(t12);
   pa1.setVisible(false);
   f1.setVisible(true);
   f2.setVisible(false);
   f3.setVisible(false);
   l4.setVisible(false);l5.setVisible(false);
   l6.setVisible(false);l7.setVisible(false);
   l8.setVisible(false);t2.setVisible(false);
   t3.setVisible(false);t4.setVisible(false);
   t5.setVisible(false);t6.setVisible(false);
   b1.setVisible(false);l8.setVisible(false);
   l9.setVisible(false);l10.setVisible(false);
   t7.setVisible(false);t8.setVisible(false);
   b2.setVisible(false);l11.setVisible(false);
   l12.setVisible(false);l13.setVisible(false);
   t9.setVisible(false);t10.setVisible(false);
   t11.setVisible(false);b3.setVisible(false);
   l14.setVisible(false);t12.setVisible(false);
   b4.setVisible(false);
   f1.setSize(400,300);
   f2.setSize(650,400);
   f3.setSize(600,400);
   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   model.addColumn("Case ID");
   model.addColumn("Case Name");
   model.addColumn("Name");
   model.addColumn("Date");
   model.addColumn("Status");
 }
  public void actionPerformed(ActionEvent e)
  {
     String s=e.getActionCommand();
     String sql=new String();
     Boolean flag=true;
     try
     {
      Class.forName("org.postgresql.Driver");
      Connection c=DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/qkgqbcst","qkgqbcst","N6g8HBpac2AxOZyjr4fx4y9ErovJZbuY");
      Statement stat=c.createStatement();
      ResultSet rs;
      int a;
      if(s.equals("Submit"))
      {
        pid=t1.getText();
        pass=p1.getText();
        rs=stat.executeQuery("select password from plogin where p_id='"+pid+"';");
        while(rs.next())
        {
          String p=rs.getString("password");
          p=p.trim();
          if(pass.equals(p))
          {
            flag=false;
          }
          if(flag)
          {
            JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD","Alert",JOptionPane.WARNING_MESSAGE);
          }
          else
          {
            f2.setVisible(true);
          }
          t1.setText("");
          p1.setText("");
        }
       }
       else if(s.equals("Display"))
       {
          model.setRowCount(0);
          l4.setVisible(false);l5.setVisible(false);
          l6.setVisible(false);l7.setVisible(false);
          l8.setVisible(false);t2.setVisible(false);
          t3.setVisible(false);t4.setVisible(false);
          t5.setVisible(false);t6.setVisible(false);
          b1.setVisible(false);l9.setVisible(false);
          l10.setVisible(false);t7.setVisible(false);
          t8.setVisible(false);b2.setVisible(false);
          l11.setVisible(false);
          l12.setVisible(false);l13.setVisible(false);
          t9.setVisible(false);t10.setVisible(false);
          t11.setVisible(false);b3.setVisible(false);
          l14.setVisible(false);t12.setVisible(false);
          b4.setVisible(false);
          pa1.setVisible(true);
        }
        else if(s.equals("display all"))
       {
         model.setRowCount(0);
        l14.setVisible(false);t12.setVisible(false);
        b4.setVisible(false);
        f3.setVisible(true);
        rs=stat.executeQuery("select * from crimerecord;");
        while(rs.next())
        {
      id=rs.getString("c_id");
      id=id.trim();
      cnm=rs.getString("c_name");
      cnm=cnm.trim();
      nm=rs.getString("name");
      nm=nm.trim();
      date=rs.getString("r_date");
      date=date.trim();
      status=rs.getString("status");
      status=status.trim();
         model.addRow(new Object[]{id,cnm,nm,date,status});
       }
      }
     else if(s.equals("select by id"))
     {
       model.setRowCount(0);
       l14.setVisible(true);t12.setVisible(true);
       b4.setVisible(true);
    }
    else if(s.equals("Select"))
    {
       f3.setVisible(true);
       id=t12.getText();
       rs=stat.executeQuery("select * from crimerecord where c_id="+id+";");
       while(rs.next())
       {
        cnm=rs.getString("c_name");
        cnm=cnm.trim();
        nm=rs.getString("name");
        nm=nm.trim();
        date=rs.getString("r_date");
        date=date.trim();
        status=rs.getString("status");
        status=status.trim();
        model.addRow(new Object[]{id,cnm,nm,date,status});
        }
        t12.setText("");
    }
    else if(s.equals("Edit Status"))
       {
          model.setRowCount(0);
          l4.setVisible(false);l5.setVisible(false);
          l6.setVisible(false);l7.setVisible(false);
          l8.setVisible(false);t2.setVisible(false);
          t3.setVisible(false);t4.setVisible(false);
          t5.setVisible(false);t6.setVisible(false);
          b1.setVisible(false);pa1.setVisible(false);
          l11.setVisible(false);
          l12.setVisible(false);l13.setVisible(false);
          t9.setVisible(false);t10.setVisible(false);
          t11.setVisible(false);b3.setVisible(false);
          l14.setVisible(false);t12.setVisible(false);
          b4.setVisible(false);
          l9.setVisible(true);l10.setVisible(true);
          t7.setVisible(true);t8.setVisible(true);
          b2.setVisible(true);
       }
       else if(s.equals("Edit"))
       {
         id=t7.getText();
         status=t8.getText();
         rs=stat.executeQuery("select c_id from crimerecord;");
         while(rs.next())
         {
          String cid=rs.getString("c_id");
          cid=cid.trim();
          if(id.equals(cid))
          {
            flag=false;
          }
         }
          if(flag)
          {
            JOptionPane.showMessageDialog(null,"ID DOESNOT EXIST","Alert",JOptionPane.WARNING_MESSAGE);
          }
          else
          {
            stat.executeUpdate("update crimerecord set status='"+status+"' where c_id="+id+";");
          }
          t7.setText("");
          t8.setText("");

      }
       else if(s.equals("Update"))
       {
         model.setRowCount(0);  
         pa1.setVisible(false);l9.setVisible(false);
         l10.setVisible(false);t7.setVisible(false);
         t8.setVisible(false);b2.setVisible(false);
         l11.setVisible(false);
         l12.setVisible(false);l13.setVisible(false);
         t9.setVisible(false);t10.setVisible(false);
         t11.setVisible(false);b3.setVisible(false);
         l14.setVisible(false);t12.setVisible(false);
         b4.setVisible(false);
         l4.setVisible(true);l5.setVisible(true);
         l6.setVisible(true);l7.setVisible(true);
         l8.setVisible(true);t2.setVisible(true);
         t3.setVisible(true);t4.setVisible(true);
         t5.setVisible(true);t6.setVisible(true);
         b1.setVisible(true);
       }
       else if(s.equals("SUBMIT"))
       {
           id=t2.getText();
           cnm=t3.getText();
           nm=t4.getText();
           date=t5.getText();
           status=t6.getText();
           sql="insert into crimerecord values("+id+ ",'"+cnm+ "','"+nm+ "','"+date+ "','"+status+ "');";
           a=stat.executeUpdate(sql);
           
           t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
       }
       else if(s.equals("Police Update"))
       {
          model.setRowCount(0);
          l4.setVisible(false);l5.setVisible(false);
          l6.setVisible(false);l7.setVisible(false);
          l8.setVisible(false);t2.setVisible(false);
          t3.setVisible(false);t4.setVisible(false);
          t5.setVisible(false);t6.setVisible(false);
          b1.setVisible(false);l9.setVisible(false);
          l10.setVisible(false);t7.setVisible(false);
          t8.setVisible(false);b2.setVisible(false);
          pa1.setVisible(false);
          l14.setVisible(false);t12.setVisible(false);
          b4.setVisible(false);
          l11.setVisible(true);
          l12.setVisible(true);l13.setVisible(true);
          t9.setVisible(true);t10.setVisible(true);
          t11.setVisible(true);b3.setVisible(true);
        }
        else if(s.equals("Ok"))
        {
           pid=t9.getText();
           pnm=t10.getText();
           pass=t11.getText();
           sql="insert into plogin values("+pid+ ",'"+pnm+ "','"+pass+ "');";
           a=stat.executeUpdate(sql);
           
           t9.setText("");
           t10.setText("");
           t11.setText("");
         }  
      stat.close();
      c.close();
     }
     catch(Exception ex)
     {
       System.out.println(ex);
     }
  }
  public  static void main(String args[])
  {
     new CrimeRecord();
  }

}
