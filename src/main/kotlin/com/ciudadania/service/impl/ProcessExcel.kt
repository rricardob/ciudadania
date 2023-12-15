package com.ciudadania.service.impl

import com.ciudadania.entity.EmployeeModel
import com.ciudadania.entity.PositionModel
import com.ciudadania.entity.TaskControlModel
import com.ciudadania.repository.IJpaControlTypeRepository
import com.ciudadania.repository.IJpaEmployeeRepository
import com.ciudadania.repository.IJpaPositionRepository
import com.ciudadania.service.IProcessExcel
import com.ciudadania.utils.Constants
import org.apache.logging.log4j.util.Strings
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.IOException
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
class ProcessExcel(
    var positionRepository: IJpaPositionRepository,
    var employeeRepository: IJpaEmployeeRepository,
    var controlTypeRepository: IJpaControlTypeRepository
) : IProcessExcel {

    override fun readExcel(path: InputStream): Map<String, JvmType.Object> {

        //load positions
        //val positionList = excelToPositions(path)
        //positionRepository.saveAll(positionList)

        //load employees
        //val employeeList = excelToEmployees(path)
        //employeeRepository.saveAll(employeeList)

        return emptyMap()
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
                        0 -> {
                            val formatter = DataFormatter();
                            val cell: Cell = currentCell
                            val aux = formatter.formatCellValue(cell)
                            employeeModel.dni = aux.toString().toLong()
                        }

                        1 -> employeeModel.code = currentCell.numericCellValue.toInt()
                        2 -> employeeModel.firstLastName = currentCell.stringCellValue
                        3 -> employeeModel.secondLastName = currentCell.stringCellValue
                        4 -> employeeModel.names = currentCell.stringCellValue
                        5 -> employeeModel.birthdate =
                            if (null != currentCell && Strings.isNotEmpty(currentCell.toString())) currentCell.dateCellValue else null

                        6 -> {
                            println(currentCell)
                            val aux = formatCellValue(currentCell)
                            employeeModel.phone = if (Strings.isNotEmpty(aux)) aux else ""
                        } //currentCell?.numericCellValue?.toInt() ?: 0
                        7 -> employeeModel.email =
                            if (Strings.isNotEmpty(formatCellValue(currentCell))) formatCellValue(currentCell) else Strings.EMPTY

                        8 -> employeeModel.address =
                            if (null != currentCell && Strings.isNotEmpty(currentCell.toString())) currentCell.stringCellValue else Strings.EMPTY

                        9 -> employeeModel.bloodType =
                            if (null != currentCell && Strings.isNotEmpty(currentCell.toString())) currentCell.stringCellValue else Strings.EMPTY

                        10 -> employeeModel.year = currentCell?.numericCellValue?.toInt()
                        12 -> employeeModel.photo =
                            if (null != currentCell && Strings.isNotEmpty(currentCell.toString())) currentCell.stringCellValue else Strings.EMPTY

                        13 -> employeeModel.supervisor = currentCell?.numericCellValue?.toInt() ?: 0
                        14 -> employeeModel.shortSleeveBlouseOrShirt = formatCellValue(currentCell)
                        15 -> employeeModel.boxNeckPolo = formatCellValue(currentCell)
                        16 -> employeeModel.pants = formatCellValue(currentCell)
                        17 -> employeeModel.cap = formatCellValue(currentCell)
                        18 -> employeeModel.longSleeveBlouseOrShirt = formatCellValue(currentCell)
                        19 -> employeeModel.reflectiveJacket = formatCellValue(currentCell)
                        20 -> employeeModel.highNeckSweatshirt = formatCellValue(currentCell)
                        21 -> employeeModel.vest = formatCellValue(currentCell)
                        22 -> employeeModel.reflectiveWaterproofPoncho = formatCellValue(currentCell)
                        23 -> employeeModel.borceguies = formatCellValue(currentCell)
                        24 -> employeeModel.socks = formatCellValue(currentCell)
                        25 -> employeeModel.footwear = formatCellValue(currentCell)

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

    private fun excelToTaskControl(path: InputStream): List<TaskControlModel>{
        try {
            val workbook = XSSFWorkbook(path)
            val sheet = workbook.getSheet(Constants.POSITION)
            val rows = sheet.iterator()

            val taskControl: MutableList<TaskControlModel> = mutableListOf()

            var rowNumber = 0
            while (rows.hasNext()) {
                val currentRow = rows.next()

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                val cellInRow = currentRow.iterator()

                val taskControlModel = TaskControlModel()

                var cellIdx = 0

                while (cellInRow.hasNext()) {
                    val currentCell = cellInRow.next()

                    when (cellIdx) {
                        0 -> taskControlModel.employeeDni = currentCell.numericCellValue.toLong()
                        1 -> {
                            println(stringToLocalDate(currentCell.stringCellValue))
                            taskControlModel.controlDate = stringToLocalDate(currentCell.stringCellValue)
                        }
                    }
                    cellIdx++
                }

                taskControl.add(taskControlModel)

            }

            workbook.close()
            return taskControl

        } catch (e: IOException) {
            throw RuntimeException("fail to parse Excel file: " + e.message);
        }
    }

    private fun formatCellValue(value: Cell): String {
        return DataFormatter().formatCellValue(value)
    }

    private fun stringToLocalDate(date: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
        return LocalDate.parse(date, formatter)
    }

}
