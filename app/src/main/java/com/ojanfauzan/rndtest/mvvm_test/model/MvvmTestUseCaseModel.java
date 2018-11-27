package com.ojanfauzan.rndtest.mvvm_test.model;

import javax.inject.Inject;

import io.reactivex.Single;

public class MvvmTestUseCaseModel {

    private final MvvmTestModel mvvmTestModel;

    @Inject
    public MvvmTestUseCaseModel(MvvmTestModel mvvmTestModel) {
        this.mvvmTestModel = mvvmTestModel;
    }

    public Single<String> execute(){
        return mvvmTestModel.getGreeting();
    }
}

