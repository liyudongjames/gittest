package com.liyudong.home.myretrofitdaggerrx.Model;

import android.util.Log;

import com.liyudong.home.myretrofitdaggerrx.DataBean.TestBean;
import com.liyudong.home.myretrofitdaggerrx.Model.CallBack.InternetCallBack;
import com.liyudong.home.myretrofitdaggerrx.Model.retrofit.NoApi;
import com.liyudong.home.myretrofitdaggerrx.Model.retrofit.TestApi;

import java.util.HashMap;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liyudongjames on 2017/3/22.
 */
@Module
public class TestModelImpl implements TestModel {

    private String baseUrl = "http://hui.17house.com/";
    private Map<String, String> requestMap;

    public TestModelImpl() {
    }

    @Provides
    public TestModelImpl provideTest() {
        return new TestModelImpl();
    }

    @Override
    public void getInfo(final InternetCallBack<TestBean> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        NoApi api = retrofit.create(NoApi.class);
        api.getTestBean()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TestBean>() {
                    @Override
                    public void onCompleted() {
                        callBack.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.wrong();
                    }

                    @Override
                    public void onNext(TestBean testBean) {
                        Log.d("12313",testBean.toString());
//                        callBack.infoCallBack(testBean);
                    }
                });

//        requestMap = new HashMap<>();
//        requestMap.put("token","DAB088BA50C9405E84C789055D657614");
//        requestMap.put("city_id","2");
//        requestMap.put("cityName","成都");
//        requestMap.put("app_version","android_com.aiyiqi.galaxy_1.1");
//
//        TestApi api = retrofit.create(TestApi.class);
//        api.getTestBean(requestMap)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<TestBean>() {
//                    @Override
//                    public void onCompleted() {
//                        callBack.complete();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        callBack.wrong();
//                    }
//
//                    @Override
//                    public void onNext(TestBean testBean) {
//                        callBack.infoCallBack(testBean);
//                    }
//                });

    }
}
