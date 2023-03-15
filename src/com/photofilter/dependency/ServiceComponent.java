package com.photofilter.dependency;

import com.photofilter.activity.ConvertPhotoActivity;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Declares the dependency roots that Dagger will provide.
 */
@Singleton
@Component()
public interface ServiceComponent {
    ConvertPhotoActivity provideConvertPhotoActivity();
}
