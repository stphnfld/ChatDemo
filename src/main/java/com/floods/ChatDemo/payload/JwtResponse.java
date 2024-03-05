package com.floods.ChatDemo.payload;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    // Include other fields as needed, for example:
    // private String username;
    // private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token) {
        this.token = token;
    }

    // If additional fields are required, create a constructor that accepts those values too.

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter methods for other fields
    
}
