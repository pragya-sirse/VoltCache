package com.voltcache.server;

import com.voltcache.command.Command;
import com.voltcache.command.CommandFactory;
import com.voltcache.command.CommandParser;
import com.voltcache.model.CommandRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements  Runnable{
    private  final Socket clientSocket;
    private final CommandParser parser;
    private final CommandFactory factory;

    public ClientHandler(Socket clientSocket ,CommandParser parser,CommandFactory factory){

        this.clientSocket=clientSocket;
        this.parser=parser;
        this.factory=factory;
    }
    @Override
    public void run(){

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        clientSocket.getInputStream()));

                PrintWriter writer =
                        new PrintWriter(
                                clientSocket.getOutputStream(),
                                true)
        ) {

            writer.println("Welcome to VoltCache!");

            String input;

            while ((input = reader.readLine()) != null) {

                if (input.equalsIgnoreCase("EXIT")) {
                    writer.println("Goodbye!");
                    break;
                }
                try {
                    CommandRequest request = parser.parse(input);
                    Command command = factory.createCommand(request);
                    writer.println(command.execute());
                } catch (Exception e) {
                    writer.println("ERROR:" + e.getMessage());
                }
            }
        }
        catch (IOException e){
            System.err.println("Client error: "+e.getMessage());
        }
        finally {
            try {
                clientSocket.close();
            }
            catch (IOException ignored){

            }
        }
    }


}
