
package banking.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
     
    //long random;
    JTextField pan, aadhar ;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
     
    JComboBox religion,category ,occupation,education,income;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails =new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Arial",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name =new JLabel("Religion:");
        name.setFont(new Font("Arial",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        //Jcombox for DropDown
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christan","others"};
        religion =new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        JLabel fname =new JLabel("Category :");
        fname.setFont(new Font("Arial",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        String valcategory[]={"General","OBC","SC","ST","Other"};
        category =new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        
        JLabel dob =new JLabel("Income:");
        dob.setFont(new Font("Arial",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[]={"Null","< 1,50,000","< 2,50,000","<5,00,000","Upto 10,00,000"};
        income =new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        
        
        JLabel gender =new JLabel("Educational:");
        gender.setFont(new Font("Arial",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        
        JLabel email =new JLabel("Qualification:");
        email.setFont(new Font("Arial",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[]={"Non-Graduation", "Graduate","Post-Graduation","Doctrate","Others"};
        education =new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital =new JLabel("Occupation:");
        marital.setFont(new Font("Arial",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[]={"Salaried", "Self Employed","Bussiness","Student","Retired","others"};
        occupation =new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
       occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
       
        
        
        JLabel pannumber =new JLabel("PAN Number:");
        pannumber.setFont(new Font("Arial",Font.BOLD,22));
        pannumber.setBounds(100,440,200,30);
        add(pannumber);
        
        pan =new JTextField();
        pan.setFont(new Font("Arial",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadharNumber =new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Arial",Font.BOLD,22));
        aadharNumber.setBounds(100,490,200,30);
        add(aadharNumber);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Arial",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state =new JLabel("Senior Citizen:");
        state.setFont(new Font("Arial",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorcitzen=new ButtonGroup();
        seniorcitzen.add(syes);
        seniorcitzen.add(sno);
        
        
        
        JLabel account=new JLabel("Exisiting Account:");
        account.setFont(new Font("Arial",Font.BOLD,22));
        account.setBounds(100,590,200,30);
        add(account);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingAccount=new ButtonGroup();
        existingAccount.add(eyes);
        existingAccount.add(eno);
        
        
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
      
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
                
    }
    public void actionPerformed(ActionEvent ae){
       // String formno= "" + random; //long
        String sreligion =(String)religion.getSelectedItem();//setText
       String scategory =(String)category.getSelectedItem();
        String sincome =(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitzen =null;
        if(syes.isSelected()){
            seniorcitzen="Yes";
        }else if(sno.isSelected()){
            seniorcitzen="No";
        }
   
        String existingaccount =null;
        if(eyes.isSelected()){
            existingaccount ="Yes";
        }else if(eno.isSelected()){
            existingaccount ="No";
        }
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        
        try{
            
                Conn c=new Conn();
                String query ="insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitzen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
            
                
                //Signup3 objectVisible
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
