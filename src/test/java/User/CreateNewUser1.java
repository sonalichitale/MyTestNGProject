package User;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import User.requresjson;

import static io.restassured.RestAssured.*;
public class CreateNewUser1 {
    requresjson RJB;



    @BeforeClass
    public void setUp(){
        RJB = new requresjson();
    }
    @Parameters({"usercreationUrl","zipNo","username"})
    @Test(groups = {"smoke"},priority = 2)
    public void Create_New_use(String usercreationUrl,String zipNo,String username){
        Response res = given().
                contentType(ContentType.JSON).
                body(RJB.Createjsonuser(username,zipNo)).
                when().
                post(usercreationUrl);
        int status_code = res.getStatusCode();
        String response_body= res.getBody().asString();
        System.out.println(status_code);
        System.out.println(response_body);
        String user_id = res.getBody().jsonPath().getString("id");
        System.out.println("User ID is "+user_id);

    }

    //@Parameters({"url"})
    @Test(groups = {"smoke"},priority = 0)
    public void  createNewSmoke()
    {
        System.out.println("This is smoke test");
    }

    @Test(groups = {"regression"},priority = 0)
    public void createNewRegression()
    {
        System.out.println("This is test regression");
    }

    @Test(groups = {"e2e"},priority = 1)
    public void createNewe2e()
    {
        System.out.println("This is test e2e");
    }

    @AfterClass
    public void tearDown(){

    }


}
