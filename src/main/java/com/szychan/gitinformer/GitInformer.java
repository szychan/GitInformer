package com.szychan.gitinformer;

import java.io.FileNotFoundException;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jsonp.JsonProcessingFeature;

public class GitInformer {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.exit(0);
		}

		JsonArray jsonArray = getUserRepositories(args[0]);
		// System.out.println(jsonArray.toString());

		try {
			MyPdfWriter.WriteUserRepositoriesToPdf(args[0], jsonArray);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JsonArray getUserRepositories(String userName) {
		JsonArray jsonArray = null;

		Client client = ClientBuilder.newClient();
		WebTarget target = client.register(JsonProcessingFeature.class).target("https://api.github.com")
				.path("users/" + userName + "/repos").queryParam("sort", "updated");
		System.out.println(target.getUri());

		jsonArray = target.request(MediaType.APPLICATION_JSON_TYPE).get(JsonArray.class);

		return jsonArray;
	}
}
