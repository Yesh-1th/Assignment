package stepDefinations;

import Report.ReportConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void init()
    {

        ReportConfig.config();
    }

    @After
    public void close()
    {
        ReportConfig.extent.flush();
    }
}
