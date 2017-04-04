package com.liyudong.home.myretrofitdaggerrx.Model;

import com.liyudong.home.myretrofitdaggerrx.DataBean.TestBean;
import com.liyudong.home.myretrofitdaggerrx.Model.CallBack.InternetCallBack;

/**
 * Created by liyudongjames on 2017/3/22.
 */

public interface TestModel {
    void getInfo(InternetCallBack<TestBean> callBack);
}
