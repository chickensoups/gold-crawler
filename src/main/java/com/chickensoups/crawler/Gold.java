/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.sql.Date;

/**
 *
 * @author vuong
 */
public class Gold {

    private String table;
    private String buy;
    private String sell;
    private String date;

    public Gold() {
    }

    public Gold(String table, String buy, String sell, String date) {
        this.table = table;
        this.buy = buy;
        this.sell = sell;
        this.date = date;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
