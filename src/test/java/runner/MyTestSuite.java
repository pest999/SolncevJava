package runner;

import heisenbub19.ProxyUsageTest;
import heisenbub19.TwoBrowsersTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ProxyUsageTest.class, TwoBrowsersTest.class})
public class MyTestSuite {
}
