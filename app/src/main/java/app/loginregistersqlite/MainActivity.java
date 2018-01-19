package app.loginregistersqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lazday Indonesia
 * on 8/27/2017.
 */

public class MainActivity extends AppCompatActivity {

    String _gender;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _gender = "";
        sqliteHelper = new SqliteHelper(this);

        final EditText name           = (EditText) findViewById(R.id.edtName);
        RadioGroup gender       = (RadioGroup) findViewById(R.id.grpGender);
        final EditText address        = (EditText) findViewById(R.id.edtAddress);
        final EditText username = (EditText) findViewById(R.id.edtUsername);
        final EditText password = (EditText) findViewById(R.id.edtPassword);
        final EditText confirm  = (EditText) findViewById(R.id.edtConfirm);
        Button register         = (Button) findViewById(R.id.btnRegister);
        TextView login          = (TextView) findViewById(R.id.txtLogin);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rdMale: _gender = "Laki-laki";
                        break;
                    case R.id.rdFemale: _gender = "Perempuan";
                        break;
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Username dan password tidak boleh kosong",
                            Toast.LENGTH_LONG).show();
                } else if (!password.getText().toString().equals(confirm.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Konfirmasi password dengan benar",
                            Toast.LENGTH_LONG).show();
                } else {
                    SQLiteDatabase database = sqliteHelper.getWritableDatabase();
                    database.execSQL("INSERT INTO lazday_indonesia_users (nama, jns_kelamin, alamat, username, password) " +
                            "VALUES('" + name.getText().toString() + "','" + _gender + "','" + address.getText().toString() +
                            "','" + username.getText().toString() + "','" + password.getText().toString() + "' )");
                    Toast.makeText(getApplicationContext(), "Regitrasi berhasil", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        getSupportActionBar().setTitle("Register SQLite");

        // ADS FROM LAZDAY.COM
        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (
                        InterruptedException e) { e.printStackTrace();
                } finally {
                    startActivity(new Intent( MainActivity.this, LazdayIndonesia.class) );
                }
            }
        };
        timerThread.start();
    }
}
