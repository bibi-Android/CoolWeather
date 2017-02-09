package me.geek.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * "now":{
 *      "tmp":"4",
 *      "cond":{"txt":"多云"}
 *  }
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
