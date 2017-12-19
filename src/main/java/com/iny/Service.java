package com.iny;

import javax.xml.ws.Endpoint;

/**
 * Created by zcy on 2017/11/9.
 */
public class Service {

    public static void main(String args[]){
        Endpoint.publish("http://localhost:8080/testWebService",new TestWebServiceImpl());

    }
}
