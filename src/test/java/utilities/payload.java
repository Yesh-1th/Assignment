package utilities;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class payload {
    @Test
    public HashMap<String, Object> dataDriven() throws IOException {

        ExcelUtils et = new ExcelUtils();
       ArrayList paydata = et.getData("key","Sheet1");
        String[] pd = (String[]) paydata.toArray(new String[0]);
        //System.out.println(paydata);

        int len = pd.length;
       // System.out.println(len);
        int i=0;



        HashMap<String,Object> hm = new HashMap<>();
       for( int n=0;n<len-1;n++)
        {

            i++;
            if(n==0)
            { }
            else
            {
                n++;
                i++;
            }

            while(i<len)
            {
                hm.put(pd[n],pd[i]);
                break;
            }
        }
//        String json = new ObjectMapper().writeValueAsString(pd);
//        System.out.println(json);

       //System.out.println(hm);

        return hm;
    }

}
