package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.soapui.SoapuiOrgTest;

@RunWith(Suite.class)
@SuiteClasses({SoapuiOrgTest.class})
public class JUnitSuiteRunner {

}
