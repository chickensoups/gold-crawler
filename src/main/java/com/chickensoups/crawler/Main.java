/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ai02
 */
public class Main {

    public static void main(String[] args) {
        //create a sql date string so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        DataUtil dataUtil = new DataUtil();

        //crawl gold rate
        System.out.println("START CRAWL GOLD DATA...");
        GoldCrawler goldCrawler = new GoldCrawler(date, dataUtil);
        goldCrawler.crawl();
        System.out.println("END CRAWL GOLD DATA!");

        //crawl exchange rate
        System.out.println("START CRAWL EXCHANGE RATE DATA...");
        ExchangeRateCrawler exchangeRateCrawler = new ExchangeRateCrawler(date, dataUtil);
        exchangeRateCrawler.crawl();
        System.out.println("END CRAWL EXCHANGE RATE DATA!");
    }
}
