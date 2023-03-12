package com.example.velocitypopup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.content.BroadcastReceiver;


import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.example.velocitypopup.R;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Obtener la URL de la imagen del intent
        String imageUrl = intent.getStringExtra("IMAGE_URL");

        // Crear una instancia del PopupWindow
        View popupView = View.inflate(context, R.layout.popup_layout, null);
        ImageView imageView = popupView.findViewById(R.id.popup_image_view);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        popupWindow.setAnimationStyle(R.style.popup_animation);
        popupWindow.setFocusable(true);

        // Cargar la imagen desde la URL usando Glide
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

        // Mostrar el PopupWindow
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // Cerrar el PopupWindow después de 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                popupWindow.dismiss();
            }
        }, 3000);
    }
}
