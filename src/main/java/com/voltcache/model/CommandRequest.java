package com.voltcache.model;

public class CommandRequest {

    private String commandName;

    private String[] arguments;

    public CommandRequest(String commandName,String[] arguments){
        this.commandName=commandName;
        this.arguments=arguments;
    }
    public String getCommandName(){
        return commandName;
    }

    public String[] getArguments(){
        return arguments;
    }
}
