package com.ssafy.news;

import java.util.List;
import java.util.jar.Attributes;

public class NewsDAOSAXlmpl implements INewsDAO{
    List<News> list;

    @Override
    public List<News> getNewsList(String url) {
        return null;
    }

    @Override
    public News search(int index) {
        return null;
    }

    private void connectNews(String url) {

    }

    class SAXHandler {
        StringBuilder b;
        boolean flag;
        News n;

        public void startElement(String url, String localName, String qName, Attributes attributes) {

        }

        public void characters(char[] ch, int start, int length) {

        }

        public void endElement(String url, String localName, String qName) {

        }
    }

}
