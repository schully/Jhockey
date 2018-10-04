/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ElKebabHenry
 */
@Stateless
public class GameBean {
    public String getGames(){
        ArrayList<Game> games = new ArrayList<>();
        
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql ="SELECT * FROM game";
            ResultSet data = stmt.executeQuery(sql);
            while(data.next()){
                int id = data.getInt("id");
                
                String homeTeam = data.getString("home_team");
                int homePoints = data.getInt("home_points");
                
                String awayTeam = data.getString("away_team");
                int awayPoints = data.getInt("away_points");
                //  str home team name
                //  num home points
                
                //  str away team name
                //  num away points
                
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }

        Gson gson = new Gson();
        return gson.toJson(games);
    }
    
    public int addGame(String json) {
        JsonParser parser = new JsonParser();
        JsonElement body = parser.parse(json);
        
        JsonObject home = body.getAsJsonObject().get("home").getAsJsonObject();
        int homeTeamId = home.get("team_id").getAsInt();
        int homePoints = home.get("points").getAsInt();
        
        JsonObject away = body.getAsJsonObject().get("away").getAsJsonObject();
        int awayTeamId = away.get("team_id").getAsInt();
        int awayPoints = away.get("points").getAsInt();
        //  this.addGame(team, team);
        
        return addGame(homeTeamId, homePoints, awayTeamId, awayPoints);
    }
    
    public int addGame(int homeTeamId, int homeTeamPoints, int awayTeamId, int awayTeamPoints){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO games (home_team, home_points, away_team, away_points) VALUES (?, ?, ?, ?)"
            );
            stmt.setInt(1, homeTeamId);
            stmt.setInt(2, homeTeamPoints);
            stmt.setInt(3, awayTeamId);
            stmt.setInt(4, awayTeamPoints);
            
            stmt.executeUpdate();
            int gameId = (int)stmt.getGeneratedKeys().getLong(1);
            
            return gameId;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return -1;
        }
    }
    
    public boolean updateGame(String json){
        JsonParser parser = new JsonParser();
        JsonObject body = parser.parse(json).getAsJsonObject();
        
        int gameID = body.get("game_id").getAsInt();
        
        JsonObject huawei;
        JsonObject googleHome;
        
        if (body.has("away")) {
            huawei = body.get("away").getAsJsonObject();
            
            return updateGameItem(gameID, false, huawei.get("team_id").getAsInt(),
                    huawei.get("points").getAsInt());
        }
        
        if (body.has("home")) {
            googleHome = body.get("home").getAsJsonObject();
            
            return updateGameItem(gameID, true, googleHome.get("team_id").getAsInt(),
                    googleHome.get("points").getAsInt());
        }
        
        return false;
    }
    
    public boolean updateGameItem(int gameId, boolean isHome, int teamId, int points){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            stmt.executeQuery(
                String.format(
                        "UPDATE games SET %s=%d, %s=%d WHERE id=%d",
                        isHome ? "home_team" : "away_team",
                        teamId,
                        isHome ? "home_points" : "away_points",
                        points,
                        gameId
                )
            );
            
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return false;
        }        
    }
    
    public boolean deleteGame(int id){
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            stmt.executeQuery("DELETE FROM games WHERE id ="+id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return false;
        }
    }
    
}
