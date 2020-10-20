/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package q5_rmi;

import com.sun.security.ntlm.Client;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * @author User
 */

public class Q5_Client extends JFrame {

    //Attributes.  
    JLabel titleLbl, devLbl, idLbl, fNameLbl, sNameLbl, ageLbl, cellLbl, degreeLbl;
    JTextField idTxtf, fNameTxtf, sNameTxtf, ageTxtf, cellTxtf;
    JComboBox degreeCB;
    JButton regBtn;
    private final DefaultListCellRenderer listRenderer;
    
    
    static int dID;
    static String dName;
    static String dSurname;
    static int dAge;
    static int dPhone;
    static String dDegree;

    //Constructor.  
    public Q5_Client() {
        //Code.  
        super("Pearson Institute Registration App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(540, 360);

        //JComponents.  
        titleLbl = new JLabel("PIHE Registration App v1.0");
        devLbl = new JLabel("Developer : Heinrich Scheepers 3D8BCMQ24");
        idLbl = new JLabel("ID Number: ");
        fNameLbl = new JLabel("First Name: ");
        sNameLbl = new JLabel("Surname: ");
        ageLbl = new JLabel("Age: ");
        cellLbl = new JLabel("Cell Number: ");
        degreeLbl = new JLabel("Select Degree: ");

        idTxtf = new JTextField();
        fNameTxtf = new JTextField();
        sNameTxtf = new JTextField();
        ageTxtf = new JTextField();
        cellTxtf = new JTextField();

        //JCombobox.  
        String cb[] = {"BSC IT", "BSc Computer Science", "Higher Certificate in IT", "BSC Biomedicine", "Bachelor of Comerce", "Bachelor of Arts"};
        degreeCB = new JComboBox(cb);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        degreeCB.setRenderer(listRenderer);

        regBtn = new JButton("Register");

        //Layout.  
        this.setLayout(new GridLayout(8, 2));

        //Add.  
        this.add(titleLbl);
        this.add(devLbl);
        this.add(idLbl);
        this.add(idTxtf);
        this.add(fNameLbl);
        this.add(fNameTxtf);
        this.add(sNameLbl);
        this.add(sNameTxtf);
        this.add(ageLbl);
        this.add(ageTxtf);
        this.add(cellLbl);
        this.add(cellTxtf);
        this.add(degreeLbl);
        this.add(degreeCB);
        this.add(regBtn);

        this.setVisible(true);
    }
    //Register class ActionListener.  
    class reg implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String idTxt = idLbl.getText();
            dName = fNameLbl.getText();
            dSurname = sNameLbl.getText();
            String ageTxt = ageLbl.getText();
            String cellTxt = cellLbl.getText();
            dDegree = degreeCB.getSelectedItem().toString();
            
            if(idLbl.getText().isEmpty() || fNameLbl.getText().isEmpty() || sNameLbl.getText().isEmpty() || ageLbl.getText().isEmpty() || cellLbl.getText().isEmpty()) {
            
                JOptionPane.showMessageDialog(null, "One or more fields are empty","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                dID = Integer.parseInt(idTxt);
                dAge = Integer.parseInt(ageTxt);
                dPhone = Integer.parseInt(cellTxt);
                Registry r = LocateRegistry.createRegistry(null);
                ConnectionImplement con = new ConnectionImplement();
                ConnectInterface conInt = (ConnectInterface) reg.lookup("insert");
                try{
                    con.insert(dID, dName, dSurname, dAge, dPhone, dDegree);
                } catch (Exception ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Student has been registered sucessfully","Success",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    
    //Main Method that calls GUI.  
    public static void main(String[] args) throws NotBoundException{
        
        Q5_Client cli = new Q5_Client();
    }
}
