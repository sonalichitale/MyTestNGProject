package User;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;


public class newcode {


    //Declaration that help to generate the logs in the test report

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private  ExtentTest logger;

    @BeforeClass
    public void createsetup()
    {

       // System.getProperty(Users.dir)-  C:\Users\sonalik\IdeaProjects\TestNG_RestAssurednew
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/index.html");
        spark.config().setDocumentTitle("Reqres website get API details validation");
        spark.config().setReportName("Reqres_GET_API_Details");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
        extent.setSystemInfo("QA Name","Sonali");
        extent.setSystemInfo("Build Name","ABC234");
        extent.setSystemInfo("Environment Name","UAT");
        logger = extent.createTest("Validate get API from recres application");
    }
    @Test
    public void validategetdata()
    {
        logger.info("This is for regression test");

        //logger.info("The get user is "+ "https://reqres.in/api/users?page=2");
        Response response =get("https://reqres.in/api/users?page=2");
        String res = response.getBody().asString();
        int jsonpath = response.getBody().jsonPath().getList("data.firstname").size();
        System.out.println("Count is : " + jsonpath);

        for (int i = 0; i < jsonpath; i++) {
            String id = response.getBody().jsonPath().getString("data.id[" + i + "]");
            String email = response.getBody().jsonPath().getString("data.email[" + i + "]");
            System.out.println("If ID value is ->"+id+" "+"Then Email value is->"+email);
            logger.info("id value "+id+ "then email is" +email);
        }
    }

    @AfterClass
    public void teardata()
    {
        extent.flush();
    }
}
