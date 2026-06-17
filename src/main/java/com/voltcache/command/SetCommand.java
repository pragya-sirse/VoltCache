package com.voltcache.command;

import com.voltcache.model.CacheEntry;
import com.voltcache.model.Response;
import com.voltcache.storage.StorageEngine;

public class SetCommand implements Command{

    private final StorageEngine storage;

    private final String key;

    private final String value;

    public SetCommand( StorageEngine storage,String  key,String value){
        this.storage=storage;
        this.key=key;
        this.value=value;
    }

    @Override
    public Response execute(){
        storage.set(key,new CacheEntry(value));
        return new Response(true,"OK");
    }

}
