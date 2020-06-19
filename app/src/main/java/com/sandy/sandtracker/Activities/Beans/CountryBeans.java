package com.sandy.sandtracker.Activities.Beans;

public class CountryBeans {
    private String ranking;
    private String c_name;
    private String time;
    private String confirmed;
    private String recovered;
    private String deaths;
    private int colorCv;

    public int getColorCv() {
        return colorCv;
    }

    public void setColorCv(int colorCv) {
        this.colorCv = colorCv;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
