package com.example.camerafilereadasyncexercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class AsyncImage extends AsyncTask<File, Void, Bitmap>{

    WeakReference<ImageView> imageViewWeakReference;

    public AsyncImage(ImageView imageView) {
        imageViewWeakReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(File... files) {
        File fileToDecode = files[0];

        double heapRemaining = Runtime.getRuntime().freeMemory(); //amount available in heap
        Log.i("MEM REM", Double.toString(heapRemaining));

        try {
            Bitmap bitmap = BitmapFactory.decodeFile(fileToDecode.getPath());
            // Bitmap bitmap = BitmapFactory.decodeFile(fileToDecode); // Skal være path og ikke filen??

            return bitmap;
        } catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        final ImageView imv = imageViewWeakReference.get();
        if(imv != null){
            imv.setImageBitmap(bitmap);

        }
    }
}
