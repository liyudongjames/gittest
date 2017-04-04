package com.liyudong.home.myretrofitdaggerrx;

import dagger.Component;

/**
 * Created by liyudongjames on 2017/3/21.
 */

@Component(modules = {User.class})
public interface UserComponent {

    void inject(MainActivity activity);
}
