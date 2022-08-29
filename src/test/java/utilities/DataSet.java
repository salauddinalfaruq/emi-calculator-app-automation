package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name ="data-provider")
    public Object[][] setData(){
        return new Object[][]{
                {50000, 10, 1, 2,  4395.79, 2749.53, 1000, 52749.53},
                {100000, 10, 2, 2,  4614.49, 10747.82, 2000, 110747.82},
                {150000, 15, 1, 2,  13538.75, 12464.96, 3000, 162464.96},
                {180000, 15, 2, 2,  8727.6, 29462.32, 3600, 209462.32},
                {200000, 20, 1, 3,  18526.9, 22322.81, 6000, 222322.81}
        };
    }
}
