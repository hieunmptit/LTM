/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static JDBConnection.JDBConection.getConnection;
import com.mysql.cj.jdbc.DatabaseMetaData;
import java.util.List;
import model.Toy;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aspire E5-576
 */
public class ToyDAOImpl extends JDBConnection.JDBConection implements ToyDAO{

    @Override
    public boolean themToy(Toy toy) {
               String addToy="INSERT INTO qltaikhoan.toys (name,category,amount) VALUES (?,?,?)";
            PreparedStatement preparedStatement;
        try {
            preparedStatement = getConnection().prepareStatement(addToy);
             preparedStatement.setString(1, toy.getName());
              preparedStatement.setString(2, toy.getCategory());
                preparedStatement.setInt(3, toy.getAmount());
                if(preparedStatement.executeUpdate()==1)
                {
                    return true;
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(ToyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           return false;
    }

    @Override
    public boolean editToy(Toy toy) {
           String updateSQL="UPDATE qltaikhoan.toys SET name = ?, category = ?, amount = ? WHERE id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getConnection().prepareStatement(updateSQL);
             preparedStatement.setString(1, toy.getName());
             preparedStatement.setString(2, toy.getCategory());
             preparedStatement.setInt(3, toy.getAmount());
             preparedStatement.setInt(4, toy.getId());
             if(preparedStatement.executeUpdate()==1)
             {
                 return true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ToyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
    }

    @Override
    public boolean deleteToy(int id) {
             String delete="DELETE FROM qltaikhoan.toys WHERE id="+id+"";
        try {
            Statement statement= getConnection().createStatement();
            if(statement.executeUpdate(delete)==1)
            {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Toy getToyByID(int id) {
        String getTKByID="Select * FROM qltaikhoan.toys where id="+id+"";
       Statement statement;
        try {
            statement = getConnection().createStatement();
             ResultSet resultSet= statement.executeQuery(getTKByID);
            // System.out.println(resultSet.getString("Username"));
 
             while(resultSet.next())
             {
                 if(resultSet.getInt("id")==id)
                 {  
                     
                     return new Toy(id,resultSet.getString("name"), resultSet.getString("category"),resultSet.getInt("amount"));
                 }
             }
        } catch (SQLException ex) {
            Logger.getLogger(ToyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Toy> getAll() {
           String getAllToy="Select * FROM qltaikhoan.toys";
        List<Toy> toyList= new ArrayList<>();
       Statement statement;
        try {
            statement = getConnection().createStatement();
             ResultSet resultSet= statement.executeQuery(getAllToy);
             while(resultSet.next())
             {
                     toyList.add(new Toy(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("category"),resultSet.getInt("amount")));
             }
        } catch (SQLException ex) {
            Logger.getLogger(ToyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toyList;
    }
    
}
