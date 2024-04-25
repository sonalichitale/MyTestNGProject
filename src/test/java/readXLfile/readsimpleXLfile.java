package readXLfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class readsimpleXLfile {

    @AfterClass
        public void setup()
    {

    }
    //Interfaces to Identify Apace POI

    //workbook -Interface to instantiate different XL file(xls,xlsx)
    //sheet - Interface to read the sheet inside the workbook
    //Row -Interface to read the identify the rows inside the sheet
    //cell - Interface to identify the corresponding cell of given row

    // XSSFWorkbook - Class which will implement Workbook interface for the XL file.
    // HSSFWorkbook - Class which will implement Workbook interface for the XL file
    // XSSFSheet - Class representing a Sheet interface.
    // HSSFSheet - Class representing a Sheet interface.
    // XSSFRow - Class representing a Row interface.
    // HSSFRow - Class representing a Row interface.
    // XSSFCell - Class representing a Cell interface.
    // HSSFCell - Class representing a Cell interface.

   // @Test
    public void read_and_print_Xl()
    {
        try {

            String XlFilepath = "/Users/sonalik/Downloads/simplexlfile.xlsx";
            FileInputStream myXLfile =new FileInputStream(XlFilepath);
            Workbook workbook = new XSSFWorkbook(myXLfile);
            Sheet sheet = workbook.getSheet("XLsheet");
            int lastRow = sheet.getLastRowNum();
            System.out.println("The last row which has data =="+lastRow);

            //Loop for row iteration..

            for(int i =0;i<=lastRow;i++) {
                Row row = sheet.getRow(i);

                //Get the last column which has data
                int lastcell = row.getLastCellNum();

                //Loop for column iteration
                for(int j=0;j<lastcell;j++)
                {
                    Cell cell = row.getCell(j);
                    String value =cell.getStringCellValue();
                    System.out.println("The XL value is "+value);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        read_and_print_newXlasperTestdata("TC003","Title");
    }



    public static void read_and_print_newXlasperTestdata(String testcasename, String columname)
    {
        try {

            String XlFilepath = "/Users/sonalik/Downloads/simplexlfile.xlsx";
            FileInputStream myXLfile =new FileInputStream(XlFilepath);
            Workbook workbook = new XSSFWorkbook(myXLfile);
            Sheet sheet = workbook.getSheet("NewXL");
            int lastRow = sheet.getLastRowNum();
            //System.out.println("The last row which has data =="+lastRow);


            //Loop for row iteration..

            for(int i =0;i<=lastRow;i++) {
                Row row = sheet.getRow(i);

                //Get the last column which has data
                int lastcell = row.getLastCellNum();
                Cell cell =row.getCell(0);
                String runtimetestcasename = cell.getStringCellValue();
               // System.out.println("First column value is "+runtimetestcasename);
                if(runtimetestcasename.equals(testcasename))
                {

                                //Loop for column iteration
                                Row rownew =sheet.getRow(0);
                           for(int j=0;j<lastcell;j++)
                            {
                                Cell cell1 = rownew.getCell(j);
                                String runtimecellvalue =cell1.getStringCellValue();
                                if(runtimecellvalue.equals(columname)) {

                                    String value =sheet.getRow(i).getCell(j).toString();
                                    System.out.println("The XL value is " + value);
                                }
                            }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

}
