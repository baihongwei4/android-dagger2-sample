package com.hongwei.android_dagger2_sample.injection.utils;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;

@Documented
@MapKey
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {

    Class<? extends ViewModel> value();
}
