package com.example.cs5200sp20liuserverjava.daos;


import com.example.cs5200sp20liuserverjava.models.Page;

import java.util.Collection;

public interface PageImpl  {

    void createPageForWebsite(int websiteId, Page page);
    Collection<Page> findAllPages();
    Page findPageById(int pageId);
    Collection<Page> findPagesForWebsite(int websiteId);
    int updatePage(int pageId, Page page);
    int deletePage(int pageId);
    Page findPageByName(String name);

}
