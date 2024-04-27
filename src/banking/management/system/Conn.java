
package banking.management.system;

import java.sql.*;
 
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
           //Class.forName(com.mysql.cj.jdbc.Driver);//Driver Name not write
           //connection String
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","kishan@123456");
           s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

                                                       
