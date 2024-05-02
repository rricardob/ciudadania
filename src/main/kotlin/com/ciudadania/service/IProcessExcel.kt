package com.ciudadania.service

import java.io.InputStream

interface IProcessExcel {

    fun readExcel(path: InputStream, parameters: Map<*, *>): Map<String, Any>
}