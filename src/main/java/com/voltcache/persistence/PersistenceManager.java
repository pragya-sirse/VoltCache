package com.voltcache.persistence;

import com.voltcache.model.CacheEntry;

import javax.imageio.IIOException;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class PersistenceManager {

    private static final String FILE_NAME="voltcache.db";
    public void save(
            ConcurrentHashMap<String, CacheEntry> storage) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            outputStream.writeObject(storage);

        } catch (IOException e) {

            System.err.println(
                    "Failed to save database: "
                            + e.getMessage());
        }
    }

    public ConcurrentHashMap<String,CacheEntry> load(){
        File file=new File(FILE_NAME);
        if(!file.exists()){
            return new ConcurrentHashMap<>();
        }
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            return (ConcurrentHashMap<String, CacheEntry>)
                    inputStream.readObject();

        } catch (Exception e) {

            System.err.println(
                    "Failed to load database: "
                            + e.getMessage());

            return new ConcurrentHashMap<>();
        }
    }
}
