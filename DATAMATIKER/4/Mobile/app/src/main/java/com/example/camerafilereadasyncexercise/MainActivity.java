package com.example.camerafilereadasyncexercise;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.nio.channels.FileLockInterruptionException;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 12;
    private AsyncImage asyncImage;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionRequestCameraImages(); // Request WRITE_EXTERNAL_STORAGE permission

        imgView = findViewById(R.id.imgView);
        Button btnShowImage = (Button) findViewById(R.id.btnShowImage);

        asyncImage = new AsyncImage(imgView);



        final String FILENAME = "IMG_20190220_100758.jpg";

        File imageStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");

        final File imageFile = new File(imageStorageDir, FILENAME);

        btnShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncImage.execute(imageFile);
            }
        });
    }

    private void PermissionRequestCameraImages(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }
    }
}
