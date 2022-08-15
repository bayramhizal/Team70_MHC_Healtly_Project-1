package utilities;

import java.util.HashMap;
import java.util.Map;

public class XyzTestData {
    public Map<String,String> bookingDatesSetUp (String checkin, String checkout){
        Map<String,String> bookingdatesMap=new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

        return bookingdatesMap;
    }

    public  Map<String,Object> expectedDataSetup(String firstname,String lastname,int totalprice,boolean depositpaid,Map<String,String> bookingdates){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname", lastname);
        expectedDataMap.put("totalprice", totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates", bookingdates);

        return expectedDataMap;

    }

    public String expectedDataInString(String firstname,String lastname,int totalprice,boolean depositpaid,String checkin,String checkout,String additionalneeds){
        String expectedData=  "{\n" +
                "    \"firstname\": \""+firstname+"\",\n" +
                "    \"lastname\": \""+lastname+"\",\n" +
                "    \"totalprice\": "+totalprice+" ,\n" +
                "    \"depositpaid\": "+depositpaid+" ,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \""+checkin+"\",\n" +
                "        \"checkout\": \""+checkout+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \""+additionalneeds+"\"\n" +
                "}";
        return expectedData;
    }
}
