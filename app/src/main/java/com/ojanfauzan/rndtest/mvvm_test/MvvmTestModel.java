package com.ojanfauzan.rndtest.mvvm_test;

import io.reactivex.Single;

public class MvvmTestModel {

    public Single<String> getGreeting(){
        return Single.just("Hello From test Model");
    }


}
