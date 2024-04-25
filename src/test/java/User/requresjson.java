package User;

public class requresjson {
    
    public String Createjsonuser(String username ,String zipNo)
    {
        String body = "{\n" +
                "    \"name\": \""+username+"\",\n" +
                "    \"job\": \"API TEST LEAD\",\n" +
                "    \"Address\": \"123 Mumbai\",\n" +
                "    \"ZIP\": \""+zipNo+"\"\n" +
                "}";
        return body;
    }


}
