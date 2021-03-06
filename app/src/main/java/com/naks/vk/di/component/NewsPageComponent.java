package com.naks.vk.di.component;

import com.naks.vk.di.anotation.PerFragment;
import com.naks.vk.di.module.NewsPageModule;
import com.naks.vk.mvp.presenter.NewsPagePresenter;
import com.naks.vk.ui.fragment.NewsPageFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = NewsPageModule.class)
public interface NewsPageComponent {

    void inject(NewsPageFragment fragment);

    NewsPagePresenter getPresenter();
}