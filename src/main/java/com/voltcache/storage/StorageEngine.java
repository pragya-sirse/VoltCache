package com.voltcache.storage;

import com.voltcache.model.CacheEntry;

public interface StorageEngine {

    void set(String key , CacheEntry value);

    CacheEntry get(String key);

    boolean delete(String  key);

    boolean exists(String key);

    int size();

    String getAllKeys();

    void clear();

}
