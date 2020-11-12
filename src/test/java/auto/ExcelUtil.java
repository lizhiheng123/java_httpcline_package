package auto;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelUtil {
    public static Object[][] datas(String excelpath, int startRow, int endRow, int startCell, int endCell) {

        Object[][] datas = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelpath));
            //第二部获取sheet对象
            Sheet sheet = workbook.getSheet("用例");
            //获取行
            datas = new Object[endRow - startRow + 1][endCell - startCell + 1];
            for (int i = startRow; i <= endRow; i++) {
                Row row = sheet.getRow(i - 1);
                for (int j = startCell; j <= endCell; j++) {
                    Cell cell = row.getCell(j - 1);
                    //将列设置为字符串类型,不设置的话会取不到sell数据
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = cell.getStringCellValue();
                    datas[i - startRow][j - startCell] = value;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return datas;
    }

//非连续
    public static Object[][] datas(String excelpath, int[] rows, int[] cells) {

        Object[][] datas = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(excelpath));
            //第二部获取sheet对象
            Sheet sheet = workbook.getSheet("用例");
            //定义保存数组
            datas = new Object[rows.length][cells.length];
            //通过循环获取每一列
            for (int i = 0; i < rows.length; i++) {
                //根据行索引取出索引
                Row row = sheet.getRow(rows[i]-1);
                for (int j = 0; j < cells.length; j++) {
                    Cell cell = row.getCell(cells[j] - 1);
                    //将列设置为字符串类型,不设置的话会取不到sell数据
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = cell.getStringCellValue();
                    datas[i][j] = value;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return datas;
    }
}