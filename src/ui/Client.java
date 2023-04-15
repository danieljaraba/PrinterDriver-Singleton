package ui;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",6000);
            System.out.println("Conectado");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            Scanner sc = new Scanner(System.in);

            while(true){
                String line = sc.nextLine();
                bw.write(line+"\n");
                bw.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
