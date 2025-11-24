package com.example.bookapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookDetailsActivity extends AppCompatActivity {

    private TextView tvBookDetails;
    private ImageView ivBookPhoto;
    private Button btnTakePhoto, btnNext;
    private Book book;
    private Bitmap photoBitmap;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String STATE_PHOTO = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        tvBookDetails = findViewById(R.id.tvBookDetails);
        ivBookPhoto = findViewById(R.id.ivBookPhoto);
        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        btnNext = findViewById(R.id.btnNext);

        // Get book object from intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("book")) {
            book = intent.getParcelableExtra("book");
            displayBookDetails();
        }

        // Restore photo if exists
        if (savedInstanceState != null) {
            photoBitmap = savedInstanceState.getParcelable(STATE_PHOTO);
            if (photoBitmap != null) {
                ivBookPhoto.setImageBitmap(photoBitmap);
                ivBookPhoto.setVisibility(View.VISIBLE);
            }
        }

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } else {
                    Toast.makeText(BookDetailsActivity.this, R.string.toast_camera_not_available, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetailsActivity.this, IntentsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayBookDetails() {
        String details = getString(R.string.book_title_label) + " " + book.getTitle() + "\n" +
                        getString(R.string.book_author_label) + " " + book.getAuthor() + "\n" +
                        getString(R.string.book_year_label) + " " + book.getYear();
        tvBookDetails.setText(details);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                photoBitmap = (Bitmap) data.getExtras().get("data");
                ivBookPhoto.setImageBitmap(photoBitmap);
                ivBookPhoto.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (photoBitmap != null) {
            outState.putParcelable(STATE_PHOTO, photoBitmap);
        }
    }
}
