package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AlgorithmWeb extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_web);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.shafaetsplanet.com/?fbclid=IwAR1dWzzww3sqSSdnnjk0ORH1wX1RIK25-1gMB_RNCdov4yyx000VStUfjI4");
        myWebView.setWebViewClient(new WebViewClient());
    }
}