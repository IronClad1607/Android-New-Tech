package com.ironclad.daggerdemo

import dagger.Component


@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone() :SmartPhone
}