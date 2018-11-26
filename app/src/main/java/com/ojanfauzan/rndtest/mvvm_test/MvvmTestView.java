package com.ojanfauzan.rndtest.mvvm_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ojanfauzan.rndtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MvvmTestView extends AppCompatActivity {

    @BindView(R.id.mvvmtest_tview1)
    TextView tviewTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmtest);
        ButterKnife.bind(this);

    }
}
