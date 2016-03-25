package com.example.dmitriy.mvp_sample.example;

import android.app.Activity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class ExamplePresenterImpl implements ExampleInterfaces.ExampleInterfacePresenter {
    private ExampleInterfaces.ExampleInterfaceModel model;
    private ExampleInterfaces.ExampleInterfaceView view;
    private Subscription subscription;

    public ExamplePresenterImpl(ExampleInterfaces.ExampleInterfaceModel model, ExampleInterfaces.ExampleInterfaceView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreate(Activity activity, Bundle bundle) {
        subscription = model.getChanges()
                .debounce(500, TimeUnit.MILLISECONDS)
                .switchMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return model.request(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        view.showResponse(s);
                    }
                });
    }

    @Override
    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
