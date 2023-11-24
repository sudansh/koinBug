package app.sudansh.koinbug

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            defaultModule()
        }
    }
}