package com.hxmalar.resrdauth;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DatabaseQuerier {
    public static Response getUserInfo(String username) {
        return Response.ok().entity("Successfully accessed database to verify login for user " + username + ".").type(MediaType.TEXT_PLAIN).build();
    }
}
