/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
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
    public String getTable(){
        ArrayList<Game> games = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql ="SELECT * FROM result";
            ResultSet data = stmt.executeQuery(sql);
            while(data.next()){
                int id = data.getInt("id");
                int points = data.getInt("points");
                String awayTeam = data.getString("awayTeam");
                String homeTeam = data.getString("homeTeam");
                games.add(new Game(id, points, awayTeam, homeTeam));
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        Gson gson = new Gson();
        return gson.toJson(games);
    }
    
}
