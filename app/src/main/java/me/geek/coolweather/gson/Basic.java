package me.geek.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * "basic":{
 *      "city":"苏州",
 *      "id":"CN101190401",""lon":"120.612000",
 *      "update":{"loc":"2017-02-09 18:51" }
 *   }
 *
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public update update;

    public class update{
        @SerializedName("loc")
        public String updateTime;
    }

}
