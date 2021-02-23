package com.ssafy.news;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewsMain {
    JFrame f;
    JButton b;
    JList li;
    JTextArea ta;
    INewsDAO dao;
    News[] tmp;
    ListSelectionListener lisenter = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            News n = (News)li.getSelectedValue();
            ta.setText(n.getDesc());
        }
    };

    public NewsMain() {
        dao = new NewsDAODOMlmpl();
        createGUI();
        addEvent();
//        showList();
    }

    public void createGUI() {
        f = new JFrame("NewsList");
        JPanel p = new JPanel();
        b = new JButton("News List 호출");
        li = new JList();
        ta = new JTextArea("");
        ta.setLineWrap(true);
        p.setLayout(new BorderLayout());
        p.add(b, "North");
        p.add(li);
        f.setLayout(new GridLayout(2,1,5,5));
        f.add(p);
        f.add(ta);
        f.setSize(400,500);
        f.setVisible(true);
    }

    public void addEvent() {
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
//        li.addListSelectionListener(new ListSelectionListener() {
////            @Override
////            public void valueChanged(ListSelectionEvent e) {
////                News n = (News)li.getSelectedValue();
////                ta.setText(n.getDesc());
////            }
////        });
        li.addListSelectionListener(lisenter);
    }

    public void showList() {
        java.util.List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
        li.removeListSelectionListener(lisenter);
        li.removeAll();
        tmp = new News[datas.size()];
        li.setListData(datas.toArray(tmp));
        li.addListSelectionListener(lisenter);
    }

    public static void main(String[] args) {
        new NewsMain();
    }
}
