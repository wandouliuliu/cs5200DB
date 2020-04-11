package com.example.cs5200sp20liuserverjava;

import com.example.cs5200sp20liuserverjava.daos.*;
import com.example.cs5200sp20liuserverjava.models.Developer;
import com.example.cs5200sp20liuserverjava.models.Page;
import com.example.cs5200sp20liuserverjava.models.Website;
import com.example.cs5200sp20liuserverjava.models.Widget;

import java.text.ParseException;
import java.util.Calendar;
import java.sql.Date;
import java.util.Collection;

public class hw_jdbc_liu_xinton {
    public static void main (String[] args) throws ParseException
    {
        DeveloperDao developerDao = DeveloperDao.getInstance();
        WebsiteDao websiteDao = WebsiteDao.getInstance();

        //################################################INSERT###########################

        Developer alice = new Developer(12, "alice","alice","Alice","Woder","alice@wonder.com","4321rewq");
        Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", "5432trew");
        Developer charlie = new Developer(34, "charlie", "charlie", "Charles", "Garcia", "chuch@garcia.com", "6543ytre");
        Developer dan = new Developer(45, "dan", "dan", "Dan", "Martin", "dan@martin.com", "7654fda");
        Developer ed = new Developer(56, "ed", "ed", "Ed", "Karaz", "ed@kar.com", "5678dfgh");

        developerDao.createDeveloper(alice);
        developerDao.createDeveloper(bob);
        developerDao.createDeveloper(charlie);
        developerDao.createDeveloper(dan);
        developerDao.createDeveloper(ed);



        Date date = Date.valueOf("2020-02-27");
        Website Facebook=new Website(123,"Facebook","an online social media and social networking service",date,date,1234234,12);
        Website Twitter=new Website(234,"Twitter","an online news and social networking service",date,date,4321543,23);
        Website Wikipedia=new Website(345,"Wikipedia","a free online encyclopedia",date,date,3456654,34);
        Website CNN=new Website(456,"CNN","an American basic cable and satellite television news channel",date,date,6543345,12);
        Website CNET=new Website(567,"CNET","an American media website that publishes reviews, news, articles, blogs, podcasts and videos on chnology and consumer electronics",date,date,5433455,23);
        Website Gizmodo=new Website(678,"Gizmodo","a design, technology, science and science fiction website that also writes articles on litics",date,date,4322345,34);
        websiteDao.createWebsiteForDeveloper(12,Facebook);
        websiteDao.createWebsiteForDeveloper(23,Twitter);
        websiteDao.createWebsiteForDeveloper(34,Wikipedia);
        websiteDao.createWebsiteForDeveloper(12,CNN);
        websiteDao.createWebsiteForDeveloper(23,CNET);
        websiteDao.createWebsiteForDeveloper(34,Gizmodo);





        Calendar calendar = Calendar.getInstance();
        Date date1 = new Date(calendar.getTime().getTime());
        Date date2 = Date.valueOf("2020-02-27");

        PageDao pageDao = PageDao.getInstance();
        Page Home=new Page(123,"Home","Landing page",date1,date2,1234234,567);
        Page About=new Page(234,"About","Website description",date1,date2,234545,678);
        Page Contact=new Page(345,"Contact","Addresses, phones, and contact info",date1,date2,345656,345);
        Page Preferences=new Page(456,"Preferences","Where users can configure their preferences",date1,date2,456776,456);
        Page profile=new Page(567,"Profile","Users can configure their personal information",date1,date2,567878,567);
        pageDao.createPageForWebsite(567, Home);
        pageDao.createPageForWebsite(678, About);
        pageDao.createPageForWebsite(345, Contact);
        pageDao.createPageForWebsite(456, Preferences);
        pageDao.createPageForWebsite(567, profile);


        WidgetDao widgetDao = WidgetDao.getInstance();
        Widget widget1=new Widget(1, "head123", "Welcome",0, 0, 0,"null", 123,"heading");
        Widget widget2=new Widget(2, "post234", "<p>Lorem</p>",0, 0, 0, null, 234,"html");
        Widget widget3=new Widget(3, "head345", "Hi",0, 0, 1,null, 345,"heading");
        Widget widget4=new Widget(4, "intro456", "<h1>Hi</h1>",0, 0, 2,null, 345,"html");
        Widget widget5=new Widget(5, "image 345", null,50, 100, 3,"/img/567.png", 345,"image");
        Widget widget6=new Widget(6, "video 456", null,400, 300, 0, "https://youtu.be/h67VX51QXiQ", 456,"youtube");
        widgetDao.createWidgetForPage(123, widget1);
        widgetDao.createWidgetForPage(234, widget2);
        widgetDao.createWidgetForPage(345, widget3);
        widgetDao.createWidgetForPage(456, widget4);
        widgetDao.createWidgetForPage(345, widget5);
        widgetDao.createWidgetForPage(456, widget6);

        RoleDao roleDao = RoleDao.getInstance();
        roleDao.assignWebsiteRole(12, 123, 1);
        roleDao.assignWebsiteRole(23, 123, 4);
        roleDao.assignWebsiteRole(34, 123, 2);
        roleDao.assignWebsiteRole(23, 234, 1);
        roleDao.assignWebsiteRole(34, 234, 4);
        roleDao.assignWebsiteRole(12, 234, 2);
        roleDao.assignWebsiteRole(34, 345, 1);
        roleDao.assignWebsiteRole(12, 345, 4);
        roleDao.assignWebsiteRole(23, 345, 2);
        roleDao.assignWebsiteRole(12, 456, 1);
        roleDao.assignWebsiteRole(23, 456, 4);
        roleDao.assignWebsiteRole(34, 456, 2);
        roleDao.assignWebsiteRole(23, 567, 1);
        roleDao.assignWebsiteRole(34, 567, 4);
        roleDao.assignWebsiteRole(12, 567, 2);
        roleDao.assignWebsiteRole(34, 678, 1);
        roleDao.assignWebsiteRole(12, 678, 4);
        roleDao.assignWebsiteRole(23, 678, 2);


        roleDao.assignPageRole(12, 123, 4);
        roleDao.assignPageRole(23, 123, 5);
        roleDao.assignPageRole(34, 123, 3);
        roleDao.assignPageRole(23, 234, 4);
        roleDao.assignPageRole(34, 234, 5);
        roleDao.assignPageRole(12, 234, 3);
        roleDao.assignPageRole(34, 345, 4);
        roleDao.assignPageRole(12, 345, 5);
        roleDao.assignPageRole(23, 345, 3);
        roleDao.assignPageRole(12, 456, 4);
        roleDao.assignPageRole(23, 456, 5);
        roleDao.assignPageRole(34, 456, 3);
        roleDao.assignPageRole(23, 567, 4);
        roleDao.assignPageRole(34, 567, 5);
        roleDao.assignPageRole(12, 567, 3);


        //###############################update######################################

        //Update developer - Update Charlie's primary phone number to 333-444-5555
        Developer p=new Developer(34, "charlie","charlie","Charles","Garcia","chuch@garcia.com","6543ytre","3334445555");
        developerDao.updateDeveloper(34,p);


        //Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well
        Collection <Widget> orderWidget = widgetDao.findAllWidgets();
        for(Widget wid : orderWidget)
        {

            int widId = wid.getWidgetId();
            wid.setOrder(wid.getOrder()+2);
            widgetDao.updateWidget(widId,wid);
        }

        //Update page - Append 'CNET - ' to the beginning of all CNET's page titles

        Collection<Page> pages = pageDao.findAllPages();
        for(Page page: pages){
            if (page.getTitle().equals("Home")||page.getTitle().equals("Profile")){
                page.setTitle("CNET"+page.getTitle());
                pageDao.updatePage(page.getPageId(),page);

            }
        }


       // Update roles - Swap Charlie's and Bob's role in CNET's Home page

        int pageID=0;
        pageID =Home.getPageId();

        roleDao.deletePageRole(34,pageID,3);
        roleDao.deletePageRole(23, pageID, 5);

        roleDao.assignPageRole(34, pageID, 5);
        roleDao.assignPageRole(23, pageID, 3);


//################################################delete###############################################################

        //Delete developer - Delete Alice's primary address
        Developer d=new Developer(12, "alice","alice","Alice","Woder","alice@wonder.com","4321rewq","null");
        developerDao.updateDeveloper(12,d);
//
        //Delete widget - Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
        Collection <Widget> deleteWidget = widgetDao.findAllWidgets();
        int order=0;
        int w=0;
        for(Widget wid : deleteWidget)
        {
            if(wid.getOrder()>order){
                order=wid.getOrder();
                w=wid.getWidgetId();
            }
        }
        widgetDao.deleteWidget(w);

        //Delete page - Remove the last updated page in Wikipedia
        Collection <Page> deletepage = pageDao.findAllPages();
        for(Page page: deletepage){
            if(page.getPageId()==345){
                pageDao.deletePage(page.getPageId());
            }
        }

        //Delete website - Remove the CNET web site, as well as all related roles and privileges relating developers to the Website and Pages
        System.out.println(CNET.getWebsiteId());
        websiteDao.deleteWebsite(CNET.getWebsiteId());
        for(int i=1;i<=5;i++){
            roleDao.deletePageRole(12,CNET.getWebsiteId(),i);
            roleDao.deletePageRole(23,CNET.getWebsiteId(),i);
            roleDao.deletePageRole(34,CNET.getWebsiteId(),i);
            roleDao.deletePageRole(45,CNET.getWebsiteId(),i);
            roleDao.deletePageRole(56,CNET.getWebsiteId(),i);
            roleDao.deleteWebsiteRole(12,CNET.getWebsiteId(),i);
            roleDao.deleteWebsiteRole(23,CNET.getWebsiteId(),i);
            roleDao.deleteWebsiteRole(34,CNET.getWebsiteId(),i);
            roleDao.deleteWebsiteRole(45,CNET.getWebsiteId(),i);
            roleDao.deleteWebsiteRole(56,CNET.getWebsiteId(),i);
        }



   }
}

