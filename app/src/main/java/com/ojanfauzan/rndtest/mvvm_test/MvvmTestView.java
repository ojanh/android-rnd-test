package com.ojanfauzan.rndtest.mvvm_test;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ojanfauzan.rndtest.R;
import com.ojanfauzan.rndtest.base.ResponseModel;
import com.ojanfauzan.rndtest.mvvm_test.viewmodel.MvvmTestViewModel;
import com.ojanfauzan.rndtest.mvvm_test.viewmodel.MvvmTestViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class MvvmTestView extends AppCompatActivity implements HasActivityInjector {

    @BindView(R.id.mvvmtest_tview1)
    TextView tviewTest1;


    MvvmTestViewModel viewModel;

    @Inject
    MvvmTestViewModelFactory viewModelFactory;
    @Inject
    AndroidInjector<Activity> activityDispatchingAndroidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(MvvmTestView.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmtest);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MvvmTestViewModel.class);
        viewModel.getResponse().observe(this, responseModel -> doResponse(responseModel));
    }

    private void doResponse(ResponseModel responseModel) {
        switch (responseModel.status){
            case SUCCESS:
                tviewTest1.setText(responseModel.data);
                tviewTest1.setBackgroundColor(Color.GREEN);
                break;
            case ERROR:
                tviewTest1.setText(responseModel.error.getMessage());
                tviewTest1.setBackgroundColor(Color.RED);
                break;
            case LOADING:
                tviewTest1.setText("LOADING...");
                break;
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
