package com.example.phototest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class TakePhotoActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.take_photo__btn)
    Button take_photo_btn;

    @BindView(R.id.open_file__btn)
    Button open_file_btn;

    @BindView(R.id.photo_album__btn)
    Button photo_album_btn;

    @BindView(R.id.result_img)
    ImageView result_img;

    private static final int READ_REQUEST_CODE = 42;
    private static final int READ_TAKE_PHOTO = 101;
    private static final int READ_PHOTO_ALBUM = 102;

    private static final int CAMERA_PERMISSION = 100;//檢測相機權限用

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takephoto);
        ButterKnife.bind(this);

        take_photo_btn.setOnClickListener(this);
        open_file_btn.setOnClickListener(this);
        photo_album_btn.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.photo_album__btn:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, READ_PHOTO_ALBUM);
                break;

            case R.id.take_photo__btn:
                Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoIntent, READ_TAKE_PHOTO);
                break;

            case R.id.open_file__btn:
                Intent fileIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                fileIntent.addCategory(Intent.CATEGORY_OPENABLE);
                fileIntent.setType("image/*");
                startActivityForResult(fileIntent, READ_REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data == null) {
            Toast.makeText(TakePhotoActivity.this, "Get Data is null", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (requestCode) {
            case READ_REQUEST_CODE:
            case READ_PHOTO_ALBUM:
                Uri uri = data.getData();
                result_img.setImageURI(uri);
                break;

            case READ_TAKE_PHOTO:
                Bundle getImage = data.getExtras();
                Bitmap image_bitmap = (Bitmap) getImage.get("data");
                result_img.setImageBitmap(image_bitmap);
                break;
        }
    }
}
