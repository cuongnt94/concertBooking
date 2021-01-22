package com.example.concertbooking.security.util;

import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

public class JwtUtil {

    public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) return null;
        System.out.println(Jwts.parser().setSigningKey(signingKey));
        System.out.println(Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token));
        System.out.println(Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody());

        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    }
}
