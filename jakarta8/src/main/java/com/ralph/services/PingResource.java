package com.ralph.services;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author rsoika
 */
@Path("ping")
public class PingResource {
	private static Logger logger = Logger.getLogger(PingResource.class.getName());

	@Inject
	@ConfigProperty(name = "mail.host", defaultValue = "xxxx")
	private String mail_host;
	

	
	@GET
	public String ping() {
		logger.info("...ping.... env mail.host=" + mail_host );
		return "Ping Jakarta8 " + System.currentTimeMillis();
	}

}
