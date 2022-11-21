/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.rmi.RemoteException;
import java.util.List;
import model.Toy;

/**
 *
 * @author Aspire E5-576
 */
public interface ToyDAO {
    public boolean themToy(Toy toy);
    public boolean editToy(Toy toy);
    public boolean deleteToy(int id);
    public Toy getToyByID(int id);
    public List<Toy> getAll();
}
