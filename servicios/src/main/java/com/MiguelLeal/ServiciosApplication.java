package com.MiguelLeal;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.MiguelLeal.principal.DatabaseConnection;
import com.MiguelLeal.servicios.SOAPImplementacion;

import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class ServiciosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ServiciosApplication.class, args);
		
		System.out.println("Iniciando el servicio");
		String address="http://0.0.0.0:8081/";
		SOAPImplementacion soapService = context.getBean(SOAPImplementacion.class);
		Endpoint.publish(address, soapService);
		System.out.println("Servicio iniciado");
		
		DatabaseConnection.main(args);
	}
}




