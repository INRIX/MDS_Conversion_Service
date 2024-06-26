package com.inrix.mds.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.inrix.mds.constants.MDSConstants;
@JsonPropertyOrder({"version", "data"})
public class ResponseWrapper {
    private Object data;
    private String version = MDSConstants.LIVE_API_VERSION;

    public String getVersion() {
        return version;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object Data) {
        data = Data;
    }
}
