package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class FlushCommand implements Command{

    private final StorageEngine storage;

    public FlushCommand(StorageEngine storage) {
        this.storage = storage;
    }

    @Override
    public Response execute() {

        storage.clear();

        return new Response(
                true,
                "Database Cleared"
        );
    }
}
