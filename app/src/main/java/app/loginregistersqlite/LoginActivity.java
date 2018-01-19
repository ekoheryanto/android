package app.loginregistersqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lazday Indonesia
 * on 8/27/2017.
 */

public class LoginActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqliteHelper = new SqliteHelper(this);

        final EditText username = (EditText) findViewById(R.id.edtUsername);
        final EditText password = (EditText) findViewById(R.id.edtPassword);
        Button login            = (Button) findViewById(R.id.btnLogin);
        final TextView hasil    = (TextView) findViewById(R.id.txtResult);
        TextView ads            = (TextView) findViewById(R.id.txtAds);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase database = sqliteHelper.getReadableDatabase();
                cursor = database.rawQuery(
                        "SELECT * FROM lazday_indonesia_users " +
                        "WHERE username='" + username.getText().toString() +  "' AND password='" + password.getText().toString() +"' "
                , null);
                cursor.moveToFirst();

                int i;
                for (i=0; i < cursor.getCount(); i++){
                    cursor.moveToPosition(i);

                    hasil.setText(
                            "  Nama :\n" + cursor.getString(1) +
                            "\n\n  Jenis kelamin :\n" + cursor.getString(2) +
                            "\n\n  Alamat :\n" + cursor.getString(3)
                    );
                }

                if (i == 0){
                    hasil.setText("Hasil tidak di temukan");
                    Toast.makeText(getApplicationContext(), "Login gagal",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login berhasil",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( LoginActivity.this, LazdayIndonesia.class));
            }
        });

        getSupportActionBar().setTitle("Login SQLite");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
