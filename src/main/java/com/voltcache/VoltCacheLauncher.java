package com.voltcache;

import com.voltcache.command.Command;
import com.voltcache.command.CommandFactory;
import com.voltcache.command.CommandParser;
import com.voltcache.model.CommandRequest;
import com.voltcache.server.VoltCacheServer;
import com.voltcache.storage.InMemoryStorage;
import com.voltcache.storage.StorageEngine;
import com.voltcache.ttl.ExpirationScheduler;

public class VoltCacheLauncher {


    public static void main(String[] args) {

        InMemoryStorage storage = new InMemoryStorage();

        ExpirationScheduler scheduler = new ExpirationScheduler(storage);

        scheduler.start();

        VoltCacheServer server = new VoltCacheServer(storage);

        server.start();

    }

}
