package com.java.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class Application_ZipkinServer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application_ZipkinServer.class, args);
	}

}
