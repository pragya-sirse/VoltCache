package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class InfoCommand implements Command{

    private final StorageEngine storage;

    public InfoCommand(StorageEngine storage) {
        this.storage = storage;
    }

    @Override
    public Response execute() {

        String info =
                "VoltCache Version : 1.0\n" +
                        "Total Keys : " + storage.size();

        return new Response(
                true,
                info
        );
    }
}
