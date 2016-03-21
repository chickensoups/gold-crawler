/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.gold.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author vuong
 */
public class GoldCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Site sjc = new Site("http://www3.sjc.com.vn/xml/tygiavang.xml");
        Site doj = new Site("http://giavang.doji.vn");
        Site vangmieng = new Site("http://vangmieng.pnj.com.vn/data.xml");
        Site scb = new Site("http://scb.com.vn/goldrate.aspx");
        Site mytho = new Site("http://115.78.208.5:8080/mytho/");
        Site nguyenkim = new Site("http://115.78.208.5:8080/nguyenkim/");
        Site btmc = new Site("http://btmc.com.vn/");

        ArrayList<Site> sites = new ArrayList<>();

        sites.add(sjc);
        sites.add(doj);
        sites.add(vangmieng);
        sites.add(scb);
        sites.add(mytho);
        sites.add(nguyenkim);
        sites.add(btmc);

//        //sjc
//        try {
//            System.out.println(">>>>> START crawl sjc...");
//            Document doc = Jsoup.connect(sjc.getUrl()).get();
//            sjc.setAllContent(doc.toString());
//            Elements trs = doc.getElementsByTag("city");
//            HashMap<String, String> data = new HashMap<>();
//            for (int i = 1; i < trs.size(); i++) { //ignore trs.get(0;
//                Element tr = trs.get(i);
//                Element eachData = tr.getElementsByTag("item").first();
//                String title = tr.attr("name");
//                data.put(title + "-sjc-in", eachData.attr("buy"));
//                data.put(title + "-sjc-out", eachData.attr("sell"));
//            }
//            sjc.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl sjc!");
//        }
//        System.out.println("<<<<< END crawl sjc!");
//
//        //giavang.doji.vn
//        System.out.println(">>>>> START crawl giavang.doji.vn...");
//        try {
//            Document doc = Jsoup.connect(doj.getUrl()).get();
//            doj.setAllContent(doc.toString());
//            Elements priceTable = doc.getElementsByClass("ant-home-price");
//            Elements trs = priceTable.first().getElementsByTag("tr");
//            HashMap<String, String> data = new HashMap<>();
//            for (int i = 1; i < trs.size(); i++) { //ignore trs.get(0;
//                Element tr = trs.get(i);
//                Elements tds = tr.getElementsByTag("td");
//                String title = tds.first().text();
//                String inPrice = tds.get(1).text();
//                String outPrice = tds.get(2).text();
//                data.put(title + "-in", inPrice);
//                data.put(title + "-out", outPrice);
//            }
//            doj.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl giavang.doji.vn");
//        }
//        System.out.println("<<<<< END crawl giavang.doji.vn!");
//
//        System.out.println(">>>>> START crawl vangmieng...");
//        //vangmieng
//        try {
//            Document doc = Jsoup.connect(vangmieng.getUrl()).get();
//            vangmieng.setAllContent(doc.toString());
//            Element sjcElement = doc.getElementsByTag("pnj").first();
//            //sjc hcm
//            Element sjchcmElement = sjcElement.getElementsByTag("sjctphcm").first();
//            String sjchcmin = sjchcmElement.getElementsByTag("mua").first().text();
//            String sjchcmout = sjchcmElement.getElementsByTag("ban").first().text();
//
//            //sjc hn
//            Element sjchnElement = sjcElement.getElementsByTag("sjchn").first();
//            String sjchnin = sjchnElement.getElementsByTag("mua").first().text();
//            String sjchnout = sjchnElement.getElementsByTag("ban").first().text();
//
//            HashMap<String, String> data = new HashMap<>();
//            data.put("sjchcm-in", sjchcmin);
//            data.put("sjchcm-out", sjchcmout);
//            data.put("sjchn-in", sjchnin);
//            data.put("sjchn-out", sjchnout);
//
//            sjc.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl vangmieng!");
//        }
//
//        System.out.println("<<<<< END crawl vangmieng!");

        //scb
        System.out.println(">>>>> START crawl scb...");
        try {
//            Document doc = Jsoup.connect(scb.getUrl()).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36").get();
            String doc = Jsoup.connect(scb.getUrl()).execute().body();
            System.out.println(doc.toString());
            scb.setAllContent(doc.toString());
            Element dataTable = doc.getElementsByClass("dp1-table").first();
            System.out.println(dataTable);
            Element sjc1luong = dataTable.getElementsByTag("tr").first();
            Element sjc125chi = dataTable.getElementsByTag("tr").get(1);

            String sjc1luongin = sjc1luong.getElementsByTag("td").get(1).text();
            String sjc1luongout = sjc1luong.getElementsByTag("td").get(2).text();
            String sjc125chiin = sjc125chi.getElementsByTag("td").get(1).text();
            String sjc125chiout = sjc125chi.getElementsByTag("td").get(2).text();

            HashMap<String, String> data = new HashMap<>();
            data.put("sjc1luongin", sjc1luongin);
            data.put("sjc1luongout", sjc1luongout);
            data.put("sjc125chiin", sjc125chiin);
            data.put("sjc125chiout", sjc125chiout);

            scb.setData(data);

            System.out.println(scb.getData());
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl scb!");
        }
        System.out.println("<<<<< END crawl scb!");
        
//        //mytho
//        System.out.println(">>>>> START crawl mytho...");
//        try {
//            Document doc = Jsoup.connect(mytho.getUrl()).get();
//            mytho.setAllContent(doc.toString());
//
//            Element dataTable = doc.getElementsByAttributeValue("cellpadding", "2").first();
//            Elements trs = dataTable.getElementsByTag("tr");
//            HashMap<String, String> data = new HashMap<>();
//            for (int i = 1; i < trs.size(); i++) {
//                Elements tds = trs.get(i).getElementsByTag("td");
//                data.put(tds.first().text() + "-in", tds.get(1).text());
//                data.put(tds.first().text() + "-out", tds.get(2).text());
//                data.put(tds.get(3).text() + "-in", tds.get(4).text());
//                data.put(tds.get(3).text() + "-out", tds.get(5).text());
//            }
//
//            mytho.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl mytho!");
//        }
//        System.out.println("<<<<< END crawl mytho!");
//
//        //nguyenkim
//        System.out.println(">>>>> START crawl nguyenkim...");
//        try {
//            Document doc = Jsoup.connect(nguyenkim.getUrl()).get();
//            nguyenkim.setAllContent(doc.toString());
//
//            Element dataTable = doc.getElementsByAttributeValue("cellpadding", "2").first();
//            Elements trs = dataTable.getElementsByTag("tr");
//            HashMap<String, String> data = new HashMap<>();
//            for (int i = 1; i < trs.size(); i++) {
//                Elements tds = trs.get(i).getElementsByTag("td");
//                data.put(tds.first().text() + "-in", tds.get(1).text());
//                data.put(tds.first().text() + "-out", tds.get(2).text());
//                data.put(tds.get(3).text() + "-in", tds.get(4).text());
//                data.put(tds.get(3).text() + "-out", tds.get(5).text());
//            }
//
//            nguyenkim.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl nguyenkim!");
//        }
//        System.out.println("<<<<< END crawl nguyenkim!");
//
//        //btmc
//        System.out.println(">>>>> START crawl BTMC...");
//        try {
//            Document doc = Jsoup.connect(btmc.getUrl()).get();
//            btmc.setAllContent(doc.toString());
//
//            Element dataTable = doc.getElementById("ctl00_TablePriceGold30_09_20131_UpdatePanel1").getElementsByTag("table").first();
//            Elements trs = dataTable.getElementsByTag("tr");
//            HashMap<String, String> data = new HashMap<>();
//
//            ArrayList<DataTag> dataTags = new ArrayList<>();
//            DataTag vangrongthanglong = new DataTag("vangrongthanglong", 1, 4);
//            DataTag vangBTMC = new DataTag("vangBTMC", 5, 5);
//            DataTag vangHTBT = new DataTag("vangHTBT", 6, 6);
//            DataTag vangJSC = new DataTag("vangJSC", 7, 7);
//            dataTags.add(vangrongthanglong);
//            dataTags.add(vangBTMC);
//            dataTags.add(vangHTBT);
//            dataTags.add(vangJSC);
//
//            for (DataTag dataTag : dataTags) {
//                for (int i = dataTag.getStart(); i <= dataTag.getEnd(); i++) {
//                    Elements tds = trs.get(i).getElementsByTag("td");
//                    if (i == dataTag.getStart()) {
//                        data.put(dataTag.getName() + "-" + tds.get(1).text() + "-in", tds.get(3).text());
//                        data.put(dataTag.getName() + "-" + tds.get(1).text() + "-out", tds.get(4).text());
//                    } else {
//                        data.put(dataTag.getName() + "-" + tds.get(0).text() + "-in", tds.get(2).text());
//                        data.put(dataTag.getName() + "-" + tds.get(0).text() + "-out", tds.get(3).text());
//                    }
//                }
//            }
//
//            btmc.setData(data);
//        } catch (Exception ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl BTMC!");
//        }
//        System.out.println("<<<<< END crawl BTMC!");
    }
}
