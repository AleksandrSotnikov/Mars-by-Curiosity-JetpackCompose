package ru.sotnikov.marsbycuriosity

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.sotnikov.marsbycuriosity_impl.marsByCuriosityModule
import ru.sotnikov.settings.settingModule
import timber.log.Timber

@Suppress("OPT_IN_USAGE")
class MarsByCuriosityApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                Logger.log(priority, tag, message, t)
            }
        })

        startKoin {
            androidLogger()
            androidContext(this@MarsByCuriosityApplication)
            modules(
                listOf(
                    marsByCuriosityModule,
                    settingModule
                )
            )
        }
    }
}
