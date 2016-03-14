/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.gold.crawler;

import java.util.HashMap;

/**
 *
 * @author vuong
 */
public class Site {

    private String url;
    private String allContent;
    private HashMap<String, String> data;

    public Site() {
    }

    public Site(String url) {
        this.url = url;
        this.allContent = "";
        this.data = new HashMap<>();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAllContent() {
        return allContent;
    }

    public void setAllContent(String allContent) {
        this.allContent = allContent;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public HashMap<String, String> getData() {
        return data;
    }

}
