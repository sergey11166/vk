package com.naks.vk.mvp.model.interactor;

import com.naks.vk.App;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void wakeUpSession(final OnLoginFinishedListener listener) {
        VKSdk.wakeUpSession(App.get(), new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                switch (res) {
                    case LoggedOut:
                        listener.onLoggedOut();
                        break;
                    case LoggedIn:
                        listener.onLoggedIn();
                        break;
                    case Pending:
                        listener.onPending();
                        break;
                    case Unknown:
                        listener.onUnknown();
                        break;
                }
            }

            @Override
            public void onError(VKError error) {
            }
        });
    }
}
