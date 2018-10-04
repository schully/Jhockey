/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey;

/**
 *
 * @author ElKebabHenry
 */
public class Game {
    private int id;
    private int points;
    private String homeTeam;
    private String awayTeam;
    
    public Game(int id, int points, String homeTeam, String awayTeam){
        this.id = id;
        this.points = points;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
}
