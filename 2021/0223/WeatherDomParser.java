package weather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;

public class WeatherDomParser {
    ArrayList<Weather> wList = new ArrayList<>();
    String url = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";

    public ArrayList<Weather> getWeatherData() {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = f.newDocumentBuilder();
            Document dom = parser.parse(new URL(url).openConnection().getInputStream());
            Element root = dom.getDocumentElement();
            NodeList dataNodes = root.getElementsByTagName("data");

            for(int i=0; i<dataNodes.getLength(); i++) {
                Weather weather = new Weather();
                Node data = dataNodes.item(i);

                NodeList dataChilds = data.getChildNodes();
                for(int j=0; j<dataChilds.getLength(); j++) {
                    Node child = dataChilds.item(j);
                    String tname = child.getNodeName();

                    if(tname.equals("tmEf")) {
                        weather.setData(child.getFirstChild().getNodeValue());
                    } else if(tname.equals("tmn")) {
                        weather.setTmn(child.getFirstChild().getNodeValue());
                    } else if(tname.equals("tmx")) {
                        weather.setTmx(child.getFirstChild().getNodeValue());
                    } else if(tname.equals("wf")) {
                        weather.setWf(child.getFirstChild().getNodeValue());
                    }
                }
                wList.add(weather);
            }
        } catch (Exception e) {
            System.out.println("돔 파서 에러 ");
            e.printStackTrace();
        }

        return wList;
    }
}
