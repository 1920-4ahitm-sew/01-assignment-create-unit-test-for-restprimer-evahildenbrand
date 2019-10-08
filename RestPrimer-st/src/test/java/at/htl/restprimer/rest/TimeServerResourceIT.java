package at.htl.restprimer.rest;

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

public class TimeServerResourceIT {
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = this.client.target("http://localhost:8080/restprimer/api/time");
    }

    @Test
    public void fetchTime(){
        Response response = this.target.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(),is(200));

        String payload = response.readEntity(String.class);
        assertTrue(payload.startsWith("Time: "));
        System.out.println("payload = " + payload);
    }
}
