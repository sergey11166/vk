package com.naks.vk.mvp.model.interactor.impl;

import android.content.Context;

import com.naks.vk.mvp.model.interactor.LoginInteractor;
import com.naks.vk.mvp.model.interactor.OnLoginFinishedListener;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class LoginInteractorImpl implements LoginInteractor {

    private Context context;

    public LoginInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void wakeUpSession(final OnLoginFinishedListener listener) {
        VKSdk.wakeUpSession(context, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                switch (res) {
                    case LoggedOut:
                        listener.onLoggedOut();
                        break;
                    case LoggedIn:
                        listener.onLoggedIn();
                        break;
                }
            }

            @Override
            public void onError(VKError error) {
            }
        });
    }
}
