package com.liyudong.home.myretrofitdaggerrx.Model.retrofit;

import com.liyudong.home.myretrofitdaggerrx.DataBean.TestBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liyudongjames on 2017/3/22.
 */

public interface TestApi {
    @POST("svc/payment-facade/housekeep/listLatestLiveBuildingSites")
    Observable<TestBean> getTestBean(@QueryMap Map<String,String> testMap);
}
