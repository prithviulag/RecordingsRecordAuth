package com.hxmalar.resrdauth;

import javax.ws.rs.core.Response;

//Functional interface allowing use of AccessProcessor.gatewayAccess for GET, POST, DELETE, PUT, etc.
public interface DatabaseBridge {
    Response accessDatabase(String input);
}
