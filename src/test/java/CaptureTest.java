import com.two8g.swissarmy.CutyCapt4J.Cutycapt;
import com.two8g.swissarmy.CutyCapt4J.Options;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by two8g on 16-6-3.
 */
public class CaptureTest {

	@Test
	public void testCaptureUrl() throws Exception {
		URL url = new URL("http://two8g.com");
		File out = new File("target/test-classes/two8g-url.png");

		Cutycapt cutycapt = new Cutycapt(new File("/usr/bin/cutycapt"));
		Options options = new Options();
		int exitCode = cutycapt.run(options, url, out);
		assert exitCode == 0;
	}

	@Test
	public void testCaptureHtmlFile() throws Exception {
		URL url = new URL("file:/home/two8g/Develop/IdeaProjects/CutyCapt4J/src/test/resources/two8g blog.html");
		File out = new File("target/test-classes/two8g-html-file.png");

		Cutycapt cutycapt = new Cutycapt(new File("/usr/bin/cutycapt"));
		Options options = new Options();
		int exitCode = cutycapt.run(options, url, out);
		assert exitCode == 0;
	}
}
