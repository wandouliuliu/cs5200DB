package com.example.cs5200sp20liuserverjava.daos;
import com.example.cs5200sp20liuserverjava.models.Widget;
import java.util.Collection;



public interface WidgetImpl {

    void createWidgetForPage(int pageId, Widget widget);
    Collection<Widget> findAllWidgets();
    Widget findWidgetById(int widgetId);
    Widget findWidgetByName(String name);
    Collection<Widget> findWidgetsForPage(int pageId);
    int updateWidget(int widgetId, Widget widget);
    int deleteWidget(int widgetId);


}
