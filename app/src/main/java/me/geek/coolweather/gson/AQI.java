package me.geek.coolweather.gson;

/**
 * "aqi":{
 *      "city":{ "aqi":"81","pm25":"59"}
 * }
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class AQI {

    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
