package com.fsse2401.Project.data.user.domain;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class FirebaseUserData {
    private String firebasedUid;
    private String email;

    public FirebaseUserData(JwtAuthenticationToken jwtToken) {
        this.firebasedUid = (String) jwtToken.getTokenAttributes().get("user_id");
        this.email = (String) jwtToken.getTokenAttributes().get("email");
    }

    public String getFirebasedUid() {
        return firebasedUid;
    }

    public void setFirebasedUid(String firebasedUid) {
        this.firebasedUid = firebasedUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
