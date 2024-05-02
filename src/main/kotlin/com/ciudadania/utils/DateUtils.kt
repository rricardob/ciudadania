package com.ciudadania.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateUtils {

    companion object {

        fun startDateOfMonth(date: LocalDate?): LocalDate? {
            if (date != null) {
                return date.withDayOfMonth(1)
            }
            return null
        }

        fun stringToLocalDate(date: String): LocalDate {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
            return LocalDate.parse(date, formatter)
        }

    }

}