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
public class ExchangeRate {

    private String table;
    private String currency;
    private String buy;
    private String sell;
    private String transfer;
    private String date;

    public ExchangeRate() {
    }

    public ExchangeRate(String table, String currency, String buy, String sell, String transfer, String date) {
        this.table = table;
        this.currency = currency;
        this.buy = buy;
        this.sell = sell;
        this.transfer = transfer;
        this.date = date;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
