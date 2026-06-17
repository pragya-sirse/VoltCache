package com.voltcache.model;

import java.io.Serializable;

public class CacheEntry  implements Serializable {

    private String value;
    private Long expiryTime;

    public CacheEntry(String value){
        this.value=value;
        this.expiryTime=null;
    }
    public CacheEntry(String value,long ttlSeconds){
        this.value=value;
        this.expiryTime=System.currentTimeMillis()+(ttlSeconds*1000);
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value=value;
    }
    public long getExpiryTime(){
        return expiryTime;
    }
    public void setExpiryTime(long expiryTime){
        this.expiryTime=expiryTime;
    }
    public boolean hasExpiry(){
        return expiryTime>0;
    }
    public boolean isExpired(){

        if(expiryTime==null){
            return false;
        }

        return System.currentTimeMillis()
                > expiryTime;
    }

}
