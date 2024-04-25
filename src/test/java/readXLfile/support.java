package readXLfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class support {

   /* public static void main(String[] args) {
        read_and_print_newXlasperTestdata("TC003","Title");
    }*/

    public String read_and_print_newXlasperTestdata(String testcasename, String columname)
    {
        String data =null;
        try {

            String XlFilepath = "/Users/sonalik/Downloads/simplexlfile.xlsx";
            FileInputStream myXLfile =new FileInputStream(XlFilepath);
            Workbook workbook = new XSSFWorkbook(myXLfile);
            Sheet sheet = workbook.getSheet("NewXL");
            int lastRow = sheet.getLastRowNum();
            System.out.println("The last row which has data =="+lastRow);

            //Loop for row iteration..
            for(int i =0;i<=lastRow;i++) {
                Row row = sheet.getRow(i);

                //Get the last column which has data
                int lastcell = row.getLastCellNum();
                Cell cell =row.getCell(0);
                String runtimetestcasename = cell.getStringCellValue();
                 System.out.println("First column value is "+runtimetestcasename);
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
    return data;
    }


}
