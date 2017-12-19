package com.iny;

import javax.jws.WebService;

/**
 * Created by zcy on 2017/11/9.
 */

@WebService
public interface TestWebService {

    Proson add(Proson a,Proson b);

}
