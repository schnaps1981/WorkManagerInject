package com.example.myapplication.repository

import javax.inject.Inject
import kotlin.random.Random

class SampleRepositoryImpl @Inject constructor() : SampleRepository {

    override fun getRandom(): Int = Random.nextInt()

}
