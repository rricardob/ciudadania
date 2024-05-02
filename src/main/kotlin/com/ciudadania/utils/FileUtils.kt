package com.ciudadania.utils

import java.io.File

class FileUtils {

    fun createLogFile(name: String): File {
        return File("logs/$name.log")
    }

    companion object{

    }
}