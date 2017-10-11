package ziku.app.hotshotk.di.modules.fragments

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ziku.app.hotshotk.di.scope.PerFragment
import ziku.app.hotshotk.fragments.hotshot.HotShotFragmentImp

@Module
abstract class FragmentModule {

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(ProductFragmentModule::class))
    abstract fun bindHotShotFragment() : HotShotFragmentImp
}