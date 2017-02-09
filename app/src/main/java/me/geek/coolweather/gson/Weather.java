package me.geek.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class Weather {

        public String status;
        public Basic basic;
        public AQI aqi;
        public Now now;
        public Suggestion suggestion;

        //由于Forecast返回的是一个数组,所以这里使用一个集合来收集
        @SerializedName("daily_forecast")
        public List<Forecast> forecastList;


}
