package com.example.nick.animehelper.presenter.asyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.example.nick.animehelper.model.internalModel.StaticVars;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ImageDownloadingRunnable implements Runnable {

    private ImageView imageView;
    private String url;
    private Handler handler;
    Message message;

    public class MyBundle{
        ImageView view;
        Bitmap bmp;

        public MyBundle(ImageView view, Bitmap bmp) {
            this.view = view;
            this.bmp = bmp;
        }

        public ImageView getView() {
            return view;
        }

        public void setView(ImageView view) {
            this.view = view;
        }

        public Bitmap getBmp() {
            return bmp;
        }

        public void setBmp(Bitmap bmp) {
            this.bmp = bmp;
        }
    }

    public ImageDownloadingRunnable(ImageView imageView, String urlWithImage, Handler handler) {
        this.imageView = imageView;
        this.url = urlWithImage;
        this.handler = handler;
    }

    @Override
    public void run() {
        try{
            message = new Message();
            URL imageUrl = new URL(url);
            Bitmap bmp = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
            MyBundle bundle = new MyBundle(imageView,bmp);
            message =  handler.obtainMessage(StaticVars.ANIME_SET_IMAGE,bundle);
            Log.d(StaticVars.LOG_TAG,"putting an image");
            handler.sendMessage(message);
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }





    }
}
