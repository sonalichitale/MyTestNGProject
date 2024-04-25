package Workshop;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.SocketHandler;


import static com.mysql.cj.conf.PropertyKey.logger;
import static io.restassured.RestAssured.get;


public class workshop1 {

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;
    //Use TestNG framework
    //Read Get API URL from properties file
    //create one XL table where population vs year details are given
    //Hit the URL and read year vs population and match the data with XL
    //if data matches the extend the report and create final extend report

    String year = null;
    String population, status_Code;
    support1 obj;

    @BeforeClass
    public void setUp() {

        obj = new support1();

            extent = new ExtentReports();
            spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/Workshop_API.html"); //current path of the project using System.getProperty
//System.getProperty("user.dir") == C:\Users\sunilk\IdeaProjects\TestNG_RestAssurd\ExtentReport
            spark.config().setDocumentTitle("https://datausa.io/api/data?drilldowns=Nation&measures=Population GET API call");
            spark.config().setReportName("get call to \"https://datausa.io/api/data?drilldowns=Nation&measures=Population\" and validate response");
            spark.config().setTheme(Theme.STANDARD);
            extent.attachReporter(spark);
            extent.setSystemInfo("QA Name", "Sonali");
            extent.setSystemInfo("Build name", "16.3.2");
            extent.setSystemInfo("ENV Name", "NAM UAT-2");
            logger = extent.createTest("Validate the uas population when year is given");

    }

    @Test
    public void Do_Web_API_Validation() {

        String key ="url";
        String url = read_Properties_file(key);
        Response response = get(url);
        //Response response = get("https://datausa.io/api/data?drilldowns=Nation&measures=Population");
        String res = response.getBody().asString();
        int yearcount = response.getBody().jsonPath().getList("data.Year").size();
        for (int i = 1; i < yearcount; i++) {
            String year1 = response.getBody().jsonPath().getString("data.Year[" + i + "]");
            String population1 = response.getBody().jsonPath().getString("data.Population[" + i + "]");
            System.out.println("When Year is: " + year1 + " then population is " + population1);
            String XL_population = obj.read_And_Print_XL_AsPerTestData(year1, "Population");
            if (XL_population != null) {
                Assert.assertEquals(population1.trim(), XL_population.trim());
                System.out.println("When Year is: " + year1 + " then population is " + population1);
                logger.info("When Year is: " + year1 + " then population is " + population1);

            } else {
                System.out.println("The Data for Year " + year1 + " Then null in excel please add it");
                logger.info("The Data for Year " + year1 + " Then null in excel please add it");

            }
            //System.out.println("When Year is: "+year1+ "then population is "+population1);
        }

    }

    // First get the count of node you want to test ...
    // Assert.assertEquals(String.valueOf(response.getStatusCode()),year);
    //Assert.assertTrue(res.contains(population));

    public String read_Properties_file(String key) {
        Properties prop = new Properties();
        String value = null;
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/URLdata.properties"));
            value = prop.getProperty(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }


    }


