/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import controller.IToyImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import controller.IToy;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Aspire E5-576
 */
public class ServerUDP {

         public static void main(String []args) throws IOException
    {

        DatagramSocket serverSocket = new DatagramSocket(1024);
        System.out.println("Server is now already");
        byte inFromClient1[];
        inFromClient1 = new byte[256];
        byte inFromClient2[];
        inFromClient2 = new byte[256];
        int leng1 = inFromClient1.length;
        int leng2 = inFromClient2.length;
        DatagramPacket fromClient1 = new DatagramPacket(inFromClient1, leng1);
        DatagramPacket fromClient2 = new DatagramPacket(inFromClient2, leng2);
        serverSocket.receive(fromClient1);
        serverSocket.receive(fromClient2);
        String data1,data2;
        data1 = (new String(fromClient1.getData(),0,inFromClient1.length)).trim();
        data2 = (new String(fromClient2.getData(),0,inFromClient2.length)).trim();
        int a,b,tong;
        a = Integer.parseInt(data1);
        b = Integer.parseInt(data2);
        tong = a + b;
        data1 = String.valueOf(tong);
        byte outToClient[];
        outToClient = data1.getBytes();
        leng1 = outToClient.length;
        InetAddress address = fromClient1.getAddress();
        int port = fromClient1.getPort();
        DatagramPacket toClient = new DatagramPacket(outToClient, leng1, address, port);
        serverSocket.send(toClient);
        serverSocket.close();
    }
    }
