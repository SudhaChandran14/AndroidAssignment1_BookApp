package com.example.bookapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class IntentsActivity extends AppCompatActivity {

    private EditText etUrl, etEmail, etSubject, etMessage;
    private Button btnOpenWeb, btnSendEmail;

    private static final String STATE_URL = "url";
    private static final String STATE_EMAIL = "email";
    private static final String STATE_SUBJECT = "subject";
    private static final String STATE_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        etUrl = findViewById(R.id.etUrl);
        etEmail = findViewById(R.id.etEmail);
        etSubject = findViewById(R.id.etSubject);
        etMessage = findViewById(R.id.etMessage);
        btnOpenWeb = findViewById(R.id.btnOpenWeb);
        btnSendEmail = findViewById(R.id.btnSendEmail);

        // Restore state if exists
        if (savedInstanceState != null) {
            etUrl.setText(savedInstanceState.getString(STATE_URL, ""));
            etEmail.setText(savedInstanceState.getString(STATE_EMAIL, ""));
            etSubject.setText(savedInstanceState.getString(STATE_SUBJECT, ""));
            etMessage.setText(savedInstanceState.getString(STATE_MESSAGE, ""));
        }

        // Intent 1: Open Web Browser
        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                if (url.isEmpty()) {
                    Toast.makeText(IntentsActivity.this, "Please enter a URL", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add https:// if missing
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://" + url;
                }

                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(IntentsActivity.this, "No browser available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Intent 2: Send Email
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String subject = etSubject.getText().toString().trim();
                String message = etMessage.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(IntentsActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:" + email));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(emailIntent);
                } catch (Exception e) {
                    Toast.makeText(IntentsActivity.this, "No email app available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_URL, etUrl.getText().toString());
        outState.putString(STATE_EMAIL, etEmail.getText().toString());
        outState.putString(STATE_SUBJECT, etSubject.getText().toString());
        outState.putString(STATE_MESSAGE, etMessage.getText().toString());
    }
}
