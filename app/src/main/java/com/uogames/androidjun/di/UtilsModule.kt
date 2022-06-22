package com.uogames.androidjun.di

import android.app.Application
import android.content.Context
import com.uogames.androidjun.PersonViewModel
import com.uogames.androidjun.database.DatabaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

	@Provides
	fun provideContext(app: Application): Context = app.applicationContext

	@Provides
	fun provideDatabaseRepository(context: Context): DatabaseRepository =
		DatabaseRepository.get(context)

	@Singleton
	@Provides
	fun provideViewModel(repository: DatabaseRepository): PersonViewModel = PersonViewModel(repository)

}