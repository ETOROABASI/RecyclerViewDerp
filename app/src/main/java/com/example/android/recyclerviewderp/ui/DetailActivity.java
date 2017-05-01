package com.example.android.recyclerviewderp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.recyclerviewderp.R;

public class DetailActivity extends AppCompatActivity {


    private static final String BUNDLE_EXTRA = "BUNDLE_EXTRA";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";      // I used the string directly instead


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRA);

        ((TextView)findViewById(R.id.quote_text)).setText(extras.getString(EXTRA_QUOTE));

        ((TextView)findViewById(R.id.quote_attribution)).setText(extras.getString("EXTRA_ATTR"));
    }
}
