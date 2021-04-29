package utilities;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class payload {

    public String dataDriven() throws IOException {

        ExcelUtils et = new ExcelUtils();
        HashMap<String, String> paydata= et.getData("Sheet1");
        String json_payload = new ObjectMapper().writeValueAsString(paydata);
        //System.out.println(json);

        return json_payload;

    }


}
