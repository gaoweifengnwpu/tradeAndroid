package com.trade.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by GWF on 2018/3/9.
 */

public class DynamicReceiver extends BroadcastReceiver {

    /**
     * 动态action
     */
    private static final String DYNAMICACTION = "com.byread.dynamic";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e( "MainActivity", "接收自定义动态注册广播消息" );
        if (intent.getAction().equals( DYNAMICACTION )) {
            String msg = intent.getStringExtra( "msg" );
            Toast.makeText( context, msg, Toast.LENGTH_SHORT ).show();

        }
    }
}
