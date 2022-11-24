package com.example.proyecto055;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnCamara;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamara = findViewById(R.id.btnCamara);
        imgView = findViewById(R.id.imageView);

        btnCamara.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camaraLaucher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        }));
    }
 ActivityResultLauncher<Intent> camaraLaucher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
     @Override
     public void onActivityResult(ActivityResult result) {
         if (result.getResultCode() == RESULT_OK){
             Bundle extras = result.getData().getExtras();
             Bitmap imgBitmap = (Bitmap) extras.get("data");
             imgView.setImageBitmap(imgBitmap);
         }
     }
 });

}