package desafio.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import desafio.boot.config.DesafioConfig;

@SpringBootApplication
@Import(DesafioConfig.class)
public class DesafioApp extends SpringBootServletInitializer{
	
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	SpringApplication.run(DesafioApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(DesafioApp.class);
	}
}
