import java.awt.event.*;
import javax.swing.*;
public class Convertor implements ActionListener{

    JFrame jf;
    JPanel jp;
    JComboBox<String> jcb1,jcb2;
    JButton jb;
    JTextField jet,jet1;
    JLabel jl;
	Convertor(){
        
      jf=new JFrame();
      jf.setSize(700,500);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jp=new JPanel();
      jf.add(jp);
      String[] choice1={"ruppees","dollar","rial","dinar","euro"};
      //combobox1
       jcb1=new JComboBox<String>(choice1);
       jcb1.setVisible(true);
       jp.add(jcb1);
       String[] choice2={"ruppees","dollar","rial","dinar","euro"};
       //combobox2
       jcb2=new JComboBox<String>(choice2);
       jcb2.setVisible(true);
       jp.add(jcb2);
       //textfield1
        jet=new JTextField("                      ");
        jp.add(jet);
        //textfield2
       jet1=new JTextField("                      ");
       jp.add(jet1);
       //button
       jb=new JButton("submit");
       jb.setVisible(true);
       jp.add(jb);
       jb.addActionListener(this);
       jf.setVisible(true);
      
      
	}
	String[] value={"ruppees","dollar","rial","dinar","euro"};
	int x,y;
	double answer,z;
	String print;
	 double[][] array={{1.0,0.014,0.054,0.053,0.013},{69.10,1.0,3.75,3.67,0.88},{18.42,0.27,1.0,0.98,0.23},{18.81,0.27,1.02,1.0,0.24},{78.92,1.14,4.28,4.20,1.0}};
	public void actionPerformed(ActionEvent e){
        try{

		     if(e.getSource()==jb){

			 String string1=jcb1.getSelectedItem().toString();
			 String string2=jcb2.getSelectedItem().toString();
			 String input=jet.getText();
			 z=Double.parseDouble(input);
			 for(int i=0;i<value.length;i++){
				   if(string1.equals(value[i])){
					   x=i;
				    }
				   if(string2.equals(value[i])){
				      y=i;
				    }
			   }
            answer=z*array[x][y];
            print=Double.toString(answer);
            
            jet1.setText(print);
		}
	  }
	     catch(Exception ec){

	     }

	}
	static public void main(String... arg){

		Convertor convertor=new Convertor();
	}

}