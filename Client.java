import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket socket = new Socket("localhost",8888);
        InetAddress name = InetAddress.getLocalHost();

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReaderFromCMD = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReaderFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        printWriter.println(name);
        while(true) {
            String readerInput = bufferedReaderFromCMD.readLine();


            printWriter.println(readerInput);
            if (readerInput.equals("Q")) {
                break;
            }

            if(bufferedReaderFromServer.ready()){
                String newLine = bufferedReaderFromServer.readLine();
                System.out.println(newLine);
            }





        }
        socket.close();


        //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }



}
