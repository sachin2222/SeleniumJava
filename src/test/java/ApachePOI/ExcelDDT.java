package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelDDT {

    XSSFSheet sheet;


    @Test
    public void ReadExcel() throws IOException {

        FileInputStream fin = new FileInputStream("C:\\Users\\ss26370\\OneDrive - ZS\\Desktop\\VDG\\TestCases_Release2_Sp1_Functional.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        int sheetCount = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetCount; i++) {

            if (workbook.getSheetName(i).equalsIgnoreCase("Add Password field on Publish M")) {

                sheet = workbook.getSheetAt(i);

            }
        }

        Iterator<Row> rows = sheet.iterator();

      /*  Iterator<Cell> cells = rows.next().cellIterator();
        while (cells.hasNext()) {
            System.out.print(cells.next().getStringCellValue() + " ");
        }
*/

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Iterator<Cell> cells = sheet.getRow(i).iterator();
            while (cells.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                String cellvalue = formatter.formatCellValue(cells.next());
                System.out.print(cellvalue + " ");

            }


        }


    }

    @Test
    public void writeExcel() throws IOException {
        FileOutputStream fout = new FileOutputStream("C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\ExcelOutput\\demo.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Client Data");
        XSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Address");
        row.createCell(2).setCellValue("Phone_Number");

        for(int i=1;i<10;i++){

           XSSFRow rows= sheet.createRow(i);
           rows.createCell(0).setCellValue("sachin");
           rows.createCell(1).setCellValue("Badarpur");
           rows.createCell(2).setCellValue("8700896892");

        }

        workbook.write(fout);
        fout.flush();


    }


}
