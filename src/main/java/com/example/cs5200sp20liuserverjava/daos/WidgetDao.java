package com.example.cs5200sp20liuserverjava.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.cs5200sp20liuserverjava.DBConnection;
import com.example.cs5200sp20liuserverjava.models.Developer;
import com.example.cs5200sp20liuserverjava.models.Widget;

public class WidgetDao implements WidgetImpl{
    Statement statement = null;
    ResultSet results = null;
    private static WidgetDao instance = null;
    private WidgetDao() {
    }
    public static WidgetDao getInstance() {
        if (instance == null) {
            instance = new WidgetDao();
        }
        return instance;
    }


    @Override
    public void createWidgetForPage(int pageId, Widget widget) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = widget.getWidgetId();
        int page_Id = widget.getPageId();
        String DTYPE = widget.getdType();
        String name = widget.getWidgetName();
        int width = widget.getWidth();
        int height = widget.getHeight();
        String css_class = widget.getCssClass();
        String css_style = widget.getCssStyle();
        String text =widget.getText();
        int order=widget.getOrder();

        try {
            Statement s1 = connection.createStatement();
            Statement s2 = connection.createStatement();
            String sql1 = "Insert into widget VALUES" +
                    "("+id+"," + "\""+page_Id+"\"," + "\""+DTYPE+"\"," +
                    "\""+name +"\"," + "\""+width+"\"," +
                    "\""+height+"\"," + "\""+css_class+"\","+"\""+css_style+"\","+"\""+text+"\","+"\""+order+"\");" ;
            System.out.println(sql1);
            s1.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Widget> findAllWidgets() {
        Collection<Widget> widget= new ArrayList<Widget>();
        try {
            Connection connection =DBConnection.getConnection();
            String findAllWidget="select * from widget; ";

            Statement s1 = connection.createStatement();
            results = s1.executeQuery(findAllWidget);

            while(results.next()) {
                int id= results.getInt("id");
                int page_Id = results.getInt("page_Id");
                String DTYPE= results.getString("DTYPE");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                Widget wid=new Widget(id, DTYPE, page_Id,  name,  width,  height,  css_class, css_style,text,order);
                widget.add(wid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return widget;
    }

    @Override
    public Widget findWidgetById(int widgetId) {
        Widget widget=null;
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String findWidgetById="select * from widget where id=?;";
            PreparedStatement pStatement = connection.prepareStatement(findWidgetById);
            pStatement.setInt(1,widgetId);
            results = pStatement.executeQuery();

            if(results.next()) {
                int id= results.getInt("id");
                int page_Id = results.getInt("page_Id");
                String DTYPE= results.getString("DTYPE");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                widget=new Widget(id, DTYPE, page_Id,  name,  width,  height,  css_class, css_style,text,order);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return widget;
    }

    @Override
    public Widget findWidgetByName(String widgetName) {
        Widget widget=null;
        try {
            Connection connection = null;
            try {
                connection = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String findWidgetById="select * from widget where name=?;";
            PreparedStatement pStatement = connection.prepareStatement(findWidgetById);
            pStatement.setString(1,widgetName);
            results = pStatement.executeQuery();

            if(results.next()) {
                int id= results.getInt("id");
                int page_Id = results.getInt("page_Id");
                String DTYPE= results.getString("DTYPE");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                widget=new Widget(id, DTYPE, page_Id,  name,  width,  height,  css_class, css_style,text,order);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return widget;
    }

    @Override
    public Collection<Widget> findWidgetsForPage(int pageId) {
        List<Widget> widgets= new ArrayList<Widget>();
        try {
            Connection connection = DBConnection.getConnection();

            String findWidgetsForPage="select * from widget where page_id = ?;";
            PreparedStatement pStatement = connection.prepareStatement(findWidgetsForPage);
            pStatement.setInt(1,pageId);
            results = pStatement.executeQuery();
            if(results.next()) {
                int id= results.getInt("id");
                int page_Id = results.getInt("page_Id");
                String DTYPE= results.getString("DTYPE");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                Widget widget=new Widget(id, DTYPE, page_Id,  name,  width,  height,  css_class, css_style,text,order);
                widgets.add(widget);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return widgets;
    }

    @Override
    public int updateWidget(int widgetId, Widget widget) {
        try {
            Connection connection = DBConnection.getConnection();
            String updateWidget= "Update widget" +
                    "`page_Id`=\""+widget.getPageId()+"\"," +
                    "`DTYPE`=\""+widget.getdType()+"\"," +
                    "`name`=\""+widget.getWidgetName()+"\"," +
                    "`width`=\""+widget.getWidth()+"\"," +
                    "`height`=\""+widget.getHeight()+"\"," +
                    "`css_class`=\""+widget.getCssClass()+"\"," +
                    "`css_style`=\""+widget.getCssStyle()+"\"," +
                    "`text`=\""+widget.getText()+"\"," +
                    "orde=\""+widget.getOrder()+"\""+
                    "where page_Id=?;" ;
            System.out.println(updateWidget);
            PreparedStatement pStatement = connection.prepareStatement(updateWidget);
            pStatement.setInt(1,widgetId);
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
    public int deleteWidget(int widgetId) {
        try {
            Connection connection = DBConnection.getConnection();
            String deleteDeveloper="Delete widget from " +
                    " where id=?;" ;
            System.out.println(deleteDeveloper);
            PreparedStatement pStatement = connection.prepareStatement(deleteDeveloper);
            pStatement.setInt(1,widgetId);
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
