package com.voltcache.server;

import com.voltcache.command.CommandFactory;
import com.voltcache.command.CommandParser;
import com.voltcache.storage.StorageEngine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class VoltCacheServer {

    private static final int PORT =6379;

    private final ExecutorService executorService;

    private  final CommandParser parser;

    private final CommandFactory factory;

    public VoltCacheServer(StorageEngine storage){
        this.executorService= Executors.newFixedThreadPool(10);

        this.parser=new CommandParser();

        this.factory=new CommandFactory(storage);

    }
    public void start(){
        try(ServerSocket serverSocket= new ServerSocket(PORT)){
            System.out.println("VoltCache running on port " +PORT);
            while (true){
                Socket clientSocket=serverSocket.accept();
                System.out.println("Client connceted:" +clientSocket.getInetAddress());
                executorService.submit(new ClientHandler(clientSocket,parser,factory));
            }
        }
        catch (IOException e){
            throw new RuntimeException("Server failed to start",e);
        }


    }


}
