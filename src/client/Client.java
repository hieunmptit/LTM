/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Toy;
import controller.IToy;

/**
 *
 * @author Aspire E5-576
 */
public class Client {

    public static void main(String[] args) {
        try {
            IToy toyRMI = (IToy) java.rmi.Naming.lookup("rmi://127.0.0.1:7777/toy");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1:Thêm đồ chơi ");
                System.out.println("2:Sửa đồ chơi");
                System.out.println("3:Xóa đồ chơi");
                System.out.println("4:Xem thông tin đồ chơi");
                System.out.println("5:Xem thông tin tất cả tđồ chơi");
                System.out.println("0:Thoát");
                int x = Integer.parseInt(scanner.nextLine());
                if (x == 0) {
                    break;
                }
                switch (x) {
                    case 1:
                        System.out.println("Nhập Tên đồ chơi: ");
                        String name = scanner.nextLine();
                        System.out.println("Nhập Thể loại: ");
                        String category = scanner.nextLine();
                        System.out.println("Nhập Số lượng: ");
                        String amount1=scanner.nextLine();
                        int amount = Integer.parseInt(amount1);
                    
                        Toy toy = new Toy(name, category, amount);
                        if (toyRMI.themToy(toy) == true) {
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("Thêm thất bại");
                        }
                        break;
                    case 2:
                         System.out.println("Nhập ID đồ chơi : ");
                        int idTaiKhoan = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập tên cần sửa: ");
                        String editUsername = scanner.nextLine();
                        System.out.println("Nhập thể loại cần sửa: ");
                        String editPassword = scanner.nextLine();
                        System.out.println("Nhập số lượng cần sửa:");
                        String role2=scanner.nextLine();
                        int editRole = Integer.parseInt(role2);
                        Toy editDC = new Toy(idTaiKhoan,editUsername, editPassword, editRole);
                        if (toyRMI.editToy(editDC) == true) {
                            System.out.println("Sửa thành công");
                        } else {
                            System.out.println("Sửa thất bại");
                        }
                        break;
                    case 3:
                        System.out.println("Nhập ID đồ chơi cần xóa:");
                        int id = Integer.parseInt(scanner.nextLine());
                        if (toyRMI.deleteToy(id)) {
                            System.out.println("Xoa thành công");
                        } else {
                            System.out.println("Xoa that bai");
                        }
                        break;
                    case 4:
                        System.out.println("Nhập ID đồ chơi cần xem:");
                        int idDC = Integer.parseInt(scanner.nextLine());
                        try {
                            Toy taiKhoan = toyRMI.getToyByID(idDC);
                            System.out.println("ID: " + taiKhoan.getId());
                            System.out.println("Tên đồ chơi: " + taiKhoan.getName());
                            System.out.println("Thể loại: " + taiKhoan.getCategory());
                            System.out.println("Số lượng: " + taiKhoan.getAmount());
                        } catch (Exception e) {
                            System.out.println("Thực hiện lấy thông tin thất bại");
                        }
                        break;
                    case 5:
                    try {
                        List<Toy> listToy = toyRMI.getAll();
                        for (Toy toy1 : listToy) {
                            System.out.println("ID : " + toy1.getId());
                            System.out.println("Tên đồ chơi: " + toy1.getName());
                            System.out.println("Thể loại: " + toy1.getCategory());
                            System.out.println("Số lượng: " + toy1.getAmount());
                        }
                    } catch (Exception e) {
                          System.out.println("Thực hiện lấy thông tin tất cả đồ chơi thất bại");
                    }
                    break;

                }
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
