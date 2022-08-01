package com.hxmalar.resrdauth;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;

public class AccessProcessor {
    protected static Response gatewayAccess(String authorization, IDatabaseBridge databaseBridge) {
        if (authorization == null) {
            return Response.status(401).entity("No authorization provided.").type(MediaType.TEXT_PLAIN).build();
        }
        String[] authComponents = authorization.split("\\s", 2);
        if (authComponents.length == 2 && authComponents[0].equals("Basic")) {
            String credentials = new String(Base64.getDecoder().decode(authComponents[1]));
            String[] credComponents = credentials.split(":", 2);
            if (credComponents.length == 2) {
                return databaseBridge.accessDatabase(credComponents[0]);
            }
            else {
                return Response.status(401).build();
            }
        } else {
            return Response.status(401).entity("Invalid authorization provided.").type(MediaType.TEXT_PLAIN).build();
        }
    }
}
