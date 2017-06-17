package com.szychan.gitinformer;

import java.io.FileNotFoundException;

import javax.json.JsonArray;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;

/**
 * The Main Application Class.
 */
public class GitInformer {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String userName = "";

		if (args.length > 1) {
			System.out.println("Wrong number of parameters.");
			System.out.println("Application takes 0 or 1 parameter");
			System.exit(0);
		}

		if (args.length == 0) {
			System.out.print("Enter GitHub user name :");
			userName = System.console().readLine();
		} else {
			userName = args[0];
		}

		JsonArray jsonArray = getUserRepositories(userName);
		try {
			MyPdfWriter.WriteUserRepositoriesToPdf(userName, jsonArray);
		} catch (FileNotFoundException e) {
			System.out.println("Error while trying to write pdf.");
			System.exit(0);
		}

		System.out.println("Pdf generated \nClosing...");
	}

	/**
	 * Gets the user repositories.
	 *
	 * @param userName
	 *            the user name
	 * @return the user repositories
	 */
	public static JsonArray getUserRepositories(String userName) {
		System.out.println("Getting user data");

		JsonArray jsonArray = null;
		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.register(JsonProcessingFeature.class).target("https://api.github.com")
					.path("users/" + userName + "/repos").queryParam("sort", "updated");

			jsonArray = target.request(MediaType.APPLICATION_JSON_TYPE).get(JsonArray.class);
		} catch (NotFoundException e) {

			System.out.println("There is no GitHub account with that user name");
			System.exit(0);
		}
		return jsonArray;
	}
}
