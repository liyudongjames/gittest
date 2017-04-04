package com.liyudong.home.myretrofitdaggerrx;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liyudongjames on 2017/3/21.
 */

@Module
public class User {

    private String name = "David";
    private int age = 24;

    public User(){

    }

    public String whoAreU(){
        return "My name is " + name + "and I am " + age + "years old";
    }

    @Provides
    public User porvideUser(){
        return new User();
    }
}
