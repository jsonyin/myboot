package com.iny;

import javax.jws.WebService;

/**
 * Created by zcy on 2017/11/9.
 */

@WebService(endpointInterface = "com.iny.TestWebService")
public class TestWebServiceImpl implements TestWebService {
    @Override
    public Proson add(Proson a, Proson b) {
        return a;
    }
}
