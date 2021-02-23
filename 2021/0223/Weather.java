package weather;

public class Weather {
    private String data;
    private String tmn;
    private String tmx;
    private String wf;

    public Weather(String data, String tmn, String tmx, String wf) {
        this.data = data;
        this.tmn = tmn;
        this.tmx = tmx;
        this.wf = wf;
    }

    public Weather() {}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTmn() {
        return tmn;
    }

    public void setTmn(String tmn) {
        this.tmn = tmn;
    }

    public String getTmx() {
        return tmx;
    }

    public void setTmx(String tmx) {
        this.tmx = tmx;
    }

    public String getWf() {
        return wf;
    }

    public void setWf(String wf) {
        this.wf = wf;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "data='" + data + '\'' +
                ", tmn='" + tmn + '\'' +
                ", tmx='" + tmx + '\'' +
                ", wf='" + wf + '\'' +
                '}';
    }
}
