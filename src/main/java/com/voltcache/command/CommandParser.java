package com.voltcache.command;

import com.voltcache.model.CommandRequest;

public class CommandParser {
    public CommandRequest parse(String input){

        String [] tokens=input.trim().split("\\s+");

        String commandName=tokens[0];

        String[] arguments=new String[tokens.length-1];

        System.arraycopy(tokens,1,arguments,0,arguments.length);

        return new CommandRequest(commandName,arguments);

    }

}
