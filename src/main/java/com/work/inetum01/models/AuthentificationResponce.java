
package com.work.inetum01.models;

public class AuthentificationResponce {
    private final String jwt ;

    public AuthentificationResponce(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}

