package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // Data Provider1 is taking Excel data and storing it in two-dimensional array for further processing

    @DataProvider(name = "LoginData")
    public String[][] getLoginData() throws IOException {
        String path = ".//testData//OpenCartLoginData.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalRows = xlutil.getRowCount("Sheet1");
        int totalColumns = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[totalRows][totalColumns];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }

        return logindata;
    }

    // Data Provider 2

    // Data Provider 3

}
