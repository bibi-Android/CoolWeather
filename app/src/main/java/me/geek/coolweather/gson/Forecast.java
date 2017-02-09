package me.geek.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * "daily_forecast":[
 * {
 *      "date":"2017-02-09",
 *     "cond":{"txt_d":"晴"},
 *     "tmp":{"max":"5","min":"-2"},
 * },
 * {
 *      date":"2017-02-10"
 *     "cond":{"txt_d":"晴"},
 *     "tmp":{"max":"6","min":"-2"}
 * },
 * ]
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{
        @SerializedName("max")
        public String max;

        @SerializedName("min")
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
