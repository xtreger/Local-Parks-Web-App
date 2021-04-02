package com.exam.project.services;

import com.exam.project.models.PlayAreas;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLParser {

    public List<PlayAreas> parse() {
        List<PlayAreas> list = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("https://data.smartdublin.ie/dataset/3df0c5e3-05e0-477c-904c-9d6afda732a1/resource/dc447994-05e2-4189-b816-fd532d62dab6/download/fccplayareasp20110901-1706.xml");
            NodeList areaList = doc.getElementsByTagName("Play_Areas");
            for (int i = 0; i < areaList.getLength(); i++) {
                Node p = areaList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element area = (Element) p;
                    list.add(
                            new PlayAreas(
                                    area.getElementsByTagName("Name").item(0).getTextContent(),
                                    area.getElementsByTagName("Address1").item(0).getTextContent(),
                                    area.getElementsByTagName("Address2").item(0).getTextContent(),
                                    area.getElementsByTagName("Address3").item(0).getTextContent(),
                                    area.getElementsByTagName("Address4").item(0).getTextContent(),
                                    area.getElementsByTagName("Phone").item(0).getTextContent(),
                                    area.getElementsByTagName("Email").item(0).getTextContent(),
                                    area.getElementsByTagName("Website").item(0).getTextContent(),
                                    area.getElementsByTagName("Type").item(0).getTextContent(),
                                    area.getElementsByTagName("Category").item(0).getTextContent(),
                                    area.getElementsByTagName("Opening_Hours").item(0).getTextContent(),
                                    area.getElementsByTagName("Directions").item(0).getTextContent(),
                                    area.getElementsByTagName("Surface_Type").item(0).getTextContent(),
                                    area.getElementsByTagName("Comments").item(0).getTextContent(),
                                    area.getElementsByTagName("Accessible_Play_Items").item(0).getTextContent(),
                                    area.getElementsByTagName("Disabled_Parking").item(0).getTextContent(),
                                    area.getElementsByTagName("Park_Ranger").item(0).getTextContent(),
                                    area.getElementsByTagName("Toilets").item(0).getTextContent(),
                                    area.getElementsByTagName("Disabled_Toilets").item(0).getTextContent(),
                                    area.getElementsByTagName("Baby_Changing").item(0).getTextContent(),
                                    area.getElementsByTagName("Seating").item(0).getTextContent(),
                                    area.getElementsByTagName("Drinking_Water").item(0).getTextContent(),
                                    area.getElementsByTagName("LAT").item(0).getTextContent(),
                                    area.getElementsByTagName("LONG").item(0).getTextContent()));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
