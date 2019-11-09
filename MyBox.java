 import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

class MyBox implements ActionListener
{
  Socket s1;
  JFrame f;
  JButton b;
  JTextArea t1;
  JTextArea t2;
   ObjectInputStream ois;
   ObjectOutputStream oos;
  MyBox() throws Exception
  {
	  
       f=new JFrame("myframe");
	   b=new JButton("send message");
	   b.setBounds(350,300,90,30);
	   f.add(b);
       t1=new JTextArea();
	   t1.setBounds(20,30,450,200);
	   f.add(t1);
	   t2=new JTextArea();
	   t2.setBounds(20,250,295,100);
	   f.add(t2);
       f.setLayout(null);
       f.setSize(500,500);
       f.setVisible(true);
	   t1.setEditable(false);
        b.addActionListener(this);
        ServerSocket ss=new ServerSocket(9233);
        s1=ss.accept();
	    oos=new ObjectOutputStream(s1.getOutputStream());
  
          try
          {
			  
               ois=new ObjectInputStream(s1.getInputStream());
              while(true)
          {
               
	      String message=(String)ois.readObject();
	      t1.append("message from client: "+message+"\n");
          }
          }
          catch(Exception e){}
        }
           public void actionPerformed(ActionEvent e)
          {
             try
           {        

			 
              if(e.getSource()==b)
            {
			  oos.writeObject(t2.getText());
			  t1.append("message from server: "+t2.getText()+"\n");
			  t2.setText("");
            }
	  
		   }
	      catch(Exception exc){}
         }
          public static void main(String... args)throws Exception
      {
                          MyBox mb=new MyBox();
      }
    }