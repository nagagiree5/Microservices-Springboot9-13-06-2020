package io.springboot.cloud.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class NetflixZipkinServerTraceReqApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZipkinServerTraceReqApplication.class, args);
	}

}
