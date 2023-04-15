package ui;

import model.OnMessageListener;

import java.io.IOException;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.net.Socket;

import comm.Session;
import model.PrinterDriver;

public class Server implements OnMessageListener {

    public static void main(String[] args) throws IOException {
        new Server();
    }

    private ArrayList<Session> sessions;

    public Server() throws IOException {
        sessions = new ArrayList<>();
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            System.out.println("Esperando cliente...");
            Socket socket = server.accept();
            System.out.println("Nuevo cliente conectado!");
            System.out.println("Entró en el puerto: " + socket.getPort());
            Session session = new Session(socket);
            session.setListener(this);
            session.start();
            sessions.add(session);
        }
    }

    @Override
    public void onMessage(String line) {
        PrinterDriver.getInstance().printFile(line);
    }

}
