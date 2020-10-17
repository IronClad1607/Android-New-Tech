package com.ironclad.daggerdemo

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MemoryCardModule::class, LIBatteryModule::class])
interface SmartPhoneComponent {

    fun inject(mainActivity: MainActivity)
}