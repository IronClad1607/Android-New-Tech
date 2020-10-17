package com.ironclad.daggerdemo

import dagger.Component


@Component
interface SmartPhoneComponent {
    fun getSmartPhone() :SmartPhone
}