package com.example.weather.repository.server.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("coord")
    @Expose
    private com.example.weather.service.model.Weather.Coord coord;
    @SerializedName("weather")
    @Expose
    private List<com.example.weather.service.model.Weather.Weather_> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private com.example.weather.service.model.Weather.Main main;
    @SerializedName("visibility")
    @Expose
    private int visibility;
    @SerializedName("wind")
    @Expose
    private com.example.weather.service.model.Weather.Wind wind;
    @SerializedName("clouds")
    @Expose
    private com.example.weather.service.model.Weather.Clouds clouds;
    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("sys")
    @Expose
    private com.example.weather.service.model.Weather.Sys sys;
    @SerializedName("timezone")
    @Expose
    private int timezone;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private int cod;

    public com.example.weather.service.model.Weather.Coord getCoord() {
        return coord;
    }

    public void setCoord(com.example.weather.service.model.Weather.Coord coord) {
        this.coord = coord;
    }

    public List<com.example.weather.service.model.Weather.Weather_> getWeather() {
        return weather;
    }

    public void setWeather(List<com.example.weather.service.model.Weather.Weather_> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public com.example.weather.service.model.Weather.Main getMain() {
        return main;
    }

    public void setMain(com.example.weather.service.model.Weather.Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public com.example.weather.service.model.Weather.Wind getWind() {
        return wind;
    }

    public void setWind(com.example.weather.service.model.Weather.Wind wind) {
        this.wind = wind;
    }

    public com.example.weather.service.model.Weather.Clouds getClouds() {
        return clouds;
    }

    public void setClouds(com.example.weather.service.model.Weather.Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public com.example.weather.service.model.Weather.Sys getSys() {
        return sys;
    }

    public void setSys(com.example.weather.service.model.Weather.Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

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

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public class Weather_ {

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

    public class Coord {

        @SerializedName("lon")
        @Expose
        private float lon;
        @SerializedName("lat")
        @Expose
        private float lat;

        public float getLon() {
            return lon;
        }

        public void setLon(float lon) {
            this.lon = lon;
        }

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

    }

    public class Main {

        @SerializedName("temp")
        @Expose
        private float temp;
        @SerializedName("feels_like")
        @Expose
        private float feelsLike;
        @SerializedName("temp_min")
        @Expose
        private float tempMin;
        @SerializedName("temp_max")
        @Expose
        private float tempMax;
        @SerializedName("pressure")
        @Expose
        private int pressure;
        @SerializedName("humidity")
        @Expose
        private int humidity;

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(float feelsLike) {
            this.feelsLike = feelsLike;
        }

        public float getTempMin() {
            return tempMin;
        }

        public void setTempMin(float tempMin) {
            this.tempMin = tempMin;
        }

        public float getTempMax() {
            return tempMax;
        }

        public void setTempMax(float tempMax) {
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

        @SerializedName("type")
        @Expose
        private int type;
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("sunrise")
        @Expose
        private int sunrise;
        @SerializedName("sunset")
        @Expose
        private int sunset;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getSunrise() {
            return sunrise;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public int getSunset() {
            return sunset;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

    }

}
