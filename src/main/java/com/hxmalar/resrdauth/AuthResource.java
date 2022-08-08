package com.hxmalar.resrdauth;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/main")
public class AuthResource {
    @GET
    @Path("/verify/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verify(@HeaderParam("Authorization") String authorization, @PathParam("username") String username) {
        String verifyMessage = "Received username for verification: " + username + ". Requested by: " + authorization + ".";
        System.out.println(verifyMessage);
        IDatabaseBridge getUserInfo = (in) -> DatabaseQuerier.getUserInfo(in);
        return AccessProcessor.gatewayAccess(authorization, getUserInfo, username);
        //eventually connect to SQLite Database and return data
    }

    /* HAS SAME RESULT AS ABOVE, BUT DOESN'T USE RESPONSE OBJ (Which works for any data type)
    @GET
    @Path("/verify/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String verify(@PathParam("username") String username) {
        String verifyMessage = "Received username for verification: " + username;
        return verifyMessage;
    }
     */
}
