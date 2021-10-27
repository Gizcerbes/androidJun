package com.uogames.androidjun.di

import android.app.Application
import com.uogames.androidjun.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AndroidInjectionModule::class,
		ActivityBuilderModule::class,
		FragmentBuilderModule::class,
		UtilsModule::class
	]
)
interface AppComponent : AndroidInjector<App> {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun bindApplication(app: Application): Builder

		fun build(): AppComponent

	}

}