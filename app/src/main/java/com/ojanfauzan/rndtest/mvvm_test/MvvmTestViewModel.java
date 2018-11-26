package com.ojanfauzan.rndtest.mvvm_test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ojanfauzan.rndtest.base.ResponseModel;
import com.ojanfauzan.rndtest.base.Status;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class MvvmTestViewModel extends ViewModel {

    private final MvvmTestUseCaseModel mvvmTestUseCaseModel;

    private final Scheduler scheduler;

    private final CompositeDisposable disposable = new CompositeDisposable();

    private final MutableLiveData<ResponseModel> response = new MutableLiveData<>();

    public MvvmTestViewModel(MvvmTestUseCaseModel mvvmTestUseCaseModel, Scheduler scheduler) {
        this.mvvmTestUseCaseModel = mvvmTestUseCaseModel;
        this.scheduler = scheduler;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    MutableLiveData<ResponseModel> getResponse(){
        return response;
    }

    public void loadModel(){
        disposable.add(mvvmTestUseCaseModel.execute().
            doOnSubscribe(__ -> response.setValue(ResponseModel.loading()))
            .subscribe(
                    greeting -> response.setValue(ResponseModel.success(greeting)),
                    error -> response.setValue(ResponseModel.error(error))
            )
        );
    }
}
