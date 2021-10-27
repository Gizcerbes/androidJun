package com.uogames.androidjun.di

import com.uogames.androidjun.HomeFragment
import com.uogames.androidjun.PersonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

	@ContributesAndroidInjector
	abstract fun contributeHomeFragment(): HomeFragment

	@ContributesAndroidInjector
	abstract fun contributePersonFragment(): PersonFragment

}