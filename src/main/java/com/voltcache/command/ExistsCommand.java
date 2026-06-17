package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class ExistsCommand implements Command{

    private final StorageEngine storage;

    private final String key;

    public ExistsCommand(
            StorageEngine storage,
            String key) {

        this.storage = storage;
        this.key = key;
    }

    @Override
    public Response execute() {

        boolean exists =
                storage.exists(key);

        return new Response(
                true,
                String.valueOf(exists)
        );
    }
}
