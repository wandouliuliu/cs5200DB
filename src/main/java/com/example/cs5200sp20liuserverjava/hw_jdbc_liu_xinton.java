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
        Widget widget1=new Widget(123, "head123", "Welcome",0, 0, 0,"null", 123,"heading");
        Widget widget2=new Widget(234, "post234", "<p>Lorem</p>",0, 0, 0, null, 234,"html");
        Widget widget3=new Widget(345, "head345", "Hi",0, 0, 1,null, 345,"heading");
        Widget widget4=new Widget(456, "intro456", "<h1>Hi</h1>",0, 0, 2,null, 345,"html");
        Widget widget5=new Widget(567, "image 345", null,50, 100, 3,"/img/567.png", 345,"image");
        Widget widget6=new Widget(678, "video 456", null,400, 300, 0, "https://youtu.be/h67VX51QXiQ", 456,"youtube");
        widgetDao.createWidgetForPage(123, widget1);
        widgetDao.createWidgetForPage(234, widget2);
        widgetDao.createWidgetForPage(345, widget3);
        widgetDao.createWidgetForPage(345, widget4);
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
        Developer p=new Developer(12, "alice","alice","Alice","Woder","alice@wonder.com","4321rewq","3334445555");
        developerDao.updateDeveloper(12,p);


        int pageHeadId = 345;

        Collection <Widget> orderWidget = widgetDao.findWidgetsForPage(pageHeadId);
        for(Widget wid : orderWidget)
        {
            int widId = wid.getPageId();
            wid.setOrder(((wid.getOrder()+1)%3)+1);
            widgetDao.updateWidget(widId, wid);
        }

        websiteDao.deleteWebsite(CNET.getWebsiteId());
        Collection<Page> pages = pageDao.findAllPages();
        for(Page page: pages){
            if (page.getPageId()==CNET.getWebsiteId()){
                page.setTitle("CNET"+page.getTitle());
                System.out.println("CNET"+page.getTitle());
                pageDao.updatePage(CNET.getWebsiteId(),page);
            }
        }


        int pageID=0;
       System.out.println( Home.getPageId());

     //   System.out.println(777777777);
//        pageID =Home.getPageId();

        roleDao.deletePageRole(2,pageID,5);
        roleDao.deletePageRole(3, pageID, 3);

        roleDao.assignPageRole(2, pageID, 3);
        roleDao.assignPageRole(3, pageID, 5);


//################################################delete###############################################################
        Developer d=new Developer(12, "alice","alice","Alice","Woder","alice@wonder.com","4321rewq","null");
        developerDao.updateDeveloper(12,d);

        pageDao.deletePage(Wikipedia.getWebsiteId());
//        System.out.println(Wikipedia.getWebsiteId());
//        System.out.println(developerDao);
//        System.out.println(999999999);
        System.out.println(Contact.getPageId());
        int pageId3=Contact.getPageId();
        Collection <Widget> lastWidget = widgetDao.findWidgetsForPage(pageId3);
        int lastOr = 0;
        int lastId = 0;
        System.out.println(lastWidget);
        for(Widget w : lastWidget)
        {
            System.out.println(w.getOrder());
            int or = w.getOrder();

            if (or > lastOr)
            {
                lastId = w.getPageId();
                lastOr = or;
             //   System.out.println(77777);
                System.out.println(lastId);
            }
        }
        //System.out.println(9999999);
        //System.out.println(lastId);

        widgetDao.deleteWidget(lastId);

        Collection <Page> lastPage = pageDao.findPagesForWebsite(Wikipedia.getWebsiteId());

        Date lastUpdate = new Date(0);
        int lastPageId = 0;
        for(Page c : lastPage)
        {
            Date update = (Date) c.getUpdatedDate();

            if(update.after(lastUpdate))
            {  lastUpdate = update;
                lastPageId = c.getPageId();
            }
        }

        pageDao.deletePage(lastPageId);



   }
}

