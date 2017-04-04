package com.liyudong.home.myretrofitdaggerrx.Dagger;

import com.liyudong.home.myretrofitdaggerrx.Model.TestModelImpl;
import com.liyudong.home.myretrofitdaggerrx.Presenter.TestPresenter;

import dagger.Component;

/**
 * Created by liyudongjames on 2017/3/23.
 */

@Component(modules = {TestModelImpl.class,Main2Activity.class,TestPresenter.class})
public interface TestComponent {

    void injectTest(TestPresenter presenter);

    void injectActivity(Main2Activity activity);
}
