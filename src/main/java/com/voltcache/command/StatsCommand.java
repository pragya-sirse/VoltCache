package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class StatsCommand implements  Command{

    private final StorageEngine storage;

    public StatsCommand(StorageEngine storage){
        this.storage=storage;
    }

    @Override
    public Response execute(){
        return new Response(true,"Total Keys: " +storage.size());
    }
}
