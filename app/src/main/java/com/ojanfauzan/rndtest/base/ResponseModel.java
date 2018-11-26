package com.ojanfauzan.rndtest.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ResponseModel {

    public final Status status;

    @Nullable
    public final String data;

    @Nullable
    public final Throwable error;

    private ResponseModel(Status status, @Nullable String data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ResponseModel loading() {
        return new ResponseModel(Status.LOADING, null, null);
    }

    public static ResponseModel success(@NonNull String data) {
        return new ResponseModel(Status.SUCCESS, data, null);
    }

    public static ResponseModel error (@NonNull Throwable error){
        return new ResponseModel(Status.ERROR, null, error);
    }
}
