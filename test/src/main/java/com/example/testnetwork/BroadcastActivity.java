package com.example.testnetwork;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.trade.broad.ScreenStatusReceiver;

public class BroadcastActivity extends Activity {

    /**
     * 发送静态广播按钮
     */
    private Button sendStaticBtn;

    /**
     * 发送动态广播按钮
     */
    private Button sendDynamicBtn;

    /**
     * 发送系统广播按钮
     */
    private Button sendSystemBtn;

    /**
     * 静态action
     */
    private static final String STATICACTION = "com.byread.static";

    /**
     * 动态action
     */
    private static final String DYNAMICACTION = "com.byread.dynamic";

    /**
     * 屏幕被打开之后的广播
     */
    private static final String SYSTEMACTION = Intent.ACTION_SCREEN_ON;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.broad );
        this.mContext = this;
        sendStaticBtn = (Button) findViewById( R.id.send_static );
        sendDynamicBtn = (Button) findViewById( R.id.send_dynamic );
        sendSystemBtn = (Button) findViewById( R.id.send_system );
        sendStaticBtn.setOnClickListener( new MyOnClickListener() );
        sendDynamicBtn.setOnClickListener( new MyOnClickListener() );
        sendSystemBtn.setOnClickListener( new MyOnClickListener() );
        // 发送系统动态注册广播消息
        Log.e( "MainActivity", "发送系统动态注册广播消息" );
        Intent intent = new Intent();
        intent.setAction( SYSTEMACTION );
        intent.putExtra( "msg", "亮屏" );
//
//        //申请读取短信的权限
//        PermissionUtil.requestPermission(mContext, Manifest.permission.READ_SMS,
//                RequestPermissionType.REQUEST_CODE_ASK_READ_SMS);
//
//        PermissionUtil.requestPermission(mContext, Manifest.permission.RECEIVE_SMS,
//                RequestPermissionType.REQUEST_CODE_ASK_RECEIVE_SMS);
    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 发送自定义静态注册广播消息
            if (v.getId() == R.id.send_static) {
                Log.e( "MainActivity", "发送自定义静态注册广播消息" );
                Intent intent = new Intent();
                intent.setAction( STATICACTION );
                intent.putExtra( "msg", "接收静态注册广播成功！" );
                sendBroadcast( intent );
            }
            // 发送自定义动态注册广播消息
            else if (v.getId() == R.id.send_dynamic) {
                Log.e( "MainActivity", "发送自定义动态注册广播消息" );
                Intent intent = new Intent();
                intent.setAction( DYNAMICACTION );
                intent.putExtra( "msg", "接收动态注册广播成功！" );
                sendBroadcast( intent );
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e( "MainActivity", "注册广播事件" );
        // 注册自定义动态广播消息
        IntentFilter filter_dynamic = new IntentFilter();
        filter_dynamic.addAction( DYNAMICACTION );
        registerReceiver( dynamicReceiver, filter_dynamic );
        // 注册系统自定义动态广播消息
        registSreenStatusReceiver();
    }

    private void registSreenStatusReceiver() {
        // 屏幕状态广播
        ScreenStatusReceiver screenStatusReceiver;
        // 屏幕状态广播初始化
        screenStatusReceiver = new ScreenStatusReceiver();
        IntentFilter screenStatusIF = new IntentFilter();
        screenStatusIF.addAction( Intent.ACTION_SCREEN_ON );
        screenStatusIF.addAction( Intent.ACTION_SCREEN_OFF );
        // 注册
        registerReceiver( screenStatusReceiver, screenStatusIF );
    }

    private BroadcastReceiver dynamicReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e( "MainActivity", "接收自定义动态注册广播消息" );
            if (intent.getAction().equals( DYNAMICACTION )) {
                String msg = intent.getStringExtra( "msg" );
                Toast.makeText( context, msg, Toast.LENGTH_SHORT ).show();
            }
        }
    };

}