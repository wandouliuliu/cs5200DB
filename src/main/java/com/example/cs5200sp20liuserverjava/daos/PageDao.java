package com.example.cs5200sp20liuserverjava.daos;
import com.example.cs5200sp20liuserverjava.models.Page;
import com.example.cs5200sp20liuserverjava.DBConnection;
import com.example.cs5200sp20liuserverjava.models.Website;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
public class PageDao implements PageImpl{
    Statement statement =null;
    ResultSet results =null;
    private static  PageDao instance= null;
    private PageDao(){}
    public static PageDao getInstance(){
        if(instance==null){
            instance = new PageDao();
        }
        return instance;
    }

    @Override
    public void createPageForWebsite(int websiteId, Page page) {
        Connection connection=null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = page.getPageId();
        String title = page.getTitle();
        String description = page.getDescription();
        Date created = page.getCreatedDate();
        Date updated = page.getUpdatedDate();
        int views=page.getViews();

        try{
            Statement s1 = connection.createStatement();
            String sql ="Insert into page VALUE"+
                    "("+id+"," +
                    "\""+title+"\"," +
                    "\""+description+"\"," +
                    "\""+created+"\"," +
                    "\""+updated+"\"," +
                    "\""+views+"\");" ;
            s1.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Collection<Page> findAllPages() {
        Collection<Page> pages = new ArrayList<Page>();
        try {
            Connection connection =DBConnection.getConnection();
            String findAllWebsites="select * from page;";

            Statement s1 = connection.createStatement();
            results = s1.executeQuery(findAllWebsites);

            while(results.next()) {
                int id= results.getInt("id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("updated");
                int views = results.getInt("views");
                //int webId=results.getInt("webId");
                Page page=new Page(id,title,description,created,updated,views);
                pages.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pages;
    }

    @Override
    public Page findPageById(int id) {
        Page page=null;
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String findPageById="select * from website,page where page.webId=website.id and page.id=?;";
            PreparedStatement pStatement = connection.prepareStatement(findPageById);
            pStatement.setInt(1,id);
            results = pStatement.executeQuery();

            if(results.next()) {

                int pageId= results.getInt("id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("updated");
                int views = results.getInt("views");
                int webId=results.getInt("webId");
                page = new Page(pageId,title,description,created,updated,views,webId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    public Page findPageByName(String name) {
        Page page=null;
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String findPageById="select * from website,page where page.webId=website.id and page.id=?;";
            PreparedStatement pStatement = connection.prepareStatement(findPageById);
            pStatement.setString(1,name);
            results = pStatement.executeQuery();

            if(results.next()) {

                int pageId= results.getInt("id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("updated");
                int views = results.getInt("views");
                int webId=results.getInt("webId");
                page = new Page(pageId,title,description,created,updated,views,webId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
    @Override
    public Collection<Page> findPagesForWebsite(int websiteId) {
        List<Page> pages= new ArrayList<Page>();
        try {
            Connection connection = DBConnection.getConnection();
            String findPagesForWebsite="select * from page where webId=?;";

            PreparedStatement pStatement = connection.prepareStatement(findPagesForWebsite);
            pStatement.setInt(1,websiteId);
            results = pStatement.executeQuery();
            if(results.next()) {
                int id= results.getInt("id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date createdDate = results.getDate("created");
                Date updatedDate = results.getDate("updated");
                int views = results.getInt("views");
                int webId= results.getInt("webId");

                Page page=new Page(id, title,  description,  createdDate,  updatedDate,  views, webId);
                pages.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pages;
    }

    @Override
    public int updatePage(int pageId, Page page) {
        try {
            Connection connection = DBConnection.getConnection();
            String updatePage= "Update page set " +
                    "`id`=\""+page.getWebsiteId()+"\"," +
                    "`title`=\""+page.getTitle()+"\"," +
                    "`description`=\""+page.getDescription()+"\"," +
                    "`created`=\""+page.getCreatedDate()+"\"," +
                    "`updated`=\""+page.getUpdatedDate()+"\"," +
                    "`views`=\""+page.getViews()+"\"," +
                    "`webId`=\""+page.getWebsiteId()+"\""+
                    "where page.id=?;" ;

            System.out.println(updatePage);
            PreparedStatement pStatement = connection.prepareStatement(updatePage);
            pStatement.setInt(1,pageId);
            pStatement.executeUpdate();

            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deletePage(int pageId) {
        try {
            Connection connection = DBConnection.getConnection();

            String deleteWebsite="Delete from page where page.id=?;" ;

            System.out.println(deleteWebsite);
            PreparedStatement pStatement = connection.prepareStatement(deleteWebsite);
            pStatement.setInt(1,pageId);
            pStatement.executeUpdate();

            return 1;
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

