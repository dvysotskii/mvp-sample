package com.example.dmitriy.mvp_sample.example;


import android.app.Activity;
import android.os.Bundle;

import rx.Observable;

public interface ExampleInterfaces {
    interface ExampleInterfacePresenter {
        void onCreate(Activity activity, Bundle bundle);

        void onDestroy();
    }

    interface ExampleInterfaceModel {
        Observable<String> getChanges();

        Observable<String> request(String query);
    }

    interface ExampleInterfaceView {
        void showResponse(String text);

        void showError(String error);
    }
}
