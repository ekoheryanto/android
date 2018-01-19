package app.loginregistersqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lazday Indonesia
 * on 8/27/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lazday_indonesia_sqlite";
    private static final int DATABASE_VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "CREATE TABLE lazday_indonesia_users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nama TEXT," +
                        "jns_kelamin TEXT, alamat TEXT, username TEXT, password TEXT );"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS lazday_indonesia_users");
    }
}
