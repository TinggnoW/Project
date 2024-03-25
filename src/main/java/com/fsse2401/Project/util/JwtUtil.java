package com.fsse2401.Project.util;

import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {
    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwtToken){
        return new FirebaseUserData(jwtToken);
    }
}
