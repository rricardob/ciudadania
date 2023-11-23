package com.ciudadania.service.impl

import com.ciudadania.entity.EmployeeModel
import com.ciudadania.entity.PositionModel
import com.ciudadania.repository.IJpaPositionRepository
import com.ciudadania.service.IControlTypeService
import com.ciudadania.service.IProcessExcel
import com.ciudadania.utils.Constants
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.IOException
import java.io.InputStream
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
class ProcessExcel(var positionRepository: IJpaPositionRepository) : IProcessExcel {

    lateinit var controlTypeRepository: IControlTypeService

    override fun readExcel(path: InputStream): Map<String, JvmType.Object> {

        val positionList = excelToPositions(path)

        positionList.forEach { println(it) }

        val result: Map<String, JvmType.Object> = emptyMap()

        return result
    }

    private fun convertValue(value: Cell, type: CellType): Any {
        return when (type) {
            CellType.BOOLEAN -> value.toString().toBoolean()
            CellType.STRING -> value.toString()
            CellType.NUMERIC -> {
                val index = value.toString().indexOf(".")
                value.toString().substring(0, index).toLong()
            }

            else -> value.toString()
        }
    }

    private fun excelToPositions(path: InputStream): List<PositionModel> {
        try {
            val workbook = XSSFWorkbook(path)
            val sheet = workbook.getSheet(Constants.POSITION)
            val rows = sheet.iterator()

            val positions: MutableList<PositionModel> = mutableListOf()

            var rowNumber = 0
            while (rows.hasNext()) {
                val currentRow = rows.next()

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                val cellInRow = currentRow.iterator()

                val positionModel = PositionModel()

                var cellIdx = 0

                while (cellInRow.hasNext()) {
                    val currentCell = cellInRow.next()

                    when (cellIdx) {
                        0 -> positionModel.code = currentCell.numericCellValue.toLong()
                        1 -> {
                            positionModel.name = currentCell.stringCellValue
                        }
                    }
                    cellIdx++
                }

                positions.add(positionModel)

            }

            workbook.close()
            return positions

        } catch (e: IOException) {
            throw RuntimeException("fail to parse Excel file: " + e.message);
        }
    }

    private fun excelToEmployees(path: InputStream): List<EmployeeModel> {
        try {
            val workbook = XSSFWorkbook(path)
            val sheet = workbook.getSheet(Constants.EMPLOYEE)
            val rows = sheet.iterator()

            val employees: MutableList<EmployeeModel> = mutableListOf()

            var rowNumber = 0
            while (rows.hasNext()) {
                val currentRow = rows.next()

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                val cellInRow = currentRow.iterator()

                val employeeModel = EmployeeModel()

                var cellIdx = 0

                while (cellInRow.hasNext()) {
                    val currentCell = cellInRow.next()

                    when (cellIdx) {
                        0 -> employeeModel.dni = currentCell.numericCellValue.toLong()
                        1 -> employeeModel.code = currentCell.numericCellValue.toInt()
                        2 -> employeeModel.firstLastName = currentCell.stringCellValue
                        3 -> employeeModel.secondLastName = currentCell.stringCellValue

                    }
                    cellIdx++
                }

                employees.add(employeeModel)

            }

            workbook.close()
            return employees

        } catch (e: IOException) {
            throw RuntimeException("fail to parse Excel file: " + e.message);
        }
    }

}
