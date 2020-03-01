package com.example.cs5200sp20liuserverjava.daos;

import com.example.cs5200sp20liuserverjava.models.Website;
import com.example.cs5200sp20liuserverjava.DBConnection;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

public class WebsiteDao implements WebsiteImpl {
    Statement statement =null;
    ResultSet results =null;
    private static  WebsiteDao instance= null;
    private WebsiteDao(){}
    public static WebsiteDao getInstance(){
        if(instance==null){
            instance = new WebsiteDao();
        }
        return instance;
    }

    @Override
    public void createWebsiteForDeveloper(int developerId, Website website) {
        Connection connection=null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = website.getWebsiteId();
        String websiteName = website.getWebsiteName();
        String description = website.getDescription();
        Date created = website.getCreatedDate();
        Date updated = website.getUpdatedDate();
        int visits=website.getVisits();

        try{
            Statement s1 = connection.createStatement();
            String sql ="Insert into website VALUE"+
                    "("+id+"," +
                    "\""+websiteName+"\"," +
                    "\""+description+"\"," +
                    "\""+created+"\"," +
                    "\""+updated+"\"," +
                    "\""+visits+"\");" ;
            s1.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<Website> findAllWebsites() {
        Collection<Website> websites = new ArrayList<Website>();
        try {
            Connection connection =DBConnection.getConnection();
            String findAllWebsites="select * from website";

            Statement s1 = connection.createStatement();
            results = s1.executeQuery(findAllWebsites);

            while(results.next()) {
                int id= results.getInt("id");
                String websiteName = results.getString("websiteName");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("updated");
                int visits = results.getInt("visits");
                int devId=results.getInt("devId");
                Website web=new Website(id,websiteName,description,created,updated,visits,devId);
                websites.add(web);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return websites;
    }

    @Override
    public Collection<Website> findWebsitesForDeveloper(int devId) {
        List<Website> websites= new ArrayList<Website>();
        try {
            Connection connection = DBConnection.getConnection();
            String findWebsitesForDeveloper="select * from website where devId=?;";

            PreparedStatement pStatement = connection.prepareStatement(findWebsitesForDeveloper);
            pStatement.setInt(1,devId);
            results = pStatement.executeQuery();
            if(results.next()) {
                int id= results.getInt("id");
                String websiteName = results.getString("websiteName");
                String description = results.getString("description");
                Date createdDate = results.getDate("created");
                Date updatedDate = results.getDate("updated");
                int visits = results.getInt("visits");
                int DevId= results.getInt("devId");

                Website website=new Website(id,  websiteName,  description,  createdDate,  updatedDate,  visits, DevId);
                websites.add(website);
                //s1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return websites;

    }

    @Override
    public Website findWebsiteById(int id) {
        Website website=null;
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String findDeveloperById="select * from website,developer where website.devId=developer.id and website.id=?;";
            PreparedStatement pStatement = connection.prepareStatement(findDeveloperById);
            pStatement.setInt(1,id);
            results = pStatement.executeQuery();

            if(results.next()) {

                int webId= results.getInt("id");
                String websiteName = results.getString("websiteName");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("updated");
                int visits = results.getInt("visits");
                int devId=results.getInt("devId");
                website=new Website(webId,websiteName,description,created,updated,visits,devId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return website;
    }

    @Override
    public int updateWebsite(int websiteId, Website website) {
        try {
            Connection connection = DBConnection.getConnection();
            String updateWebsite= "Update website set " +
                    "`id`=\""+website.getWebsiteId()+"\"," +
                    "`websiteName`=\""+website.getWebsiteName()+"\"," +
                    "`description`=\""+website.getDescription()+"\"," +
                    "`created`=\""+website.getCreatedDate()+"\"," +
                    "`updated`=\""+website.getUpdatedDate()+"\"," +
                    "`visits`=\""+website.getVisits()+"\"," +
                    "devId=\""+website.getDeveloper_id()+"\""+
                    "where website.id=?;" ;

            System.out.println(updateWebsite);
            PreparedStatement pStatement = connection.prepareStatement(updateWebsite);
            pStatement.setInt(1,websiteId);
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
    public int deleteWebsite(int websiteId) {
        try {
            Connection connection = DBConnection.getConnection();

            String deleteWebsite="Delete from website where website.id=?;" ;

            System.out.println(deleteWebsite);
            PreparedStatement pStatement = connection.prepareStatement(deleteWebsite);
            pStatement.setInt(1,websiteId);
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



