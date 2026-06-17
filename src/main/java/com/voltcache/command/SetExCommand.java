package com.voltcache.command;

import com.voltcache.model.CacheEntry;
import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class SetExCommand implements Command{
    private final StorageEngine storage;

    private final String key;

    private final String value;

    private final long ttlSeconds;

    public SetExCommand(
            StorageEngine storage,
            String key,
            String value,
            long ttlSeconds) {

        this.storage = storage;
        this.key = key;
        this.value = value;
        this.ttlSeconds = ttlSeconds;
    }

    @Override
    public Response execute() {
        storage.set(
                key,
                new CacheEntry(
                        value,
                        ttlSeconds
                )
        );

        return new Response(
                true,
                "OK"
        );

    }
}
