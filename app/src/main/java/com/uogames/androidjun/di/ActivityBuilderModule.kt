package com.uogames.androidjun.di

import com.uogames.androidjun.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

	@ContributesAndroidInjector
	abstract fun contributeMainActivity(): MainActivity

}