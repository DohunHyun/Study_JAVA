package com.ssafy.happyhouse.model.dto;

public class Subway {
    private String line;
    private String station_name;
    private String address;
    private String rdnmAddress;
    private String telNo;

    @Override
    public String toString() {
        return "Subway{" +
                "line='" + line + '\'' +
                ", station_name='" + station_name + '\'' +
                ", address='" + address + '\'' +
                ", rdnmAddress='" + rdnmAddress + '\'' +
                ", telNo='" + telNo + '\'' +
                '}';
    }

    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public String getStation_name() {
        return station_name;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRdnmAddress() {
        return rdnmAddress;
    }
    public void setRdnmAddress(String rdnmAddress) {
        this.rdnmAddress = rdnmAddress;
    }
    public String getTelNo() {
        return telNo;
    }
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
