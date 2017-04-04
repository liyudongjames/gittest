package com.liyudong.home.myretrofitdaggerrx.Presenter;

import com.liyudong.home.myretrofitdaggerrx.Dagger.DaggerTestComponent;
import com.liyudong.home.myretrofitdaggerrx.DataBean.TestBean;
import com.liyudong.home.myretrofitdaggerrx.Model.CallBack.InternetCallBack;
import com.liyudong.home.myretrofitdaggerrx.Model.TestModelImpl;
import com.liyudong.home.myretrofitdaggerrx.View.TestView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liyudongjames on 2017/3/22.
 */

@Module
public class TestPresenter {

    @Inject
    TestModelImpl model;
    @Inject
    TestView view;

    public void getTest(){
        DaggerTestComponent.create().injectTest(this);
        model.getInfo(new InternetCallBack<TestBean>() {
            @Override
            public void infoCallBack(TestBean testBean) {
                view.showTest(testBean);
            }

            @Override
            public void wrong() {
                view.wrong();
            }

            @Override
            public void complete() {
                view.complete();
            }
        });
    }

    @Provides
    public TestPresenter presenterProvider(){
        return this;
    }

}
