package com.andyadc.study.jodd;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * @author andaicheng
 * @version 2016/11/17
 */
public class JoddHttp {

    public static void main(String[] args) {
        HttpRequest request = new HttpRequest();
        request.method("GET").protocol("http").host("127.0.0.1").port(8080).path("/webapi/myAccount/vip/monthBillInfo.do").connectionTimeout(5000);
        HttpResponse response = request.send();
        System.out.println(response.toString());
    }
}
