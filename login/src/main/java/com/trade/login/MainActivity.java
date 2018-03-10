//
//package com.trade.login;
//
//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private Button btn;
//    private EditText usernameEdt;
//    private EditText passwordEdt;
//    private ProgressDialog dialog;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate( savedInstanceState );
//        setContentView( R.layout.login_activity );
//        btn = (Button) this.findViewById( R.id.login_btn );
//        usernameEdt = (EditText) this.findViewById( R.id.login_account );
//        passwordEdt = (EditText) this.findViewById( R.id.login_password );
//        btn.setOnClickListener( this );
//    }
//
//    Handler handler = new Handler( new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
////			执行接收Message后的逻辑
//                    break;
//            }
//            return true;
//        }
//    } );
//
//    @Override
//    public void onClick(View v) {
//        sendRequestWithHttpClient();
//    }
//
//    public void sendRequestWithHttpClient() {
//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // 去除输入值的空格
//                    String name_value = usernameEdt.getText().toString().trim();
//                    String pswd_value = passwordEdt.getText().toString().trim();
//                    Map<String, String> params = new HashMap<String, String>();
//                    params.put( "username", name_value );
//                    params.put( "password", pswd_value );
//                    Log.i( "username", name_value );
//                    Log.i( "password", pswd_value );
//                    HttpClient httpClient = new DefaultHttpClient();
//                    HttpPost httpGet = new HttpPost( "http://192.168.0.109:8090/login" );
//                    HttpResponse httpResponse = httpClient.execute( httpGet );
//                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                        //请求和响应都成功了
////                        HttpEntity entity = httpResponse.getEntity();
////                        String response = EntityUtils.toString( entity, "utf-8" );
//                        //使用Message
//                        Message message = new Message();
//                        message.what = 1;
//                        handler.sendMessage( message );
//                    }
//
//                } catch (Exception e) {
//
//                } finally {
//
//                }
//
//            }
//        } ).start();
//
//    }
//
//}