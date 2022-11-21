/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.rmi.Remote;
import java.util.List;
import java.rmi.RemoteException;
import model.Toy;
/**
 *
 * @author Aspire E5-576
 */
public interface IToy extends Remote {
    public boolean themToy(Toy toy) throws RemoteException;
    public boolean editToy(Toy toy) throws RemoteException;
    public boolean deleteToy(int idTK) throws RemoteException;
    public Toy getToyByID(int idTK) throws RemoteException;
    public List<Toy> getAll() throws RemoteException;
}
