package com.voltcache.ttl;

import com.voltcache.model.CacheEntry;
import com.voltcache.storage.InMemoryStorage;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExpirationScheduler {
    private final InMemoryStorage storage;

    private final ScheduledExecutorService scheduler;

    public ExpirationScheduler(
            InMemoryStorage storage) {

        this.storage = storage;

        this.scheduler =
                Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {

        scheduler.scheduleAtFixedRate(

                this::cleanup,

                5,

                5,

                TimeUnit.SECONDS
        );
    }

    private void cleanup() {

        ConcurrentHashMap<String, CacheEntry> map =
                storage.getStorage();

        Iterator<Map.Entry<String, CacheEntry>>
                iterator =
                map.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, CacheEntry> entry =
                    iterator.next();

            if (entry.getValue().isExpired()) {

                map.remove(entry.getKey());

                System.out.println(
                        "Expired key removed: "
                                + entry.getKey()
                );
            }
        }
    }
}
