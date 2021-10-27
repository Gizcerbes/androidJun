package com.uogames.androidjun.di

import android.app.Application
import android.content.Context
import com.uogames.androidjun.MyViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

	@Provides
	fun provideContext(app: Application): Context = app.applicationContext

	@Singleton
	@Provides
	fun provideViewModel(context: Context): MyViewModel = MyViewModel(context)

}