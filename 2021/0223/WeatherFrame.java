package weather;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherFrame {
    private JFrame frame = new JFrame("날씨 정보 프레임");
    private JButton btn = new JButton("날씨 정보 조회 버튼");
    private JList<Weather> jList = new JList<>();

    public WeatherFrame() {
        frame.add(btn, BorderLayout.NORTH);
        frame.add(jList);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener((e)->{
            WeatherDomParser wdp = new WeatherDomParser();
            ArrayList<Weather> data = wdp.getWeatherData();
            Weather[] tmp = new Weather[data.size()];
            jList.setListData(data.toArray(tmp));
        });
    }

    public static void main(String[] args) {
        WeatherFrame f = new WeatherFrame();
    }

}
