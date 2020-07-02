package com.light.utility.domain

import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UnicodeToBinaryEncoderComponentTest {

    lateinit var component: UnicodeToBinaryEncoderComponent

    @Before
    fun setUp() {
        component = UnicodeToBinaryEncoderComponent()
    }

    @Test
    fun testGetState_whenSubscribeEvent_shouldReceiveEmptyString() = runBlockingTest {
        Assert.assertEquals(component.getState().firstOrNull(), "")
    }

    @Test
    fun testForCI() {
        Assert.fail()
    }
}
