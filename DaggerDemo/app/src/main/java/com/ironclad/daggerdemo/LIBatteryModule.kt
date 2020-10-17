package com.ironclad.daggerdemo

import dagger.Module
import dagger.Provides

@Module
class LIBatteryModule {

    @Provides
    fun providesLIBattery(liIonBattery: LiIonBattery): Battery {
        return liIonBattery
    }
}