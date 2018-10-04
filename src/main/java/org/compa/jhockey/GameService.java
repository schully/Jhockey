/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey;


import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ElKebabHenry
 */
@Path("")
public class GameService {
    @EJB
    GameBean gameBean;
    
    @GET
    @Path("/GetGames")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames(){
        String json = gameBean.getGames();
        return Response.ok(json).build();
    }
    
    @PUT
    @Path("/AddGame")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGame(String body) {
        int gameId = gameBean.addGame(body);
       return Response.ok(String.format("{ \"game_id\": %d }", gameId)).build();
    }
    
    @PUT
    @Path("/UpdateGame")
    public Response updateGame(String body){
        if(gameBean.updateGame(body)) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
    
    @DELETE
    @Path("/DeleteGame")
    public Response deleteGame(@QueryParam("id") int id){
        if(gameBean.deleteGame(id)){
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
}
