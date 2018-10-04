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
    private Team home;
    private Team away;

    public Game(int id, Team home, Team away) {
        this.id = id;
        this.home = home;
        this.away = away;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
    

}
