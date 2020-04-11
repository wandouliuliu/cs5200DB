package com.example.cs5200sp20liuserverjava.daos;

import com.example.cs5200sp20liuserverjava.DBConnection;
import com.example.cs5200sp20liuserverjava.models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RoleDao implements RoleImpl {

    Statement statement = null;
    ResultSet results = null;
    private static RoleDao instance = null;
    private RoleDao() {
    }
    public static RoleDao getInstance() {
        if (instance == null) {
            instance = new RoleDao();
        }
        return instance;
    }

    PriviledgeDao privDao=new PriviledgeDao();

    @Override
    public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
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
            String assignWebsiteRole = "Insert into website_role (developer_id, role_name, website_id)" +
                    "VALUES" +
                    "("+developerId+"," +
                    "\""+Role.getValue(roleId)+"\"," +
                    +websiteId+"" +
                    ");" ;
            System.out.println(assignWebsiteRole);
            s1.executeUpdate(assignWebsiteRole);

            if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
                privDao.assignWebsitePriviledge(developerId, websiteId, "create");
                privDao.assignWebsitePriviledge(developerId, websiteId, "read");
                privDao.assignWebsitePriviledge(developerId, websiteId, "update");
                privDao.assignWebsitePriviledge(developerId, websiteId, "delete");
            }
            else if(Role.getValue(roleId).toString().equals("writer")) {
                privDao.assignWebsitePriviledge(developerId, websiteId, "create");
                privDao.assignWebsitePriviledge(developerId, websiteId, "read");
                privDao.assignWebsitePriviledge(developerId, websiteId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("editor")) {
                privDao.assignWebsitePriviledge(developerId, websiteId, "read");
                privDao.assignWebsitePriviledge(developerId, websiteId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("reviewer")) {
                privDao.assignWebsitePriviledge(developerId, websiteId, "read");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }



    }



    @Override
    public void assignPageRole(int developerId, int pageId, int roleId) {
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
            String assignPageRole = "Insert into page_role (developer_id, role, page_id)\r\n" +
                    "VALUES\r\n" +
                    "("+developerId+",\r\n" +
                    "\""+Role.getValue(roleId)+"\",\r\n" +
                    +pageId+"\r\n" +
                    ");\r\n" ;
            System.out.println(assignPageRole);
            s1.executeUpdate(assignPageRole);

            if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
                privDao.assignPagePriviledge(developerId, pageId, "create");
                privDao.assignPagePriviledge(developerId, pageId, "read");
                privDao.assignPagePriviledge(developerId, pageId, "update");
                privDao.assignPagePriviledge(developerId, pageId, "delete");
            }
            else if(Role.getValue(roleId).toString().equals("writer")) {
                privDao.assignPagePriviledge(developerId, pageId, "create");
                privDao.assignPagePriviledge(developerId, pageId, "read");
                privDao.assignPagePriviledge(developerId, pageId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("editor")) {
                privDao.assignPagePriviledge(developerId, pageId, "read");
                privDao.assignPagePriviledge(developerId, pageId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("reviewer")) {
                privDao.assignPagePriviledge(developerId, pageId, "read");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    @Override
    public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String deleteWebsiteRole="Delete from website_role" +
                    " where website_id=? and developer_id=? and role_name = ?;\r\n" ;

            System.out.println(deleteWebsiteRole);
            PreparedStatement pStatement = connection.prepareStatement(deleteWebsiteRole);
            pStatement.setInt(1,websiteId);
            pStatement.setInt(2,developerId);
            System.out.println(Role.getValue(roleId).toString());
            pStatement.setString(3,Role.getValue(roleId).toString());

            pStatement.executeUpdate();
            if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
                privDao.deleteWebsitePriviledge(developerId, websiteId,"create");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "delete");
            }
            else if(Role.getValue(roleId).toString().equals("writer")) {
                privDao.deleteWebsitePriviledge(developerId, websiteId, "create");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("editor")) {
                privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
                privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("reviewer")) {
                privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void deletePageRole(int developerId, int pageId, int roleId) {
        try {
            Connection connection = DBConnection.getConnection();

            String deletePageRole="Delete from page_role" +
                    " where page_id=? and developer_id=? and role = ?;\r\n" ;

            System.out.println(deletePageRole);
            PreparedStatement pStatement = connection.prepareStatement(deletePageRole);
            pStatement.setInt(1,pageId);
            pStatement.setInt(2,developerId);
            System.out.println(Role.getValue(roleId).toString());
            pStatement.setString(3,Role.getValue(roleId).toString());

            pStatement.executeUpdate();

            if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
                privDao.deletePagePriviledge(developerId, pageId,"create");
                privDao.deletePagePriviledge(developerId, pageId, "read");
                privDao.deletePagePriviledge(developerId, pageId, "update");
                privDao.deletePagePriviledge(developerId, pageId, "delete");
            }
            else if(Role.getValue(roleId).toString().equals("writer")) {
                privDao.deletePagePriviledge(developerId, pageId, "create");
                privDao.deletePagePriviledge(developerId, pageId, "read");
                privDao.deletePagePriviledge(developerId, pageId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("editor")) {
                privDao.deletePagePriviledge(developerId, pageId, "read");
                privDao.deletePagePriviledge(developerId, pageId, "update");
            }
            else if(Role.getValue(roleId).toString().equals("reviewer")) {
                privDao.deletePagePriviledge(developerId, pageId, "read");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
