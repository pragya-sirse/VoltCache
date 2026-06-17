package com.voltcache.storage;

import com.voltcache.model.CacheEntry;
import com.voltcache.persistence.PersistenceManager;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage implements StorageEngine{

    private final ConcurrentHashMap<String , CacheEntry> storage;

    private final PersistenceManager persistenceManager;

    public InMemoryStorage() {

        this.persistenceManager =
                new PersistenceManager();

        this.storage =
                persistenceManager.load();
    }
    @Override
    public void set(String key, CacheEntry value) {

        storage.put(key, value);

        persistenceManager.save(storage);
    }

    @Override
    public CacheEntry get(String key){

        CacheEntry entry = storage.get(key);

        if(entry == null){
            return null;
        }

        if(entry.isExpired()){

            storage.remove(key);

            persistenceManager.save(storage);

            return null;
        }

        return entry;
    }

    @Override
    public boolean delete(String key) {

        boolean deleted =
                storage.remove(key) != null;

        persistenceManager.save(storage);

        return deleted;
    }

    @Override
    public boolean exists(String key){
        return storage.containsKey(key);
    }
    @Override
    public int size(){
        return storage.size();
    }
    public ConcurrentHashMap<String, CacheEntry> getStorage() {

        return storage;
    }
    @Override
    public String getAllKeys() {
        return storage.keySet().toString();
    }
    @Override
    public void clear() {

        storage.clear();

        persistenceManager.save(storage);
    }
}
