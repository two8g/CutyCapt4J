import two8g.swissarmy.CutyCapt4J.Options;
import two8g.swissarmy.CutyCapt4J.Xvfb;
import two8g.swissarmy.CutyCapt4J.XvfbArgs;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by two8g on 16-6-3.
 */
public class XvfbTest {
    private String xcfbPath = "/usr/bin/xvfb-run";
    private String cutycaptPath = "/usr/bin/cutycapt";
    private File xvfbFile;
    private File cutycaptFile;
    private Options commonOptions;
    private XvfbArgs commonXvfbArgs;

    @Before
    public void setUp() {
        xvfbFile = new File(xcfbPath);
        cutycaptFile = new File(cutycaptPath);
        commonOptions = new Options().withExecutable(cutycaptFile);
        commonXvfbArgs = new XvfbArgs().withExecutable(xvfbFile);
    }

    @Test
    public void testXvfbCaptureUrl() throws Exception {
        URL url = new URL("http://two8g.com");
        File out = new File("target/test-classes/xvfb-two8g-url.png");
        Options options = commonOptions.withUrl(url);
        options = options.withOut(out);
        XvfbArgs xvfbArgs = commonXvfbArgs.withCommands(options.getCutyCaptCommand());
        Xvfb xvfb = new Xvfb();
        int exitCode = xvfb.run(null, xvfbArgs);
        assert exitCode == 0;
    }

}
