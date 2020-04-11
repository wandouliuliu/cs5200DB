package com.example.cs5200sp20liuserverjava.models;

public class ImageWidget extends Widget {
    private String src;
    public ImageWidget(String src,int widgetId, String widgetName, String text, int width, int height, int order, int pageId, String dType, String url) {
        super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
        this.src=src;
    }
    public String getSrc(){return src;}
    public void setSrc(){this.src=src;}
}
