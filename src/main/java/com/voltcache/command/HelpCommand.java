package com.voltcache.command;

import com.voltcache.model.Response;

public class HelpCommand implements Command{

    @Override
    public Response execute() {

        String help =
                "Commands: SET, GET, DEL, EXISTS, SETEX, KEYS, STATS, INFO, FLUSH, PING, HELP, EXIT";

        return new Response(
                true,
                help
        );
    }
}
