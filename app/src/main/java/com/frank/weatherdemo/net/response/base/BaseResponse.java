package com.frank.weatherdemo.net.response.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by frank on 26/05/16.
 *
 */
public class BaseResponse {
    @SuppressWarnings("FieldCanBeLocal")
    @SerializedName("error")
    @Expose
    private final int error = 0;

    @SerializedName("status")
    @Expose
    private final String status = null;

    @SuppressWarnings("unused")
    @SerializedName("date")
    @Expose
    private final String date = null;

    public boolean isOK() {
        return error == 0;
    }

    public String getError() {
        return status;
    }
}
