package com.ciudadania.utils

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.XSSFColor

class ExcelUtils {

    companion object {

        fun formatCellValue(value: Cell): String {
            return DataFormatter().formatCellValue(value)
        }

        fun toHexColorFromCell(cell: Cell): String? {

            val color: XSSFColor? = cell
                .cellStyle
                .fillForegroundColorColor as? XSSFColor

            val colorHex = color
                ?.ctColor
                ?.xgetRgb()
                ?.stringValue
                ?.substring(2) ?: return "#ffffff"

            return "#$colorHex"

        }
    }
}