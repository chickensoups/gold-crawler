/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.gold.crawler;

import java.io.IOException;
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
        Site sjc = new Site("http://www3.sjc.com.vn/");
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

        //sjc
//        //giavang.doji.vn
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
//        } catch (IOException ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
//        } catch (IOException ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //scb
//        try {
//            Document doc = Jsoup.connect(scb.getUrl())
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.25 Safari/537.36").get();
//            scb.setAllContent(doc.toString());
//            Element dataTable = doc.getElementsByClass("dp1-table").first();
//            System.out.println(dataTable);
//            Element sjc1luong = dataTable.getElementsByTag("tr").first();
//            Element sjc125chi = dataTable.getElementsByTag("tr").get(1);
//
//            String sjc1luongin = sjc1luong.getElementsByTag("td").get(1).text();
//            String sjc1luongout = sjc1luong.getElementsByTag("td").get(2).text();
//            String sjc125chiin = sjc125chi.getElementsByTag("td").get(1).text();
//            String sjc125chiout = sjc125chi.getElementsByTag("td").get(2).text();
//
//            HashMap<String, String> data = new HashMap<>();
//            data.put("sjc1luongin", sjc1luongin);
//            data.put("sjc1luongout", sjc1luongout);
//            data.put("sjc125chiin", sjc125chiin);
//            data.put("sjc125chiout", sjc125chiout);
//
//            scb.setData(data);
//
//            System.out.println(scb.getData());
//        } catch (IOException ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //mytho
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
//        } catch (IOException ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        //nguyenkim
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
//        } catch (IOException ex) {
//            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //btmc
        try {
            Document doc = Jsoup.connect(vangmieng.getUrl()).get();
            doj.setAllContent(doc.toString());

            HashMap<String, String> data = new HashMap<>();
            sjc.setData(data);
        } catch (IOException ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
