package org.jmresler.hr.aw.views.svcs.util;


import com.google.gson.Gson;

public interface ObjectToJSONStringSerializer {
    default String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
