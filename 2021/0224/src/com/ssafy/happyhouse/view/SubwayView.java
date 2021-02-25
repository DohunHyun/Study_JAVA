package com.ssafy.happyhouse.view;

import com.ssafy.happyhouse.model.dto.Subway;
import com.ssafy.happyhouse.util.SubwaySaxParser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubwayView {
    private JFrame frame = new JFrame("지하철 정보 프레임");
    private JButton btn = new JButton("지하 정보 조회 버튼");
    private JList<Subway> jList = new JList<>();

//    public SubwayView() {
//        frame.add(btn, BorderLayout.NORTH);
//        frame.add(jList);
//        frame.setSize(400,500);
//        frame.setVisible(true);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        btn.addActionListener((e)->{
//            SubwaySaxParser wdp = new SubwaySaxParser();
//            ArrayList<Subway> data = wdp.getSubwayData();
//            Subway[] tmp = new Subway[data.size()];
//            jList.setListData(data.toArray(tmp));
//        });
//    }

    public SubwayView(String dong) {
        frame.add(btn, BorderLayout.NORTH);
        frame.add(jList);
        frame.setSize(400,500);
        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener((e)->{
            SubwaySaxParser wsp = new SubwaySaxParser();
            ArrayList<Subway> data = wsp.getSubwayData();
            Subway[] tmp = new Subway[data.size()];
            jList.setListData(data.toArray(tmp));
        });
    }

}
