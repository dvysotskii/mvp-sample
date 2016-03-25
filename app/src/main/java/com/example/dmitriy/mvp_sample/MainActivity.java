package com.example.dmitriy.mvp_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dmitriy.mvp_sample.example.ExampleInterfaces;
import com.example.dmitriy.mvp_sample.example.ExampleModelImpl;
import com.example.dmitriy.mvp_sample.example.ExamplePresenterImpl;
import com.example.dmitriy.mvp_sample.example.ExampleViewHolder;
import com.example.dmitriy.mvp_sample.example.ExampleViewImpl;

public class MainActivity extends AppCompatActivity {
    ExampleInterfaces.ExampleInterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        TextView textView = (TextView) findViewById(R.id.text_view);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(editText, textView);
        ExampleInterfaces.ExampleInterfaceView view = new ExampleViewImpl(exampleViewHolder);
        ExampleInterfaces.ExampleInterfaceModel model = new ExampleModelImpl(exampleViewHolder);
        presenter = new ExamplePresenterImpl(model, view);

        presenter.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
