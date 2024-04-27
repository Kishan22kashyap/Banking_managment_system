package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//For Action Listener In awt event inside perfor event
import java.sql.*;
//import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup; //Here We Declare JButton In Global variable
     JTextField cardTextField;
     JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATIC TELLER MACHINE:");
        // make frame is present in swing package
       setLayout(null);//custom layout
        
       
  

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.jpg"));
        Image img2 = img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(70, 10, 100, 100);//here (150,20 is a left to top height width)&(150,170 image height-width)
        add(label);
        JLabel text =new JLabel("👌👌!!WELCOME TO ATM !!👌👍👍");
        text.setFont(new Font("verdna",Font.BOLD,25));//Font size increase
        text.setBounds(200,20,400,100);
        add(text);
        
        JLabel cardno =new JLabel("Card Number:");
        cardno.setFont(new Font("verdna",Font.BOLD,25));//Font size increase
        cardno.setBounds(100,100,200,100);
        add(cardno);
        //jtextfield class for Field
        cardTextField =new JTextField();
        cardTextField.setBounds(300,140,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(cardTextField);
        
        JLabel pin =new JLabel("Pin Number:");
        pin.setFont(new Font("verdna",Font.BOLD,25));//Font size increase
        pin.setBounds(100,160,400,100);
        add(pin);
        
        pinTextField =new JPasswordField();
        pinTextField.setBounds(300,200,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(pinTextField);
        //here JButton is a local Variable so we create a global variable and remove it
        //JButton login =new JButton("SIGN IN");For Example
         login =new JButton("SIGN IN");
        login.setBounds(300,270,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
         clear =new JButton("CLEAR");
        clear.setBounds(430,270,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
         signup =new JButton("SIGN UP");
        signup.setBounds(300,320,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
       
        getContentPane().setBackground(Color.pink);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
       
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
             // ab kal ke lecture me dekhana hain.
             Conn conn =new Conn();
             String cardnumber=cardTextField.getText();
             String pinnumber=pinTextField.getText();//getText Show the Password
             
             String query ="select * from login where cardnumber= '"+cardnumber+"' and pin='"+pinnumber+"'";
             try{
                 ResultSet rs =conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }else{
                     JOptionPane.showConfirmDialog(null, "Incorrect Card Number or Pin");
                 }
             }catch(Exception e){
                 System.out.println(e);
             }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
      new Login();
      
    }
         
    
}
