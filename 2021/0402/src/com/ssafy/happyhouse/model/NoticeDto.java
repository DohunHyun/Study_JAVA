package com.ssafy.happyhouse.model;

public class NoticeDto {
    private int articleno;
    private String subject;
    private String content;
    private String articlePwd;
    private String regtime;

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticlePwd() {
        return articlePwd;
    }

    public void setArticlePwd(String articlePwd) {
        this.articlePwd = articlePwd;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }
}
