package com.example.cs5200sp20liuserverjava.daos;

public interface PriviledgeImpl {

    void assignWebsitePriviledge(int developerId, int websiteId, String priviledge);
    void assignPagePriviledge(int developerId, int pageId, String priviledge);
    void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge);
    void deletePagePriviledge(int developerId, int pageId, String priviledge);

}
