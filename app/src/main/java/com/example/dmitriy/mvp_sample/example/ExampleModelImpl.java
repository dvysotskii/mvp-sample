package com.example.dmitriy.mvp_sample.example;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import rx.Observable;
import rx.functions.Func1;

public class ExampleModelImpl implements ExampleInterfaces.ExampleInterfaceModel {
    public final ExampleViewHolder exampleViewHolder;

    public ExampleModelImpl(ExampleViewHolder exampleViewHolder) {
        this.exampleViewHolder = exampleViewHolder;
    }

    @Override
    public Observable<String> getChanges() {
        return RxTextView.textChangeEvents(exampleViewHolder.editText).map(new Func1<TextViewTextChangeEvent, String>() {
            @Override
            public String call(TextViewTextChangeEvent textViewTextChangeEvent) {
                return textViewTextChangeEvent.text().toString().trim();
            }
        });
    }

    @Override
    public Observable<String> request(String query) {
        return Observable.just(query);
    }
}
