package com.hotelmanagement.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;


//methods-for generating token
//validate
//isExpired
//util class for jwt

@Component
public class JwtUtill {

	private String SECRET_KEY = "secret";

//    hey
	public boolean validateToken(String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//		parse(token);
		return true;
	}
	
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

//      final String username = extractUsername(token);
//      return (username.equals(userName) && !isTokenExpired(token));
//	public Jws<Claims> parse(String token) {
//		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//	}

}
