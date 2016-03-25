package com.example.dmitriy.mvp_sample.example;


import android.widget.EditText;
import android.widget.TextView;

public class ExampleViewHolder {
    public final EditText editText;
    public final TextView textView;

    public ExampleViewHolder(EditText editText, TextView textView) {
        this.editText = editText;
        this.textView = textView;
    }
}
