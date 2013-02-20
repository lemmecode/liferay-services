import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;

public class UpdatePortalPreferences {
	public static void main(String args[]) throws Exception {
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials("test@liferay.com", "test"));
		AuthCache authCache = new BasicAuthCache();

		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		BasicHttpContext ctx = new BasicHttpContext();
		ctx.setAttribute(ClientContext.AUTH_CACHE, authCache);

		HttpPost post = new HttpPost(
				"/api/secure/jsonws/company/update-preferences");
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		params.add(new BasicNameValuePair("companyId", "10154"));
		params.add(new BasicNameValuePair(
				"+properties:com.liferay.portal.kernel.util.UnicodeProperties",
				""));
		params.add(new BasicNameValuePair(
				"properties.*this[ldap.auth.enabled]", "false"));
		params.add(new BasicNameValuePair(
				"properties.*this[ldap.auth.required]", "false"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
		post.setEntity(entity);
		HttpResponse resp = httpclient.execute(targetHost, post, ctx);
		resp.getEntity().writeTo(System.out);
		httpclient.getConnectionManager().shutdown();

	}
}
