package com.ojanfauzan.rndtest.mvvm_test;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public class MvvmTestViewModelFactory implements ViewModelProvider.Factory {

    private MvvmTestUseCaseModel mvvmTestUseCaseModel;
    private Scheduler scheduler;

    public MvvmTestViewModelFactory(MvvmTestUseCaseModel mvvmTestUseCaseModel, Scheduler scheduler) {
        this.mvvmTestUseCaseModel = mvvmTestUseCaseModel;
        this.scheduler = scheduler;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MvvmTestViewModel.class))
            return (T) new MvvmTestViewModel(mvvmTestUseCaseModel, scheduler);
        else
            throw new IllegalArgumentException("Unknown View Model");
    }
}
