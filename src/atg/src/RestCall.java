package atg.src;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCall<C> {
	private String url;
	private final Class<C> type;

	public RestCall(String baseUrl, Class<C> type) {
		this.url = baseUrl;
		this.type = type;
	}

	public C get() {
		return get(null, null);
	}

	public C get(String path) {
		return get(path, null);
	}

	public C get(HashMap<String, String> parameters) {
		return get(null, parameters);
	}

	public C get(String path, HashMap<String, String> parameters) {
		HttpURLConnection conn = null;
		String query = null;
		try {
			if (parameters != null && parameters.size() != 0) {
				query = "";
				Iterator<String> i = parameters.keySet().iterator();
				while (i.hasNext()) {
					String parm = i.next();
					String value = parameters.get(parm);
					query += parm + "=" + value;
				}
			}

			URL bu = new URL(url);
			URI uri = new URI(bu.getProtocol(), null, bu.getHost(),
					bu.getPort(), bu.getPath()
							+ (path == null ? "" : "/" + path), query, null);
			URL url = uri.toURL();
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			// BufferedReader br = new BufferedReader(new InputStreamReader(
			// (conn.getInputStream())));
			//
			// String output;
			// String obj = "";
			// System.out.println("Output from Server .... \n");
			// while ((output = br.readLine()) != null) {
			// obj += output;
			// System.out.println(output);
			// }

			ObjectMapper mapper = new ObjectMapper();
			C ret = mapper.readValue(conn.getInputStream(), type);
			conn.disconnect();
			return ret;
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (URISyntaxException e) {

			e.printStackTrace();

		}
		return null;
	}
}
