package org.anderes.edu.jee.cdi.sample;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloWorldResource {

    @Inject
    private GreetingService service;
    
	@GET
	@Produces(TEXT_PLAIN)
	public String getClichedMessage() {
		return service.sayHello();
	}
}
