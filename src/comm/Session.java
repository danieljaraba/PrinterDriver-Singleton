package comm;

import model.OnMessageListener;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Session extends Thread{

    private Socket socket;

    private BufferedReader reader;
    private BufferedWriter writer;
    private OnMessageListener listener;

    public Session(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = reader.readLine();
            listener.onMessage(line);

            while(line != "") {
                line = reader.readLine();
                listener.onMessage(line);
            }

        } catch (IOException ex) {
            if(ex.getMessage().equals("Connection reset")){
                System.out.println("Se desconectó un cliente");
            }else{
                ex.printStackTrace();
            }
        }
    }

    public void setListener(OnMessageListener listener){
        this.listener = listener;
    }
}
