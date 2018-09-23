package br.com.alexandrenavarro.booktable.di

import br.com.alexandrenavarro.booktable.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}