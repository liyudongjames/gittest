package com.liyudong.home.myretrofitdaggerrx.Dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liyudong.home.myretrofitdaggerrx.DataBean.TestBean;
import com.liyudong.home.myretrofitdaggerrx.Model.retrofit.ApiForCheck;
import com.liyudong.home.myretrofitdaggerrx.Model.retrofit.NoApi;
import com.liyudong.home.myretrofitdaggerrx.Model.retrofit.TestApi;
import com.liyudong.home.myretrofitdaggerrx.Presenter.TestPresenter;
import com.liyudong.home.myretrofitdaggerrx.R;
import com.liyudong.home.myretrofitdaggerrx.View.TestView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class Main2Activity extends AppCompatActivity implements TestView{

    private Button click_btn,check_btn;
    private String baseUrl = "http://hui.17house.com/";

    @Inject
    TestPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        click_btn = (Button) findViewById(R.id.click_btn);
        check_btn = (Button) findViewById(R.id.check_btn);
        DaggerTestComponent.create().injectActivity(this);
        click_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getTest();
            }
        });

        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareRetrofit();
            }
        });
    }

    private Map<String,String> requestMap;
    private void prepareRetrofit(){
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
                        Toast.makeText(Main2Activity.this,"onCompleted",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError",e.getMessage().toString());
                        Toast.makeText(Main2Activity.this,"onError",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(TestBean testBean) {
                        Toast.makeText(Main2Activity.this,"onNext",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void showTest(TestBean bean) {
        Toast.makeText(this,bean.getData().get(0).getImageUrl(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void wrong() {
        Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void complete() {
        Toast.makeText(this,"complete",Toast.LENGTH_SHORT).show();
    }

    @Provides
    public TestView viewProvider(){
        return this;
    }
}
