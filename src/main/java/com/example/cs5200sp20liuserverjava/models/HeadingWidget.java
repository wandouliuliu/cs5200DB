package com.example.cs5200sp20liuserverjava.models;

public class HeadingWidget extends Widget  {
    private int size;
    public HeadingWidget(int size, int widgetId, String widgetName, String text, int width, int height, int order, int pageId, String dType, String url) {
        super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
        this.size=size;
    }

    public int getSize(){ return size; }
    public void setSize(){ this.size = size; }
}
