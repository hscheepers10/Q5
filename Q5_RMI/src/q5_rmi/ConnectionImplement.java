/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5_rmi;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionImplement implements ConnectInterface {

    @Override
    public void insert(int dID, String dName, String dSurname, int dAge, int dCellNumber, String dDegree) throws Exception {
        
        String host = "localhost";
        String db = "registrants";
        String usrnm = "root";
        String psswrd = "root";
        String URL = "jdbc:mysql//"+host+":3308/"+db;
        
        try{
            Connection dBcon = DriverManager.getConnection(URL,usrnm,psswrd);
            Statement st = (Statement) dBcon.createStatement();
            String Q1 =  "INSERT INTO students (idnumber,name,surname,age,cellnumber,degree)"
                    + " VALUES('"+dID+"','"+dName+"','"+dSurname+"','"+dAge+"','"+dCellNumber+"','"+dDegree+"')";
            st.execute();
        }
        catch(SQLException ex){
            
        }
    }
    
}
