//package httpdemo;
//
//
//import android.app.Activity;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class LoginActivity extends Activity {
//    private EditText userName;
//    private EditText password;
//    private Button loadButton;
//    private Button registerButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate( savedInstanceState );
//        requestWindowFeature( Window.FEATURE_NO_TITLE );
//        setContentView( R.layout.login );
//        userName = (EditText) findViewById( R.id.editText );
//        password = (EditText) findViewById( R.id.editText3 );
//        loadButton = (Button) findViewById( R.id.button );
//        registerButton = (Button) findViewById( R.id.button2 );
//        loadButton.setTag( 1 );
//        loadButton.setOnClickListener( this );
//        registerButton.setTag( 2 );
//        registerButton.setOnClickListener( this );
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        int tag = (int) v.getTag();
//        switch (tag) {
//            case 1:
//                Intent intent1 = new Intent( LoginActivity.this, firstPage.class );
//                intent1.putExtra( "userName", userName.getText().toString() );
//                intent1.putExtra( "password", password.getText().toString() );
//                if (idCorrect()) {
//                    intent1.putExtra( "userName", userName.getText().toString() );
//                    intent1.putExtra( "password", password.getText().toString() );
//                    startActivity( intent1 );
//                }
//                break;
//
//            case 2:
//                Intent intent = new Intent( this, registerActivity.class );
//                startActivity( intent );
//                break;
//        }
//
//    }
//
//    public boolean idCorrect() {
//        DBHelper helper = new DBHelper( this, "test.db", null, 1 );
//        SQLiteDatabase database = helper.getWritableDatabase();
//        Cursor cursor = database.query( "***", new String[]{"name"}, "id=?", new String[]{"1"}, null, null, null );
//
//        while (cursor.moveToNext()) {
//            userName1 = cursor.getString( cursor.getColumnIndex( "userId" ) );
//            password1 = cursor.getString( cursor.getColumnIndex( "password" ) );
//            if (userName1.equals( userName.getText().toString() ) && password1.equals( password.getText().toString() )) {
//                return true;
//            }
//        }
//        Toast.makeText( this, "账号或密码错误，请重新输入", Toast.LENGTH_LONG ).show();
//        return false;
//
//    }
//
//
//}