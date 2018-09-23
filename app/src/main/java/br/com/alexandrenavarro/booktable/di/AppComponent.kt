package br.com.alexandrenavarro.booktable.di

import android.app.Application
import br.com.alexandrenavarro.booktable.BoniApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetModule::class])
interface AppComponent  {

    fun inject(app: BoniApplication)

//    override fun inject(instance: DaggerApplication)
//
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder
//
//        fun build(): AppComponent
//    }

}