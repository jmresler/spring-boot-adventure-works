package org.jmresler.aw.entities.util;

import com.google.gson.Gson;

public interface JsonSerializable {

    default String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
