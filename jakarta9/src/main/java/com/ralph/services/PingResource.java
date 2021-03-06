package com.ralph.services;

import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author rsoika
 */
@Path("ping")
public class PingResource {
	private static Logger logger = Logger.getLogger(PingResource.class.getName());

	@Inject
	@ConfigProperty(name = "mail.host", defaultValue = "host@mail.com")
	private String mail_host;

	@GET
	public String ping() {
		logger.info("...ping.... env mail.host=" + mail_host);

		return "Ping JakartaEE 9 " + System.currentTimeMillis();
	}

}
