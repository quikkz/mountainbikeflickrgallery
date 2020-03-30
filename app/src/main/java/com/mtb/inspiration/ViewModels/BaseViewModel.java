package com.mtb.inspiration.ViewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class BaseViewModel extends AndroidViewModel {

    protected Application _app;

    public MutableLiveData<String> ErrorMLD;

    public LiveData<String> getErrorMLD() {
            ErrorMLD = new MutableLiveData<>();
        return ErrorMLD;
    }

    public MutableLiveData<String> SuccessMLD;

    public LiveData<String> getSuccessMLD() {
        SuccessMLD = new MutableLiveData<>();
        return SuccessMLD;
    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
        _app = application;
    }
}
