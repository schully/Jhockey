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

/**
 *
 * @author ElKebabHenry
 */
public class TeamBean {
    public String getTeams(){
        ArrayList<TeamWithId> teams = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql ="SELECT * FROM games";
            ResultSet data = stmt.executeQuery(sql);
            while(data.next()){
                int id = data.getInt("id");
                
                String team = data.getString("name");
                int points = data.getInt("points");

                
                teams.add(new TeamWithId(id, team, points));
                
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return new Gson().toJson(teams);
    }
}
