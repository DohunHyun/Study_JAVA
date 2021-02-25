package com.ssafy.happyhouse.util;

import com.ssafy.happyhouse.model.dto.Subway;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class SubwayHandler extends DefaultHandler {
    private Subway subway;
    private StringBuilder sb;
    private ArrayList<Subway> subways;

    public SubwayHandler() {
        subways = new ArrayList<Subway>();
    }

    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        sb = new StringBuilder();

        if(qName.equals("row")) {
            subway = new Subway();
            subways.add(subway);
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if(subway != null) {
            if(qName.equals("LINE")) {
                subway.setLine(sb.toString());
            } else if(qName.equals("STATN_NM")) {
                subway.setStation_name(sb.toString());
            } else if(qName.equals("ADRES")) {
                subway.setAddress(sb.toString());
            } else if(qName.equals("RDNMADR")) {
                subway.setRdnmAddress(sb.toString());
            } else if(qName.equals("TELNO")) {
                subway.setTelNo(sb.toString());
            }
        }
    }

    public ArrayList<Subway> getSubways() {return subways;}
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        sb.append(ch, start, length);
    }



}
