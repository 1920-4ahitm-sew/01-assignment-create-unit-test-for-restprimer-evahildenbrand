package at.htl.restprimer.rest;

//region Imports
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//endregion

@Path("time")
public class TimeServerResource {

    /**
     * Method to show the current date and time
     *
     * @return date and time in format dd. MMMM yyyy, hh:mm:ss
     */
    @GET
    public String time(){
        return "Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd. MMMM yyyy, hh:mm:ss"));
    }
}
