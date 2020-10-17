package com.ironclad.daggerdemo

import dagger.Component


@Component(modules = [MemoryCardModule::class, LIBatteryModule::class])
interface SmartPhoneComponent {

    fun inject(mainActivity: MainActivity)
}