package getuserlist;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class Getuser {

    @BeforeClass
    public void setup()
    {
        System.out.println("I am before class");
    }

    @Test
    public void doreqres_getuserlist_validation()
    {
        System.out.println("I am test");
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void do_book_liabrary_soap_call_validation()
    {
        System.out.println("This book library test");
    }

    @AfterClass
    public void close_connection()
    {
        System.out.println("I am for closing the connections");
    }
}
