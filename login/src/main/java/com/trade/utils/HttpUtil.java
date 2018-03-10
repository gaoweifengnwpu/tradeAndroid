package com.trade.utils;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by GWF on 2018/1/28.
 */

public class HttpUtil {

    public HttpUtil() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @param params
     * @param encoding
     * @return
     */
    public static String sendPostMethod(Map<String, Object> params, String encoding) {
        String path = "http://192.168.0.109:8090/login";
        HttpPost httpPost = new HttpPost( path );
        HttpClient httpClient = new DefaultHttpClient();

        String result = "";
        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
        try {
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String name = entry.getKey();
                    //如果出现乱码问题，则修改
                    String value = URLEncoder.encode( entry.getValue().toString(), encoding );
                    BasicNameValuePair valuePair = new BasicNameValuePair( name, value );
                    data.add( valuePair );
                }
            }

            // 此处为了避免中文乱码，保险起见要加上编码格式
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity( data );
            httpPost.setEntity( encodedFormEntity );
            HttpResponse httpResponse = httpClient.execute( httpPost );
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString( httpResponse.getEntity(), encoding );
            }
//            Log.e( "network","fail" );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i( "post_exception", e.toString() );
        }
        return result;
    }
}