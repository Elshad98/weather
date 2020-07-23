package com.example.weather.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Find {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.weather.service.model.Find.List> list = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public java.util.List<com.example.weather.service.model.Find.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.weather.service.model.Find.List> list) {
        this.list = list;
    }

    public class Coord {

        @SerializedName("lat")
        @Expose
        private float lat;
        @SerializedName("lon")
        @Expose
        private float lon;

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public float getLon() {
            return lon;
        }

        public void setLon(float lon) {
            this.lon = lon;
        }

    }

    public class Clouds {

        @SerializedName("all")
        @Expose
        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

    }

    public class List {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("coord")
        @Expose
        private Coord coord;
        @SerializedName("main")
        @Expose
        private Main main;
        @SerializedName("dt")
        @Expose
        private int dt;
        @SerializedName("wind")
        @Expose
        private Wind wind;
        @SerializedName("sys")
        @Expose
        private Sys sys;
        @SerializedName("rain")
        @Expose
        private Object rain;
        @SerializedName("snow")
        @Expose
        private Object snow;
        @SerializedName("clouds")
        @Expose
        private Clouds clouds;
        @SerializedName("weather")
        @Expose
        private java.util.List<Weather> weather = null;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public Object getRain() {
            return rain;
        }

        public void setRain(Object rain) {
            this.rain = rain;
        }

        public Object getSnow() {
            return snow;
        }

        public void setSnow(Object snow) {
            this.snow = snow;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

    }

    public class Main {

        @SerializedName("temp")
        @Expose
        private int temp;
        @SerializedName("feels_like")
        @Expose
        private float feelsLike;
        @SerializedName("temp_min")
        @Expose
        private int tempMin;
        @SerializedName("temp_max")
        @Expose
        private int tempMax;
        @SerializedName("pressure")
        @Expose
        private int pressure;
        @SerializedName("humidity")
        @Expose
        private int humidity;

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public float getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(float feelsLike) {
            this.feelsLike = feelsLike;
        }

        public int getTempMin() {
            return tempMin;
        }

        public void setTempMin(int tempMin) {
            this.tempMin = tempMin;
        }

        public int getTempMax() {
            return tempMax;
        }

        public void setTempMax(int tempMax) {
            this.tempMax = tempMax;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

    }

    public class Sys {

        @SerializedName("country")
        @Expose
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }

    public class Weather {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

    public class Wind {

        @SerializedName("speed")
        @Expose
        private int speed;
        @SerializedName("deg")
        @Expose
        private int deg;

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

    }
}
