package readXLfile;

import com.google.protobuf.StringValue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import readXLfile.support;

public class WebAPI {

    String testname = null;

    support obj;

    @BeforeClass
    public void setup()
    {
        obj =new support();
    }

    @Test
    public void do_all_web_app_test()
    {
        float f;
        int val;
        testname ="TC001";
        String url =obj.read_and_print_newXlasperTestdata(testname,"ReqURL");
        String statuscode = obj.read_and_print_newXlasperTestdata(testname,"StatusCode");
       f = Float.parseFloat(statuscode);
       val = (int)f;
       statuscode =String.valueOf(val);
        System.out.println("The Statuscode is "+statuscode);
       String title = obj.read_and_print_newXlasperTestdata(testname,"Title");


    }

    @Test
    public void do_API_Validation(String url, String ststuscode, String Title)
    {
        Response response =
                get(url);
        String res = response.getBody().asString();
        //int st =response.getStatusCode();
        Assert.assertEquals(String.valueOf(response.getStatusCode()),ststuscode);
        Assert.assertTrue(res.contains(Title));




    }
}
