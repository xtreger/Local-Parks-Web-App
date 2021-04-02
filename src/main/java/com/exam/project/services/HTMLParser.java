package com.exam.project.services;

import com.exam.project.models.DublinPark;
import com.exam.project.models.DunLaoghairePark;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HTMLParser {


    private static final String WEBSITE = "https://www.dublincity.ie/residential/parks/dublin-city-parks/visit-park?facilities=All&keys=&page=";
    private static final String DUBLIN = "https://www.dublincity.ie/";
    private static final String DUNLAOGHAIRE1 = "https://www.dlrcoco.ie/en/parks-and-outdoors/parks/";
    private static final String DUNLAOGHAIRE2 = "https://www.dlrcoco.ie";
    private static final String WIKIPEDIA = "https://en.wikipedia.org/wiki/List_of_Dublin_postal_districts";
    private static final String CLASSNAME = "field field--name-title field--type-string field--label-hidden";
    private static final String CLASSDESCRIPTION = "field__item";
    private static final String CLASSOPENINGHOURSWEEK = "opening-times__week";
    private static final String CLASSOPENINGHOURSMONTH = "opening-times opening-times__txt";
    private static final String CLASSPHONE = "field field--name-field-location-phone field--type-telephone field--label-hidden";
    private static final String CLASSFACILITIES = "full__facilities location__facilities text";
    private static final String CLASSACCESSIBILITY = "clearfix text-formatted field field--name-field-accessibility-features field--type-text-long field--label-hidden";
    private static final String CLASSADDRESS = "location__address";
    private static final String DUNNAME = "page-header white";
    private static final String DUNNAME2 = "page-header";
    private static final String DUNDESCRIPTION = "field-name-body";
    private static final String DUNOPENINGHOURS = "field field-name-field-opening-hours field-type-field-collection field-label-above";
    private static final String DUNDIRECTIONS = "field field-name-field-address field-type-text-long field-label-above";
    private static final String DUNFACILITIES = "views-field views-field-field-facility-details";
    private static final String DUNGET = "views-field views-field-field-steps";

    public DublinPark getDublinParkDetails(String link) {
        DublinPark dublinPark = new DublinPark();
        Document document = null;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("Could not retrieve page.");
        }

        assert document != null;
        Elements elements = document.getElementsByClass(CLASSNAME);
        dublinPark.setName(elements.first().text());

        elements = document.getElementsByClass(CLASSDESCRIPTION);
        dublinPark.setDescription(elements.first().text());

        elements = document.getElementsByClass(CLASSOPENINGHOURSWEEK);
        dublinPark.setOpeningHoursWeek(elements.text());

        elements = document.getElementsByClass(CLASSOPENINGHOURSMONTH);
        String hoursMonth = elements.text().replace("Opening Hours", "");
        dublinPark.setOpeningHoursMonth(hoursMonth);

        elements = document.getElementsByClass(CLASSPHONE);
        dublinPark.setPhone(elements.text());

        //Tried very very hard to decode but couldn't
        dublinPark.setEmail("parks@dublincity.ie");

        elements = document.getElementsByClass(CLASSFACILITIES);
        String facilitiesString = elements.text().replace("Facilities ", "");
        dublinPark.setFacilities(facilitiesString);

        elements = document.getElementsByClass(CLASSACCESSIBILITY);
        String accessibilityString = elements.text().replace("Accessibility ", "");
        dublinPark.setAccessibility(accessibilityString);

        elements = document.getElementsByClass(CLASSADDRESS);
        String addressString = elements.text().replace("Address ", "");

        elements = document.getElementsByClass("locality");
        String locality = elements.first().text();
        if (locality.equals("Dublin")) {
            elements = document.getElementsByClass("dependent-locality");
            addressString = addressString.replaceFirst("Dublin", getPostCode(elements.text()));
        }

        dublinPark.setAddress(addressString);

        System.out.println(dublinPark);

        return dublinPark;
    }

    public String getPostCode(String s) {
        Document document = null;
        try {
            document = Jsoup.connect(WIKIPEDIA).get();
        } catch (Exception ex) {
            System.out.println("Could not retrieve page.");
        }

        assert document != null;
        Elements elements = document.select("div.mw-parser-output > ul > li");
        for (Element element : elements) {
            String area = element.select("li").text();
            if (area.contains(s))
                return area.split(" ")[0] + " " + area.split(" ")[1];
        }

        return "Dublin";
    }


    public List<DublinPark> dublinParksList() {
        List<DublinPark> dublinParkList = new ArrayList<>();
        List<String> dublinLinks = getDublinLinks();
        for (String dublinLink : dublinLinks) {
            dublinParkList.add(getDublinParkDetails(dublinLink));
        }

        return dublinParkList;
    }

    public List<String> getDublinLinks() {
        List<String> list = new ArrayList<>();
        Document document = null;

        for (int i = 0; i < 4; i++) {
            try {
                document = Jsoup.connect(WEBSITE + i).get();
            } catch (IOException ignored) {
                System.out.println("Could not Scan for pages.");
            }

            assert document != null;
            Elements elements = document.getElementsByClass("search-result__link");
            for (Element element : elements) {
                String link = DUBLIN + element.attributes().get("href");
                list.add(link);
            }
        }

        return list;
    }

    public List<String> getDunLaoghaireLinks() {
        List<String> list = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect(DUNLAOGHAIRE1).get();
        } catch (IOException ignored) {
            System.out.println("Could not Scan for pages.");
        }

        assert document != null;
        Elements elements = document.getElementsByClass("image-block-link-flagship");
        for (Element element : elements) {
            String link = DUNLAOGHAIRE2 + element.attributes().get("href");
            list.add(link);
        }


        return list;
    }

    public DunLaoghairePark getDunLaoghaireParkDetails(String link) {
        DunLaoghairePark dunLaoghairePark = new DunLaoghairePark();
        Document document = null;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("Could not retrieve page.");
        }

        assert document != null;

        Elements elements = document.getElementsByClass(DUNNAME);
        if (elements.isEmpty())
            elements = document.getElementsByClass(DUNNAME2);
        dunLaoghairePark.setName(elements.text());

        elements = document.getElementsByClass(DUNDESCRIPTION);
        dunLaoghairePark.setDescription(elements.text());

        elements = document.getElementsByClass(DUNOPENINGHOURS);
        String openingString = elements.text().replace("Opening Hours  ", "");
        dunLaoghairePark.setOpeningHours(openingString);

        elements = document.getElementsByClass(DUNDIRECTIONS);
        String directionsString = elements.text().replace("Address  ", "");
        dunLaoghairePark.setDirections(directionsString);

        elements = document.getElementsByClass(DUNFACILITIES);
        dunLaoghairePark.setFacilities(elements.text());

        elements = document.getElementsByClass(DUNGET);
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0)
                dunLaoghairePark.setBus(elements.get(i).text());
            else if (i == 1)
                dunLaoghairePark.setCar(elements.get(i).text());
            else
                dunLaoghairePark.setDart(elements.get(i).text());
        }
        System.out.println(dunLaoghairePark.toString());
        return dunLaoghairePark;

    }

    public List<DunLaoghairePark> dunLaoghaireParkList() {
        List<DunLaoghairePark> dunLaoghaireParks = new ArrayList<>();
        List<String> dunLaoghaireLinks = getDunLaoghaireLinks();
        System.out.println(dunLaoghaireLinks.toString());
        for (String dunLaoghaireLink : dunLaoghaireLinks) {
            dunLaoghaireParks.add(getDunLaoghaireParkDetails(dunLaoghaireLink));
        }


        return dunLaoghaireParks;
    }

}
