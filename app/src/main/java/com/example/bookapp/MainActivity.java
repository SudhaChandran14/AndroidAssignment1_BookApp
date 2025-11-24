package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private EditText etTitle, etAuthor, etYear;
    private Button btnSubmit;
    
    private static final String STATE_TITLE = "title";
    private static final String STATE_AUTHOR = "author";
    private static final String STATE_YEAR = "year";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        etYear = findViewById(R.id.etYear);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Restore state if exists
        if (savedInstanceState != null) {
            etTitle.setText(savedInstanceState.getString(STATE_TITLE, ""));
            etAuthor.setText(savedInstanceState.getString(STATE_AUTHOR, ""));
            etYear.setText(savedInstanceState.getString(STATE_YEAR, ""));
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString().trim();
                String author = etAuthor.getText().toString().trim();
                String year = etYear.getText().toString().trim();

                if (title.isEmpty() || author.isEmpty() || year.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_fill_fields, Toast.LENGTH_SHORT).show();
                    return;
                }

                Book book = new Book(title, author, year);
                Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, etTitle.getText().toString());
        outState.putString(STATE_AUTHOR, etAuthor.getText().toString());
        outState.putString(STATE_YEAR, etYear.getText().toString());
    }
}
