package com.example.testnetwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trade.service.SimpleService;

public class ServiceActivity extends Activity implements View.OnClickListener {

    private Button startService;

    private Button stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.service );
        startService = (Button) findViewById( R.id.start_service );
        stopService = (Button) findViewById( R.id.stop_service );
        startService.setOnClickListener( this );
        stopService.setOnClickListener( this );
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent startIntent = new Intent( this, SimpleService.class );
                startService( startIntent );
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent( this, SimpleService.class );
                stopService( stopIntent );
                break;
            default:
                break;
        }
    }

}