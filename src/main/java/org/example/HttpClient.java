package org.example;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 *
 */
public class HttpClient
{
    // one instance, reuse
    private final OkHttpClient httpClient = new OkHttpClient();

    static String url = "http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Oak";
    public static void main( String[] args ) throws Exception {
        System.out.println("Example by ApacheHttpClient");
        ApacheHttpClient.sendGet(new URI(url));
        ApacheHttpClient.sendPost();
        System.out.println("Example by OkHttpClient");
        MyOkHttpClient.sendGet();
        MyOkHttpClient.sendPost();
    }

}
