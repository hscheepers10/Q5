/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package q5_rmi;

import java.rmi.Remote;

/*
 * @author User
 */

public interface ConnectInterface extends Remote{
    public void insert(int dID,String dName, String dSurname, int dAge,int dCellNumber,String dDegree) 
            throws Exception;
}
