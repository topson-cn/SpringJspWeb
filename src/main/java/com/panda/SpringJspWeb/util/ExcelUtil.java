package com.panda.SpringJspWeb.util;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExcelUtil {

    public static void main(String[] args) throws IOException, WriteException
    {
        File xlsFile = new File("jxl.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);

        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        sheet.getSettings().setVerticalFreeze(1);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }
}
