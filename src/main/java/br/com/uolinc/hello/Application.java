package br.com.uolinc.hello;

import static reactor.event.selector.Selectors.$;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import br.com.uolinc.receivers.Receiver;

@Configuration
@EnableAutoConfiguration
@ComponentScan("br.com.uolinc")
public class Application extends SpringBootServletInitializer {

	@Autowired
	private Reactor reactor;
	
	@Autowired
	private Receiver receiver;

	@Bean
	Environment env() {
		return new Environment();
	}

	@Bean
	public Reactor reactor(Environment env) {
		Reactor reactor = Reactors.reactor(env, Environment.THREAD_POOL);
		return reactor;
	}
	
	@PostConstruct
	public void ear() {
		reactor.on($("fire"), receiver);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}

}