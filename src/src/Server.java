package src;

import java.io.*;
import java.net.*;


public class Server {

    public static void main(String[] args) throws IOException {
        float num1, num2;
        char operazione;
        Operazioni operazioni;


        ServerSocket server = new ServerSocket(1235);


        while(true) {
            Socket client = server.accept();

            BufferedReader input =
                    new BufferedReader(new
                            InputStreamReader(client.getInputStream()));

            DataOutputStream output =
                    new DataOutputStream(client.getOutputStream());

            String[] nums = input.readLine().split(" ");
            num1 = Float.parseFloat(nums[0]);
            num2 = Float.parseFloat(nums[2]);
            operazione = nums[1].charAt(0);
            operazioni = new Operazioni(num1, num2);

            switch(operazione) {
                case '+' : {
                    output.writeBytes(String.valueOf(operazioni.addizione()) + "\n");
                    break;
                }
                case '-' : {
                    output.writeBytes(String.valueOf(operazioni.sottrazione()) + "\n");
                    break;
                }
                case '/' : {
                    output.writeBytes(String.valueOf(operazioni.divisione()) + "\n");
                    break;
                }
                case '*' : {
                    output.writeBytes(String.valueOf(operazioni.moltiplicazione()) + "\n");
                    break;
                }
                default : {
                    output.writeBytes("Errore" + "\n");
                    break;
                }
            }




        }

    }
}