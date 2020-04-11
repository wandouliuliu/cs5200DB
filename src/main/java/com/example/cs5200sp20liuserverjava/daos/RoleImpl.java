package com.example.cs5200sp20liuserverjava.daos;

public interface RoleImpl {
    public void assignWebsiteRole(int developerId, int websiteId, int roleId);

    public void assignPageRole(int developerId, int pageId, int roleId);

    public void deleteWebsiteRole(int developerId, int websiteId, int roleId);
    public void deleteWebsiteRole( int websiteId);
    public void deletePageRole(int developerId, int pageId, int roleId);
    public void deletePageRole( int pageId);



}
