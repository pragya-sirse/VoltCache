package com.voltcache.command;

import com.voltcache.model.Response;

public class PingCommand implements Command{

    @Override
    public Response execute() {
        return new Response(
                true,
                "PONG"
        );
    }
}
