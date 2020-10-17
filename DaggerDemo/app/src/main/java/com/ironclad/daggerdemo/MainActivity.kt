package com.ironclad.daggerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var memoryCard: MemoryCard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        DaggerSmartPhoneComponent.create()
//                .inject(this)
//
//        smartPhone.makeACallWithRecording()
//        memoryCard.getSpaceAvailability()

        DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1000))
            .build()
            .inject(this)


//        val smartPhone = SmartPhone(Battery(), SIMCard(ServiceProvider()), MemoryCard())
//        smartPhone.makeACallWithRecording()
    }
}