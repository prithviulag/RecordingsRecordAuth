package com.hxmalar.resrdauth;

import javax.ws.rs.core.Response;

//Functional interface allowing use of AccessProcessor.gatewayAccess for GET, POST, DELETE, PUT, etc.
@FunctionalInterface
public interface IDatabaseBridge {
    Response accessDatabase(String input);
}
