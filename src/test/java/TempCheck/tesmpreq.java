package TempCheck;

public class tesmpreq {
    public String TempCelCheck(String expectedferr)
    {
        String body ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "      <Celsius>"+expectedferr+"</Celsius>\n" +
                "    </CelsiusToFahrenheit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        return body;
    }
}
