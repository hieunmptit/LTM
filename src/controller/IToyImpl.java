/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ToyDAO;
import dao.ToyDAOImpl;
import java.rmi.RemoteException;
import java.util.List;
import model.Toy;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Aspire E5-576
 */
public class IToyImpl extends UnicastRemoteObject  implements IToy{
        ToyDAO toyDAO= new ToyDAOImpl();

    public IToyImpl() throws RemoteException{
    }
        
    @Override
    public boolean themToy(Toy toy) throws RemoteException {
        return toyDAO.themToy(toy);
    }

    @Override
    public boolean editToy(Toy toy) throws RemoteException {
     return toyDAO.editToy(toy);
    }

    @Override
    public boolean deleteToy(int id) throws RemoteException {
        return toyDAO.deleteToy(id);
    }

    @Override
    public Toy getToyByID(int id) throws RemoteException {
     return toyDAO.getToyByID(id);
    }

    @Override
    public List<Toy> getAll() throws RemoteException {
      return toyDAO.getAll();
    }
    
}
