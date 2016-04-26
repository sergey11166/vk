package com.naks.vk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.naks.vk.mvp.presenter.LoginPresenter;
import com.naks.vk.mvp.view.LoginView;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class LoginActivity extends BaseActivity implements LoginView {

    private static final String[] sMyScope = new String[]{
            VKScope.NOTIFICATIONS,
            VKScope.MESSAGES,
            VKScope.FRIENDS,
            VKScope.OFFLINE,
            VKScope.PHOTOS,
            VKScope.STATUS,
            VKScope.GROUPS,
            VKScope.EMAIL,
            VKScope.NOTES,
            VKScope.PAGES,
            VKScope.WALL,
            VKScope.DOCS,
    };

    @InjectPresenter LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.wakeUpSession();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKCallback<VKAccessToken> callback = new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // User passed Authorization
                presenter.onUserPassedAuthorization();
            }

            @Override
            public void onError(VKError error) {
                // User didn't pass Authorization
                finish();
            }
        };

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void showLoginScreen() {
        VKSdk.login(this, sMyScope);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
