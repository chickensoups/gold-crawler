/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    static String date;
    static DataUtil dataUtil;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a sql date string so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = dateFormat.format(calendar.getTime());
        dataUtil = new DataUtil();

        Site sjc = crawlSJC();
        Site doj = crawlDOJ();
        Site vangmieng = crawlVangMieng();
        Site scb = crawlSCB();
        Site mytho = crawlMyTho();
        Site nguyenkim = crawlNguyenKim();
        Site btmc = crawlBTMC();

        System.out.println(sjc.getData());
        System.out.println("===========");
        System.out.println(doj.getData());
        System.out.println("===========");
        System.out.println(vangmieng.getData());
        System.out.println("===========");
        System.out.println(mytho.getData());
        System.out.println("===========");
        System.out.println(nguyenkim.getData());
        System.out.println("===========");
        System.out.println(btmc.getData());
        System.out.println("===========");
    }

    private static Site crawlSJC() {
        //sjc
        Site sjc = new Site("http://www3.sjc.com.vn/xml/tygiavang.xml");
        try {
            System.out.println(">>>>> START crawl sjc...");
            Document doc = Jsoup.connect(sjc.getUrl()).get();
            sjc.setAllContent(doc.toString());
            Elements trs = doc.getElementsByTag("city");
            HashMap<String, String> data = new HashMap<>();
            for (int i = 0; i < trs.size(); i++) { //ignore trs.get(0;
                Element tr = trs.get(i);
                Element eachData = tr.getElementsByTag("item").first();
                String title = tr.attr("name");
                data.put(title + "-sjc-in", eachData.attr("buy"));
                data.put(title + "-sjc-out", eachData.attr("sell"));
                if (title.toLowerCase().contains("hà nội")) {
                    dataUtil.insertGold(new Gold("gold_sjchn", eachData.attr("buy"), eachData.attr("sell"), date));
                }
                if (title.toLowerCase().contains("hồ chí minh")) {
                    dataUtil.insertGold(new Gold("gold_sjchcm", eachData.attr("buy"), eachData.attr("sell"), date));
                }

                if (title.toLowerCase().contains("nẵng")) {
                    dataUtil.insertGold(new Gold("gold_sjcdn", eachData.attr("buy"), eachData.attr("sell"), date));
                }
            }
            sjc.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl sjc!");
        }
        System.out.println("<<<<< END crawl sjc!");
        return sjc;
    }

    private static Site crawlDOJ() {
        //giavang.doji.vn
        Site doj = new Site("http://giavang.doji.vn");
        System.out.println(">>>>> START crawl giavang.doji.vn...");
        try {
            Document doc = Jsoup.connect(doj.getUrl()).get();
            doj.setAllContent(doc.toString());
            Elements priceTable = doc.getElementsByClass("ant-home-price");
            Elements trs = priceTable.first().getElementsByTag("tr");
            HashMap<String, String> data = new HashMap<>();
            for (int i = 1; i < trs.size(); i++) { //ignore trs.get(0;
                Element tr = trs.get(i);
                Elements tds = tr.getElementsByTag("td");
                String title = tds.first().text();
                String inPrice = tds.get(1).text();
                String outPrice = tds.get(2).text();
                data.put(title + "-in", inPrice);
                data.put(title + "-out", outPrice);

                if (title.toLowerCase().contains("doji hn buôn")) {
                    dataUtil.insertGold(new Gold("gold_dojihn", tds.get(1).text(), tds.get(2).text(), date));
                }
                if (title.toLowerCase().contains("doji hcm buôn")) {
                    dataUtil.insertGold(new Gold("gold_dojihcm", tds.get(1).text(), tds.get(2).text(), date));
                }
            }
            doj.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl giavang.doji.vn");
        }
        System.out.println("<<<<< END crawl giavang.doji.vn!");
        return doj;
    }

    private static Site crawlVangMieng() {
        //vangmieng
        Site vangmieng = new Site("http://vangmieng.pnj.com.vn/data.xml");
        System.out.println(">>>>> START crawl vangmieng...");
        try {
            Document doc = Jsoup.connect(vangmieng.getUrl()).get();
            vangmieng.setAllContent(doc.toString());
            Element sjcElement = doc.getElementsByTag("pnj").first();
            //sjc hcm
            Element sjchcmElement = sjcElement.getElementsByTag("sjctphcm").first();
            String sjchcmin = sjchcmElement.getElementsByTag("mua").first().text();
            String sjchcmout = sjchcmElement.getElementsByTag("ban").first().text();

            //sjc hn
            Element sjchnElement = sjcElement.getElementsByTag("sjchn").first();
            String sjchnin = sjchnElement.getElementsByTag("mua").first().text();
            String sjchnout = sjchnElement.getElementsByTag("ban").first().text();

            HashMap<String, String> data = new HashMap<>();
            data.put("sjchcm-in", sjchcmin);
            data.put("sjchcm-out", sjchcmout);
            data.put("sjchn-in", sjchnin);
            data.put("sjchn-out", sjchnout);

            vangmieng.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl vangmieng!");
        }

        System.out.println("<<<<< END crawl vangmieng!");
        return vangmieng;
    }

    private static Site crawlSCB() {
        //scb
        Site scb = new Site("http://scb.com.vn/goldrate.aspx/");
        System.out.println(">>>>> START crawl scb...");
        try {
//            Document doc = Jsoup.connect(scb.getUrl())
//                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//                    .header("Accept-Encoding", "gzip, deflate, br")
//                    .header("Accept-Language", "en-US,en;q=0.5")
//                    .header("Connection", "keep-alive")
//                    .header("Host", "scb.com.vn")
//                    .cookie("AspxAutoDetectCookieSupport", "1")
//                    .cookie("TS01bbff28", "014a8170720ccd275061e6993450578b8b8aa6347dd6d3702b47db56c817345533edd22ea80e2be68fd03d726b255ad9c2536546366d0da8b8059351e37b802db63082ea2b3e35e2e4abe816b19f5f50dda55adc3c")
//                    .cookie(".ASPXANONYMOUS", "JbBbiqa50QEkAAAAYzhmMmQ5MGMtYTZhMC00ZWY5LTg4NWQtNzk4NzI3NGE0ODZlJUlgjr8FvHfN6nSXUIM7xy3PBsQ1")
//                    .cookie("ASP.NET_SessionId", "a5uomfum0p412qf0cwbajv45")
//                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:45.0) Gecko/20100101 Firefox/45.0")
//                    .referrer("http://scb.com.vn").timeout(5000).get();
            Document doc = Jsoup.connect(scb.getUrl())
                    .followRedirects(false)
                    .post();

            scb.setAllContent(doc.toString());
//            System.out.println(doc);
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
        return scb;
    }

    private static Site crawlMyTho() {
        //mytho
        Site mytho = new Site("http://115.78.208.5:8080/mytho/");
        System.out.println(">>>>> START crawl mytho...");
        try {
            Document doc = Jsoup.connect(mytho.getUrl()).get();
            mytho.setAllContent(doc.toString());

            Element dataTable = doc.getElementsByAttributeValue("cellpadding", "2").first();
            Elements trs = dataTable.getElementsByTag("tr");
            HashMap<String, String> data = new HashMap<>();
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                data.put(tds.first().text() + "-in", tds.get(1).text());
                data.put(tds.first().text() + "-out", tds.get(2).text());
                if (tds.size() > 3) {
                    data.put(tds.get(3).text() + "-in", tds.get(4).text());
                    data.put(tds.get(3).text() + "-out", tds.get(5).text());
                }
            }

            mytho.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl mytho!");
        }
        System.out.println("<<<<< END crawl mytho!");
        return mytho;
    }

    private static Site crawlNguyenKim() {
        //nguyenkim
        Site nguyenkim = new Site("http://115.78.208.5:8080/nguyenkim/");
        System.out.println(">>>>> START crawl nguyenkim...");
        try {
            Document doc = Jsoup.connect(nguyenkim.getUrl()).get();
            nguyenkim.setAllContent(doc.toString());

            Element dataTable = doc.getElementsByAttributeValue("cellpadding", "2").first();
            Elements trs = dataTable.getElementsByTag("tr");
            HashMap<String, String> data = new HashMap<>();
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                data.put(tds.first().text() + "-in", tds.get(1).text());
                data.put(tds.first().text() + "-out", tds.get(2).text());
                if (tds.size() > 3) {
                    data.put(tds.get(3).text() + "-in", tds.get(4).text());
                    data.put(tds.get(3).text() + "-out", tds.get(5).text());
                }
            }

            nguyenkim.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl nguyenkim!");
        }
        System.out.println("<<<<< END crawl nguyenkim!");
        return nguyenkim;
    }

    private static Site crawlBTMC() {
        //btmc
        System.out.println(">>>>> START crawl BTMC...");
        Site btmc = new Site("http://btmc.com.vn/");
        try {
            Document doc = Jsoup.connect(btmc.getUrl()).get();
            btmc.setAllContent(doc.toString());

            Element dataTable = doc.getElementById("ctl00_TablePriceGold30_09_20131_UpdatePanel1").getElementsByTag("table").first();
            Elements trs = dataTable.getElementsByTag("tr");
            HashMap<String, String> data = new HashMap<>();

            ArrayList<DataTag> dataTags = new ArrayList<>();
            DataTag vangrongthanglong = new DataTag("vangrongthanglong", 1, 4);
            DataTag vangBTMC = new DataTag("vangBTMC", 5, 5);
            DataTag vangHTBT = new DataTag("vangHTBT", 6, 6);
            DataTag vangJSC = new DataTag("vangJSC", 7, 7);
            dataTags.add(vangrongthanglong);
            dataTags.add(vangBTMC);
            dataTags.add(vangHTBT);
            dataTags.add(vangJSC);

            for (DataTag dataTag : dataTags) {
                for (int i = dataTag.getStart(); i <= dataTag.getEnd(); i++) {
                    Elements tds = trs.get(i).getElementsByTag("td");
                    if (i == dataTag.getStart()) {
                        data.put(dataTag.getName() + "-" + tds.get(1).text() + "-in", tds.get(3).text());
                        data.put(dataTag.getName() + "-" + tds.get(1).text() + "-out", tds.get(4).text());
                    } else {
                        data.put(dataTag.getName() + "-" + tds.get(0).text() + "-in", tds.get(2).text()
                        );
                        data.put(dataTag.getName() + "-" + tds.get(0).text() + "-out", tds.get(3).text());
                    }
                }
            }

            btmc.setData(data);
        } catch (Exception ex) {
            Logger.getLogger(GoldCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl BTMC!");
        }
        System.out.println("<<<<< END crawl BTMC!");
        return btmc;
    }
}
