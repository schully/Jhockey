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
public class TeamWithId extends Team {
    private int id;

    public TeamWithId(int id, String name, int points) {
        super(name, points);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
