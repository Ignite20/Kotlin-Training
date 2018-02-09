package com.tests.amadalingradinaru.kotlin2.domain

/**
 * Created by a.madalin.gradinaru on 16/01/2018.
 */
public interface Command<T> {
    fun execute(): T


}