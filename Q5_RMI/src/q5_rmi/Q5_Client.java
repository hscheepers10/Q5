/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5_rmi;

import java.awt.GridLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
}
