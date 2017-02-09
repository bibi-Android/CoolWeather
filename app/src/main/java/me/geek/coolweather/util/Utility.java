package me.geek.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.geek.coolweather.db.City;
import me.geek.coolweather.db.County;
import me.geek.coolweather.db.Province;
import me.geek.coolweather.gson.Weather;

/**
 *
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * [{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"天津"},{"id":4,"name":"重庆"},.....]
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince = new JSONArray(response);
                for(int i = 0; i < allProvince.length(); i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析和处理服务器返回的市级数据
     * [{"id":113,"name":"南京"},{"id":114,"name":"无锡"},{"id":115,"name":"镇江"},.......]
     */
    public static boolean handleCityResponse(String response, int provinceid){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i = 0; i < allCities.length(); i++){
                    JSONObject cityObejcet = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObejcet.getString("name"));
                    city.setCityCode(cityObejcet.getInt("id"));
                    city.setProvinceid(provinceid);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;

    }


    /**
     * 解析和处理服务器返回的县级数据
     * [{"id":928,"name":"无锡","weather_id":"CN101190201"},{"id":929,"name":"江阴","weather_id":"CN101190202"},.......]
     */
    public static boolean handleCountyResponse(String response, int cityid){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCouties = new JSONArray(response);
                for(int i = 0; i < allCouties.length(); i++){
                    JSONObject countyObject = allCouties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityid(cityid);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析服务器或本地获取到的天气Json信息
     */

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray  jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
