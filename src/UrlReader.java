/* UrlReader.java 
 * Created on Apr 12, 2006 
 */


import java.io.*;
import java.net.*;

public class UrlReader {
	private String	urlPath;
	private String	content;

	public UrlReader(String name) throws IOException {
		urlPath = name;
		readContent();

	}

	private static InputStream openStream(String urlpath) {
		InputStream stream = null;
		try {
			URL url = new URL(urlpath);
			stream = url.openStream();
			return stream;
		} catch (MalformedURLException e) {
			System.out.print("Something is wrong with the URL: " + urlpath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.print("There is a problem downloading from:  " + urlpath + "\n");
			// e.printStackTrace();
		}
		return stream;
	}

	private void readContent() {
		StringBuffer stuff = new StringBuffer();
		try {
			InputStream stream = openStream(urlPath);

			if (stream != null) {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(stream));
				String line;
				while ((line = reader.readLine()) != null) {
					stuff.append(line + "\n");
				}
				reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		content = stuff.toString();

	}

	public String getContent() {
		return content;
	}

}