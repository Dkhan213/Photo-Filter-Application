package com.photofilter.integration.helper;

import com.photofilter.activity.ConvertPhotoActivity;
import com.photofilter.dependency.DaggerServiceComponent;
import com.photofilter.dependency.ServiceComponent;

public final class ActivityProvider {
    private static final ServiceComponent DAGGER = DaggerServiceComponent.create();

    private ActivityProvider() {
    }

    public static ConvertPhotoActivity provideConvertPhotoActivity() {
        return DAGGER.provideConvertPhotoActivity();
    }
}
