package com.voltcache.command;

import com.voltcache.model.Response;

public interface Command {
    Response execute();
}
