package com.liyudong.home.myretrofitdaggerrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerUserComponent.create().inject(this);
        Toast.makeText(this,user.whoAreU(),Toast.LENGTH_SHORT).show();
    }
}
