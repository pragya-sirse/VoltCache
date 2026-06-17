package com.voltcache.command;

import com.voltcache.model.CacheEntry;
import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class GetCommand implements Command{

    private final StorageEngine storage;

    private final String key;

    public GetCommand(StorageEngine storage,String  key){
        this.storage=storage;
        this.key=key;
    }
    @Override
    public Response execute(){
        CacheEntry entry=storage.get(key);
        if(entry==null){
            return new Response(false,"Key not found");
        }
        return new Response(true, entry.getValue());
    }
}
