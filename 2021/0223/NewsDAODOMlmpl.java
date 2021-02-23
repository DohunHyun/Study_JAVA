package com.ssafy.news;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsDAODOMlmpl implements INewsDAO {
    List<News> list = new ArrayList<>();

    @Override
    public List<News> getNewsList(String url) {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = f.newDocumentBuilder();
            Document dom = parser.parse(new URL(url).openConnection().getInputStream());
            Element root = dom.getDocumentElement();
            NodeList dataNodes = root.getElementsByTagName("item");

            for(int i=0; i<dataNodes.getLength(); i++) {
                News news = new News();
                Node data = dataNodes.item(i);

                NodeList dataChilds = data.getChildNodes();
                for(int j=0; j<dataChilds.getLength(); j++) {
                    Node child = dataChilds.item(j);
                    String tname = child.getNodeName();

                    if(tname.equals("title")) {
                        news.setTitle(child.getFirstChild().getNodeValue());
                    } else if(tname.equals("link")) {
                        news.setLink(child.getFirstChild().getNodeValue());
                    } else if(tname.equals("description")) {
                        news.setDesc(child.getFirstChild().getNodeValue());
                    }
                }
                list.add(news);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public News search(int index) {
        return null;
    }

    private void connectNews(String url) {

    }

    public static class SAXHandler {
    }
}
