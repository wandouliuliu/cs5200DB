package com.example.cs5200sp20liuserverjava.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.example.cs5200sp20liuserverjava.DBConnection;


public class PriviledgeDao implements PriviledgeImpl{

    Statement statement = null;
    ResultSet results = null;
    private static PriviledgeDao instance = null;
    PriviledgeDao() {
    }
    public static PriviledgeDao getInstance() {
        if (instance == null) {
            instance = new PriviledgeDao();
        }
        return instance;
    }
    @Override
    public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement s1 = connection.createStatement();
            String assignWebsitePrivilege = "Insert into priviledge (developer_id, privilege_name, website_id)" +
                    "VALUES\r\n" +
                    "("+developerId+"," +
                    "\""+priviledge+"\"," +
                    +websiteId+"" +
                    ");" ;
            System.out.println(assignWebsitePrivilege);
            s1.executeUpdate(assignWebsitePrivilege);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO Auto-generated method stub

    }
    @Override
    public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement s1 = connection.createStatement();
            String assignPagePrivilege = "Insert into priviledge (developer_id, privilege, page_id)\r\n" +
                    "VALUES" +
                    "("+developerId+"," +
                    "\""+priviledge+"\"," +
                    +pageId+"" +
                    ");" ;
            System.out.println(assignPagePrivilege);
            s1.executeUpdate(assignPagePrivilege);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
        try {
            Connection connection = DBConnection.getConnection();

            String deleteWebsitePrivilege="Delete from website_privilege" +
                    " where website_id=? and developer_id=? and privilege_name = ?;\r\n" ;

            System.out.println(deleteWebsitePrivilege);
            PreparedStatement pStatement = connection.prepareStatement(deleteWebsitePrivilege);
            pStatement.setInt(1,websiteId);
            pStatement.setInt(2,developerId);
            //System.out.println(P.getValue(roleId).toString());
            pStatement.setString(3,priviledge);

            pStatement.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
        try {
            Connection connection = DBConnection.getConnection();

            String deletePagePrivilege="Delete from page_privilege" +
                    " where page_id=? and developer_id=? and priviledge = ?;\r\n" ;

            System.out.println(deletePagePrivilege);
            PreparedStatement pStatement = connection.prepareStatement(deletePagePrivilege);
            pStatement.setInt(1,pageId);
            pStatement.setInt(2,developerId);
            //System.out.println(P.getValue(roleId).toString());
            pStatement.setString(3,priviledge);

            pStatement.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
