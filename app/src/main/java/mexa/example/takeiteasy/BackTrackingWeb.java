package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BackTrackingWeb extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_tracking_web);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.geeksforgeeks.org/backtracking-introduction/?fbclid=IwAR1hw4ewsJo2Hla6dhRU8JRLSDCJSUH4e1W403uGDAOaIzIbVfQgIKg-Mz0");
        myWebView.setWebViewClient(new WebViewClient());
    }
}