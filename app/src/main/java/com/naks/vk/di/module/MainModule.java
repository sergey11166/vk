package com.naks.vk.di.module;

import com.naks.vk.di.anotation.PerActivity;
import com.naks.vk.model.interactor.MainInteractor;
import com.naks.vk.model.interactor.MainInteractorImpl;
import com.naks.vk.presenter.MainPresenter;
import com.naks.vk.presenter.MainPresenterImpl;
import com.naks.vk.view.MainView;
import com.naks.vk.view.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public MainActivity provideMainActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    public MainView provideMainView() {
        return activity;
    }

    @Provides
    @PerActivity
    public MainPresenter provideMainPresenter(MainActivity activity) {
        return new MainPresenterImpl(activity);
    }

    @Provides
    @PerActivity
    MainInteractor provideMainInteractor(MainActivity activity) {
        return new MainInteractorImpl(activity);
    }
}
