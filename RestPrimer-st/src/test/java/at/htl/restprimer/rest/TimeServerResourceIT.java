package at.htl.restprimer.rest;

//region Imports
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
//endregion

public class TimeServerResourceIT {
    //Variablen
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        //Creates new Client
        this.client = ClientBuilder.newClient();
        //Sets the target to the Wildfly-Server of the RestPrimer
        this.target = this.client.target("http://localhost:8080/restprimer/api/time");
    }

    @Test
    public void fetchTime(){
        //Sending Request to get plain-Text from the target and saving the Response
        Response response = this.target.request(MediaType.TEXT_PLAIN).get();
        //Checks if the response has the status 200, so that the request was successful
        assertThat(response.getStatus(),is(200));

        //Reads the message input string
        String payload = response.readEntity(String.class);
        //Checks if the payload starts with the String "Time: "
        assertTrue(payload.startsWith("Time: "));
        
        System.out.println("payload = " + payload);
    }
}
