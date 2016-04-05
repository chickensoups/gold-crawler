/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ai02
 */
public class ExchangeRateCrawler {

    private final String date;
    private final DataUtil dataUtil;

    public ExchangeRateCrawler(String date, DataUtil dataUtil) {
        this.date = date;
        this.dataUtil = dataUtil;
    }

    public void crawl() {
        System.out.println("Start crawl vietcombank");
        Site vietcombank = crawlVietcombank("money_vietcombank");
        System.out.println("Start crawl vietinbank");
        Site vietinbank = crawlVietinbank("money_vietinbank");
        System.out.println("Start crawl tpbank");
        Site tpbank = crawlTpbank("money_tpbank"); //handshake failed
        System.out.println("Start crawl vpbank");
        Site vpbank = crawlVpbank("money_vpbank");
        System.out.println("Start crawl sacombank");
        Site sacombank = crawlSacombank("money_sacombank");
        System.out.println("Start crawl scb");
        Site scb = crawlScb("money_scb");
        System.out.println("Start crawl shb");
        Site shb = crawlShb("money_shb");
        System.out.println("Start crawl eximbank");
        Site eximbank = crawlEximbank("money_eximbank");
//          Site msb = crawlMsb("money_msb");//have no table name money_msb
    }

    //crawl vietcombank
    private Site crawlVietcombank(String table) {
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

    //crawl viettinbank
    private Site crawlVietinbank(String table) {
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

    //crawl tpbank
    private Site crawlTpbank(String table) {
        Site site = new Site("https://tpb.vn/financial-toolkit/ty-gia-ngoai-te");

        try {
            Document doc = Jsoup.connect(site.getUrl()).timeout(20000).get();
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

    //crawl msb
    private Site crawlMsb(String table) {
        String selectedDate = date.substring(8, 10) + "%2F" + date.substring(5, 7) + "%2F" + date.substring(0, 4);
        Site site = new Site("https://www.msb.com.vn/.msb-crud-portlets/exchangeRate?dateSelected=" + selectedDate);

        try {
            Document doc = Jsoup.connect(site.getUrl()).ignoreContentType(true).get();
            JSONArray array = new JSONArray(doc.body().text());
            JSONArray data = (JSONArray) array.get(0);

            for (int i = 0; i < data.length(); i++) {
                JSONObject obj = data.getJSONObject(i);
                ExchangeRate exchangeRate = new ExchangeRate(table, obj.getString("code"), obj.getString("code"), obj.getString("buyingOut"), obj.getString("sellingOut"), obj.getString("sellingOut"), date);
                System.out.println(exchangeRate);
                dataUtil.insertExchangeRate(exchangeRate);
            }
        } catch (IOException | JSONException ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl vpbank
    private Site crawlVpbank(String table) {
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

    //crawl sacombank
    private Site crawlSacombank(String table) {
        Site site = new Site("http://www.sacombank.com.vn/Pages/default.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).timeout(20000).get();
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

    //crawl scb
    private Site crawlScb(String table) {
        Site site = new Site("https://www.scb.com.vn/exchangerate.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).timeout(20000).get();
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

    //crawl eximbank
    private Site crawlEximbank(String table) {
        Site site = new Site("https://eximbank.com.vn/WebsiteExrate/ExchangeRate_vn_2012.aspx");

        try {
            Document doc = Jsoup.connect(site.getUrl()).get();
            site.setAllContent(doc.toString());
            Elements trs = new Elements();
            try {
                trs = doc.select("table").get(9).getElementsByTag("tr");
            } catch (Exception ex) {
                System.out.println("Error eximbank when get table");
            }

            for (int i = 1; i < trs.size(); i++) {
                if (trs.get(i).attr("height").isEmpty()) {
                    Elements tds = trs.get(i).getElementsByTag("td");
                    ExchangeRate exchangeRate = new ExchangeRate(table, tds.get(0).text().trim(), tds.get(0).text().trim(), tds.get(1).text(), tds.get(5).text(), tds.get(3).text(), date);
                    System.out.println(exchangeRate);
                    dataUtil.insertExchangeRate(exchangeRate);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ExchangeRateCrawler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("@@@ ERROR crawl " + table);
        }
        return site;
    }

    //crawl shb
    private Site crawlShb(String table) {
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
