package com.liyudong.home.myretrofitdaggerrx.Model.CallBack;

/**
 * Created by liyudongjames on 2017/3/23.
 */

public interface InternetCallBack<T> {
    void infoCallBack(T t);
    void wrong();
    void complete();
}
