package com.ciudadania.service

import java.io.InputStream
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface IProcessExcel {

    fun readExcel(path: InputStream): Map<String, JvmType.Object>
}