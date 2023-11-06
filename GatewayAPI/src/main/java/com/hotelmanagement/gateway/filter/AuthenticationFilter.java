package com.hotelmanagement.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.gateway.util.JwtUtill;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private JwtUtill jwtUtill;

	@Autowired
	private RestTemplate restTemplate;

	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}

	public static class Config {

	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange, chain) -> {
			if (validator.isSecured.test(exchange.getRequest())) {
//				header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing authorization header");
				}
			
			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
                System.out.println(authHeader);
				authHeader = authHeader.substring(7);
				
			}
			
			try {
				// Rest call to AUTH service
				System.out.println("test or validate token");
//				restTemplate.getForObject("http://Jwt-Authentication/validate?token"+authHeader,boolean.class);
				 System.out.println(authHeader);
					
				jwtUtill.validateToken(authHeader);

			} catch (Exception e) {
				System.out.println("invalid access");
				throw new RuntimeException("unauthorize access");
			}
			}
			return chain.filter(exchange);
		});
	}

}
