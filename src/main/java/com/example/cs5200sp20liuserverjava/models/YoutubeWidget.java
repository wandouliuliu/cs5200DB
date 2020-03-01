package com.example.cs5200sp20liuserverjava.models;

public class YoutubeWidget extends Widget {
    private String url;
    private Boolean Shareble=false;
    private Boolean expandable=false;
    public YoutubeWidget(String html, int widgetId, String widgetName, String text, int width, int height, int order, int pageId, String dType, String url) {
        super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
        this.url=url;
        this.Shareble=Shareble;
        this.expandable=expandable;
    }

    public String getUrl(){ return url; }
    public void setUrl(){ this.url = url; }
    public Boolean getShareble(){ return Shareble; }
    public void setShareble(){ this.Shareble = Shareble; }
    public Boolean getExpandable(){ return expandable; }
    public void setExpandable(){ this.expandable = expandable; }
}
