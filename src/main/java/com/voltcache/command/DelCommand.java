package com.voltcache.command;

import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class DelCommand implements Command{

    private final String key;
    private final StorageEngine storage;

    public DelCommand(StorageEngine storage,String key){
        this.key=key;
        this.storage=storage;
    }
    @Override
    public Response execute(){
        boolean deleted=storage.delete(key);
        if(deleted){
            return new Response(true,"Deleted");
        }
        return new Response(false,"Key not found");
    }
}
