package com.ojanfauzan.rndtest.mvvm_test;

import javax.inject.Inject;

import io.reactivex.Single;

public class MvvmTestUseCaseModel {

    private final MvvmTestModel mvvmTestModel;

    @Inject
    public MvvmTestUseCaseModel(MvvmTestModel mvvmTestModel) {
        this.mvvmTestModel = mvvmTestModel;
    }

    Single<String> execute(){
        return mvvmTestModel.getGreeting();
    }
}

