package com.example.cs5200sp20liuserverjava.models;

public class Widget {
    private int widgetId;
    private String widgetName;
    private String cssClass;
    private String cssStyle;
    private String text;
    private int width;
    private int height;
    private int order;
    private int pageId;
    private String dType;
    private String url;


    public Widget(int widgetId, String widgetName, String text, int width, int height, int order, int pageId,
                  String dType, String url) {
        super();
        this.widgetId = widgetId;
        this.widgetName = widgetName;
        this.text = text;
        this.width = width;
        this.height = height;
        this.order = order;
        this.pageId = pageId;
        this.dType = dType;
        this.url = url;
    }


    public Widget(int widgetId, String widgetName, String text, int width, int height, int order, String url, int pageId,
                  String dType) {
        super();
        this.widgetId = widgetId;
        this.widgetName = widgetName;
        this.text = text;
        this.width = width;
        this.height = height;
        this.url=url;
        this.order = order;
        this.pageId = pageId;
        this.dType = dType;
    }

    public Widget(int widgetId, String widgetName, String text, int order, int pageId,
                  String dType) {
        super();
        this.widgetId = widgetId;
        this.widgetName = widgetName;
        this.text = text;
        this.order = order;
        this.pageId = pageId;
        this.dType = dType;
    }


    public Widget(int widgetId, String widgetName, String cssClass,String cssStyle, String text, int width, int height,
                  int order, int pageId) {
        super();
        this.widgetId = widgetId;
        this.widgetName = widgetName;
        this.cssClass = cssClass;

        this.text = text;
        this.width = width;
        this.height = height;
        this.order = order;
        this.pageId = pageId;
    }




    public Widget(int id, String dtype, int page_id, String name, int width, int height, String css_class, String css_style, String text, int order) {
        super();
        this.widgetId = id;
        this.dType=dtype;
        this.pageId=page_id;
        this.cssClass = css_class;
        this.cssStyle = css_style;
        this.text = text;
        this.width = width;
        this.height = height;
        this.order = order;
        this.pageId = page_id;

    }


    public String getdType() {
        return dType;
    }
    public void setdType(String dType) {
        this.dType = dType;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getWidgetId() {
        return widgetId;
    }
    public void setWidgetId(int widgetId) {
        this.widgetId = widgetId;
    }
    public String getWidgetName() {
        return widgetName;
    }
    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }
    public String getCssClass() {
        return cssClass;
    }
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    public String getCssStyle() {
        return cssClass;
    }
    public void setCssStyle(String cssClass) {
        this.cssClass = cssClass;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getPageId() {
        return pageId;
    }
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }


}
