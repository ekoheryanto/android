package app.loginregistersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Lazday Indonesia
 * on 8/27/2017.
 */

public class LazdayIndonesia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lazday_indonesia);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://m.tokopedia.com/lazdayid/tutorial-membuat-aplikasi-android-dengan-android-studio-untuk-pemula");
//        webView.loadUrl("http://lazday.com");

        getSupportActionBar().setTitle("Iklan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
