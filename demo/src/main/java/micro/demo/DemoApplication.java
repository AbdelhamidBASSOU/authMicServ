package micro.demo;


import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public JwtParser jwtParser() {
//		return Jwts.parser().setSigningKey("monSecret926600".getBytes());
//	}
//
//	@Bean
//	public JwtAuthFilter jwtFilter(JwtParser jwtParser) {
//		return new JwtAuthFilter(jwtParser);
//	}
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("wallet-service", r -> r.path("/api/wallet")
//						.filters(f -> f.filter(jwtFilter(jwtParser())))
//						.uri("http://localhost:3030"))
//				.route("Transaction-service", r -> r.path("/api/transaction")
//						.filters(f -> f.filter(jwtFilter(jwtParser())))
//						.uri("http://localhost:8081"))
//				.build();
//	}

}
