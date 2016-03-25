package com.example.dmitriy.mvp_sample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dmitriy.mvp_sample.example.ExampleInterfaces;
import com.example.dmitriy.mvp_sample.example.ExampleModelImpl;
import com.example.dmitriy.mvp_sample.example.ExamplePresenterImpl;
import com.example.dmitriy.mvp_sample.example.ExampleViewHolder;

public class MainActivity extends AppCompatActivity implements ExampleInterfaces.ExampleInterfaceView {
    ExampleInterfaces.ExampleInterfacePresenter presenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);

        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(editText, textView);
        ExampleInterfaces.ExampleInterfaceModel model = new ExampleModelImpl(exampleViewHolder);
        presenter = new ExamplePresenterImpl(model, this);
        presenter.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showResponse(String text) {
        textView.setText(text);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(textView, error, Snackbar.LENGTH_SHORT).show();
    }
}
