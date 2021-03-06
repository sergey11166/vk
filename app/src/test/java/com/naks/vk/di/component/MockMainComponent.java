package com.naks.vk.di.component;

import com.naks.vk.di.anotation.PerActivity;
import com.naks.vk.di.module.MockMainModule;
import com.naks.vk.di.module.MockNewsPageModule;
import com.naks.vk.di.module.MockNewsTabModule;
import com.naks.vk.mvp.presenter.impl.MainPresenterTest;

import dagger.Component;

@PerActivity
@Component(modules = MockMainModule.class, dependencies = MockAppComponent.class)
public interface MockMainComponent {
    void inject(MainPresenterTest test);

    MockNewsTabComponent plus(MockNewsTabModule module);
    MockNewsPageComponent plus(MockNewsPageModule module);
}
