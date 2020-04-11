package com.example.cs5200sp20liuserverjava.daos;

import com.example.cs5200sp20liuserverjava.models.Website;

import java.util.Collection;

public interface WebsiteImpl {
    void createWebsiteForDeveloper(int developerId, Website website);
    Collection<Website> findAllWebsites();
    Collection<Website> findWebsitesForDeveloper(int developerId);
    Website findWebsiteById(int websiteId);
    int updateWebsite(int websiteId, Website website);
    int deleteWebsite(int websiteId);
}
