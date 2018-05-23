package tr.com.dev.haliYikama.server.authentication.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import tr.com.dev.haliYikama.server.authentication.JwtAuthenticationRequest;
import tr.com.dev.haliYikama.server.authentication.JwtUser;
import tr.com.dev.haliYikama.server.authentication.service.JwtAuthenticationResponse;
import tr.com.dev.haliYikama.server.helper.Helper;

import java.io.IOException;

/**
 * Created by ramazancesur on 5/22/18.
 */
public class RAuthentication {
    public static JwtAuthenticationResponse jwtAuthenticationResponse;

    public static JwtAuthenticationResponse getAuthTokenCookie(JwtUser user) throws IOException {
        if (jwtAuthenticationResponse == null) {
            Helper helper = new Helper();
            String appUrl = helper.loadProperties("application.properties").getProperty("server.app.url");
            String uri = appUrl + "/auth";
            try {
                Client client = Client.create();
                WebResource webResource = client.resource(uri);
                ObjectMapper mapper = new ObjectMapper();
                JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest(user.getUsername(), user.getPassword());


                ClientResponse response = webResource.type("application/json")
                        .post(ClientResponse.class, mapper.writeValueAsString(jwtAuthenticationRequest));

                if (response.getStatus() == 201) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatus());
                }

                String jsonResponse = response.getEntity(String.class);

                Gson gson = new Gson();
                jwtAuthenticationResponse = gson.fromJson(jsonResponse, JwtAuthenticationResponse.class);

                System.out.println(jsonResponse);
                System.out.println("Output from Server .... \n");

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jwtAuthenticationResponse.getToken() == null) {
                jwtAuthenticationResponse = null;
            }
            return jwtAuthenticationResponse;

        } else {
            return jwtAuthenticationResponse;
        }
    }


}
