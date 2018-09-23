package br.com.alexandrenavarro.booktable

import android.app.Activity
import android.app.Application
import br.com.alexandrenavarro.booktable.di.AppModule
import br.com.alexandrenavarro.booktable.di.DaggerAppComponent
import br.com.alexandrenavarro.booktable.di.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by alexandrenavarro on 9/22/18.
 */
class BoniApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(BuildConfig.URL))
                .build().inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}