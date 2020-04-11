package com.example.cs5200sp20liuserverjava.models;

public class HtmlWidget extends Widget {
    private String html;
    public HtmlWidget(String html, int widgetId, String widgetName, String text, int width, int height, int order, int pageId, String dType, String url) {
        super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
        this.html=html;
    }

    public String getHtml(){ return html; }
    public void setHtml(){ this.html = html; }
}
