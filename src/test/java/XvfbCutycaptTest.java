import com.two8g.swissarmy.CutyCapt4J.Options;
import com.two8g.swissarmy.CutyCapt4J.XvfbArgs;
import com.two8g.swissarmy.CutyCapt4J.XvfbCutycapt;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by two8g on 16-6-3.
 */
public class XvfbCutycaptTest {
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
	public void testXvfbCutycaptUrl() throws Exception {
		URL url = new URL("http://two8g.com");
		File out = new File("target/test-classes/xvfb-cuty-two8g-url.png");
		Options options = commonOptions.withUrl(url);
		options = options.withOut(out);
		int exitCode = new XvfbCutycapt().run(options, commonXvfbArgs);
		assert exitCode == 0;
	}
}
