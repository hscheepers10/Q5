/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5_rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author User
 */
public class Q5_Server extends ConnectionImplement{

    public Q5_Server() throws RemoteException{
        super();
    }
    
    //Main
    public static void main(String[] srgs) throws RemoteException, AlreadyBoundException{
        try{
            ConnectionImplement con = new ConnectionImplement();
            ConnectInterface conInt = (ConnectInterface) UnicastRemoteObject.exportObject(con,0);
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("insert", conInt);
            System.err.println("Server ready");
        }
        catch(AlreadyBoundException | RemoteException ex){     
        }
    }
}
