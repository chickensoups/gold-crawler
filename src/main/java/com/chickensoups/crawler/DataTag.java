/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

/**
 *
 * @author chickensoups
 */
public class DataTag {
    private String name;
    private int start;
    private int end;

    public DataTag() {
    }

    public DataTag(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(int start) {
        this.start = start;
    }
    
    public void setEnd(int end) {
        this.end = end;
    }
}
