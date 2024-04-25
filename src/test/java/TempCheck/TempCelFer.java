package TempCheck;

import User.requresjson;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

import io.restassured.http.ContentType;
import TempCheck.tesmpreq;


public class TempCelFer {
    requresjson RJB;

    public XmlPath xml_path_obj;
    Response response;
    @BeforeClass
    public void setup()
    {
        RJB = new requresjson();

    }
    @Parameters({"url","Celcius","expectedferr"})
    @Test
   /* public void Temp_check_Cel(String url,String Celcius,String expectedferr)
    {
        Response res =given()
                .contentType(ContentType.XML)
                .header("Content-Type","text/xml; charset=utf-8")
                .body(RJB.Createjsonuser())
                .when()
                .post(url);

        int status_code = res.getStatusCode();
        String response_body= res.getBody().asString();
        System.out.println(status_code);
        System.out.println(response_body);
        xml_path_obj =new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String data = xml_path_obj.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult").trim();
        System.out.println(data);
    }*/

    @AfterClass
    public void Demo()
    {

    }
}
