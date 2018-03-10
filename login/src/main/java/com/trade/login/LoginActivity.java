package com.trade.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fedming.bottomnavigationdemo.HomeActivity;
import com.trade.constant.Constant;
import com.trade.utils.HttpUtil;
import com.trade.utils.JsonTools;
import com.trade.utils.ResultMessage;

import org.apache.http.protocol.HTTP;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {

    private Button btn;
    private EditText usernameEdt;
    private EditText passwordEdt;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        btn = (Button) this.findViewById( R.id.email_sign_in_button );
        usernameEdt = (EditText) this.findViewById( R.id.email );
        passwordEdt = (EditText) this.findViewById( R.id.password );

        dialog = new ProgressDialog( this );
        dialog.setTitle( "提示" );
        dialog.setMessage( "正在登录,请稍候..." );
        btn.setOnClickListener( new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // 去除输入值的空格
                String name_value = usernameEdt.getText().toString().trim();
                String pswd_value = passwordEdt.getText().toString().trim();

                Map<String, String> params = new HashMap<String, String>();
                params.put( "url", Constant.LOGIN_PATH );
                params.put( "username", name_value );
                params.put( "password", pswd_value );

                Log.i( "username", name_value );
                Log.i( "password", pswd_value );
                try {
                    String result = new LoginAsyncTask().execute( params ).get();
                    ResultMessage message = JsonTools.getResultMessage( result );
                    if (message.getResultCode() == 1) {
                        Toast.makeText( LoginActivity.this, message.getResultMessage(), 1 ).show();

                        Intent intent = new Intent( LoginActivity.this, HomeActivity.class );
                        startActivity( intent );
                    }

                    System.out.println( "--->>" + result );
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        } );
    }

    // 异步任务
    class LoginAsyncTask extends AsyncTask<Map<String, String>, Void, String> {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(Map<String, String>... params) {
            // TODO Auto-generated method stub
            Map<String, String> map = params[0];
            //表单数据
            Map<String, Object> params2 = new HashMap<String, Object>();
            params2.put( "username", map.get( "username" ) );
            params2.put( "password", map.get( "password" ) );
            String result = HttpUtil.sendPostMethod( params2, HTTP.UTF_8 );
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            //获得服务器返回信息成功后
            // TODO Auto-generated method stub
            super.onPostExecute( result );
            dialog.dismiss();
        }

    }


}