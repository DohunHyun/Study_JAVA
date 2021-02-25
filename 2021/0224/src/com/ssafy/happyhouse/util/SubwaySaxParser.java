package com.ssafy.happyhouse.util;

import com.ssafy.happyhouse.model.dto.Subway;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.ArrayList;

public class SubwaySaxParser {
    private ArrayList<Subway> sList;
    private String url = "http://openapi.seoul.go.kr:8088/sample/xml/StationAdresTelno/1/5/";

    public ArrayList<Subway> getSubwayData() {
        sList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            SubwayHandler handler = new SubwayHandler();
            sList = handler.getSubways();
            parser.parse(new URL(url).openConnection().getInputStream(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sList;
    }

}
