package com.liyudong.home.myretrofitdaggerrx.Model.retrofit;


import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liyudongjames on 2017/3/24.
 */

public interface ApiForCheck {
    @POST("svc/payment-facade/housekeep/listLatestLiveBuildingSites")
    Observable<String> getTestBean(@QueryMap Map<String,String> testMap);
}
