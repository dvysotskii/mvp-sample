package com.example.dmitriy.mvp_sample.example;


public class ExampleViewImpl implements ExampleInterfaces.ExampleInterfaceView {
    public final ExampleViewHolder exampleViewHolder;

    public ExampleViewImpl(ExampleViewHolder exampleViewHolder) {
        this.exampleViewHolder = exampleViewHolder;
    }

    @Override
    public void showResponse(String text) {
        exampleViewHolder.textView.setText(text);
    }
}
