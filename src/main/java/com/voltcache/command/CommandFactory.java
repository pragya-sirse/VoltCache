package com.voltcache.command;

import com.voltcache.model.CommandRequest;
import com.voltcache.storage.StorageEngine;

import java.util.Locale;

public class CommandFactory {

    private final StorageEngine storage;

    public CommandFactory(StorageEngine storage) {
        this.storage = storage;
    }

    public Command createCommand(CommandRequest request) {

        String command = request.getCommandName().toUpperCase();

        String[] args = request.getArguments();

        switch (command) {
            case "SET":
                return new SetCommand(storage, args[0], args[1]);

            case "GET":
                return new GetCommand(storage, args[0]);

            case "DEL":
                return new DelCommand(storage, args[0]);

            case "STATS":
                return new StatsCommand(storage);

            case "SETEX":
                return new SetExCommand(
                        storage,
                        args[0],
                        args[2],
                        Long.parseLong(args[1])
                );

            case "KEYS":
                return new KeysCommand(storage);

            case "FLUSH":
                return new FlushCommand(storage);

            case "INFO":
                return new InfoCommand(storage);

            case "PING":
                return new PingCommand();

            case "EXISTS":
                return new ExistsCommand(
                        storage,
                        args[0]
                );

            case "HELP":
                return new HelpCommand();

            default:
                throw new IllegalArgumentException("Unknown command :" + command);
        }

    }
}
