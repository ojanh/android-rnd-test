package com.ojanfauzan.rndtest.mvvm_test.model;

import io.reactivex.Single;

public class MvvmTestModel {

    public Single<String> getGreeting(){
        return Single.just("Hello From test Model");
    }


}
