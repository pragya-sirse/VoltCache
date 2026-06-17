package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class KeysCommand implements Command{
    private final StorageEngine storage;

    public KeysCommand(StorageEngine storage) {
        this.storage = storage;
    }

    @Override
    public Response execute() {

        return new Response(
                true,
                storage.getAllKeys()
        );
    }

}
