package com.inrix.mds.constants;

import org.springframework.beans.factory.annotation.Value;

public class MDSConstants {

    @Value("${liveApiVersion}")
    public final static String LIVE_API_VERSION = "v1";
}
