/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import static com.chickensoups.crawler.GoldCrawler.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ai02
 */
public class ExchangeRateCrawler {

    static String date;
    static DataUtil dataUtil;

    public static void main(String[] args) {
        //create a sql date string so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = dateFormat.format(calendar.getTime());
        dataUtil = new DataUtil();

//        Site vietcombank = crawlVietcombank("money_vietcombank");
//        Site vietinbank = crawlVietinbank("money_vietinbank");
//        Site tpbank = crawlTpbank("money_tpbank"); //handshake failed
//        Site vpbank = crawlVpbank("money_vpbank");
//        Site sacombank = crawlSacombank("money_sacombank");
//        Site scb = crawlScb("money_scb");
//        Site eximbank = crawlEximbank("money_eximbank"); //wrong selector
//        Site shb = crawlShb("money_shb");
//        Site msb = crawlMsb("money_msb");//parse json
    }

    //crawl site
    private static Site crawlVietcombank(String table) {
        Site site = new Site("http://www.vietcombank.com.vn/exchangerates/?lang=en");
        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementById("ctl00_Content_ExrateView");
            Elements trs = dataTable.getElementsByTag("tr");
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                ExchangeRate exchangeRate = new ExchangeRate(table, tds.get(0).text(), tds.get(1).text(), tds.get(2).text(), tds.get(4).text(), tds.get(3).text(), date);
                System.out.println(exchangeRate.toString());
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlVietinbank(String table) {
        Site site = new Site("https://www.vietinbank.vn/web/home/vn/ty-gia/");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementById("hor-ex-b");
            Elements trs = dataTable.getElementsByTag("tr");
            String tmpCode = "";
            for (int i = 2; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                String code = tds.get(0).text().trim();
                if (code.isEmpty()) {
                    code = tmpCode;
                } else {
                    tmpCode = code;
                }
                ExchangeRate exchangeRate = new ExchangeRate(table, code, "", tds.get(2).text(), tds.get(4).text(), tds.get(3).text(), date);
                System.out.println(exchangeRate.toString());
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlTpbank(String table) {
        Site site = new Site("https://tpb.vn/financial-toolkit/ty-gia-ngoai-te");

        try {
            Document doc = Jsoup.connect(site.getUrl()).timeout(10000).get();
            System.out.println(doc);
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementById("forex-rate-table");
            Elements trs = dataTable.getElementsByTag("tr");
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                ExchangeRate exchangeRate = new ExchangeRate(table, tds.get(0).text(), tds.get(1).text(), tds.get(2).text(), tds.get(4).text(), tds.get(3).text(), date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlMsb(String table) {
        String selectedDate = date.substring(8, 10) + "%2F" + date.substring(5, 7) + "%2F" + date.substring(0, 4);
        System.out.println(date);
        System.out.println(selectedDate);
        Site site = new Site("https://www.msb.com.vn/.msb-crud-portlets/exchangeRate?dateSelected=" + selectedDate);

        try {
            Document doc = Jsoup.connect(site.getUrl()).ignoreContentType(true).get();
            site.setAllContent(doc.toString());
            System.out.println(doc);
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlVpbank(String table) {
        Site site = new Site("http://www.vpbank.com.vn/vpb-exchange-rates");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementsByClass("views-table").first();
            Elements trs = dataTable.getElementsByTag("tr");
            for (int i = 1; i < trs.size(); i++) {
                System.out.println(trs.get(i).text());
                String[] data = trs.get(i).text().split(" ");
                ExchangeRate exchangeRate = new ExchangeRate(table, data[0], "", data[1], data[3], data[2], date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlSacombank(String table) {
        Site site = new Site("http://www.sacombank.com.vn/Pages/default.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementById("country1");
            Elements trs = dataTable.getElementsByTag("tr");
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                ExchangeRate exchangeRate = new ExchangeRate(table, tds.get(0).text(), "", tds.get(1).text(), tds.get(3).text(), tds.get(2).text(), date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlScb(String table) {
        Site site = new Site("https://www.scb.com.vn/exchangerate.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Element dataTable = doc.getElementsByClass("dp1-table").first();
            Elements trs = dataTable.getElementsByTag("tr");
            for (int i = 1; i < trs.size(); i++) {
                Elements tds = trs.get(i).getElementsByTag("td");
                ExchangeRate exchangeRate = new ExchangeRate(table, tds.get(0).text(), "", tds.get(1).text(), tds.get(3).text(), tds.get(2).text(), date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlEximbank(String table) {
        Site site = new Site("https://eximbank.com.vn/WebsiteExrate/ExchangeRate_vn_2012.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Elements trs = doc.getElementsByClass("tieude_tygia2").parents();
            for (int i = 1; i < trs.size(); i++) {
                System.out.println("===============");
                System.out.println(trs.get(i).text());
                System.out.println("==============");
//                Elements tds = trs.get(i).getElementsByClass("box_tygia");
//                ExchangeRate exchangeRate = new ExchangeRate(table, trs.get(i).firstElementSibling().text(), trs.get(i).firstElementSibling().text(), tds.get(0).text(), tds.get(2).text(), tds.get(1).text(), date);
//                System.out.println(exchangeRate);
//                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl site
    private static Site crawlShb(String table) {
        Site site = new Site("http://www.shb.com.vn/tygia/fx/exrate/shbfx.xml");
        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Elements trs = doc.getElementsByTag("exrate");
            Element usdUnder50 = trs.get(0);
            Element usdAbove50 = trs.get(1);
            Element euroUnder50 = trs.get(2);
            Element euroAbove50 = trs.get(3);

            ExchangeRate usdUnder50Rate = new ExchangeRate(table, "USD<50", usdUnder50.attr("currencyname"), usdUnder50.attr("buy"), usdUnder50.attr("sell"), usdUnder50.attr("transfer"), date);
            ExchangeRate usdAbove50Rate = new ExchangeRate(table, "USD<50", usdAbove50.attr("currencyname"), usdAbove50.attr("buy"), usdAbove50.attr("sell"), usdAbove50.attr("transfer"), date);
            ExchangeRate euroUnder50Rate = new ExchangeRate(table, "USD<50", euroUnder50.attr("currencyname"), euroUnder50.attr("buy"), euroUnder50.attr("sell"), euroUnder50.attr("transfer"), date);
            ExchangeRate euroAbove50Rate = new ExchangeRate(table, "USD<50", euroAbove50.attr("currencyname"), euroAbove50.attr("buy"), euroAbove50.attr("sell"), euroAbove50.attr("transfer"), date);
            dataUtil.insertExchangeRate(usdUnder50Rate);
            dataUtil.insertExchangeRate(usdAbove50Rate);
            dataUtil.insertExchangeRate(euroUnder50Rate);
            dataUtil.insertExchangeRate(euroAbove50Rate);
            for (int i = 5; i < trs.size(); i++) {
                Element element = trs.get(i);
                ExchangeRate exchangeRate = new ExchangeRate(table, element.attr("currencycode"), element.attr("currencyname"), element.attr("buy"), element.attr("sell"), element.attr("transfer"), date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }
}
