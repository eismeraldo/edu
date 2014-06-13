package org.anderes.edu.jee.rest.sample;

import static javax.ws.rs.core.MediaType.TEXT_HTML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class HelloWorldResource {

	@PUT
	@Consumes(TEXT_PLAIN)
	public void putMessage(String message) {
		// Store the message
	}

	@GET
	@Produces(TEXT_HTML)
	public String getClichedMessageHtml() {
		return "Hello World";
	}

	@GET
	@Produces(TEXT_PLAIN)
	public String getClichedMessage() {
		return "Hello World";
	}
}
