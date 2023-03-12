package com.example.velocitypopup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener una referencia al botón
        Button button = findViewById(R.id.button);

        // Configurar el OnClickListener del botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflar el diseño del popup
                View popupView = getLayoutInflater().inflate(R.layout.popup_layout, null);

                // Obtener una referencia al ImageView en el diseño del popup
                ImageView imageView = popupView.findViewById(R.id.image_view);

                // Cargar la imagen desde la URL utilizando Glide
                Glide.with(MainActivity.this)
                        .load("https://www.amazon.com/images/P/B07Z9PPYSH")
                        .placeholder(R.drawable.placeholder) // Agregar un placeholder mientras se carga la imagen
                        .error(R.drawable.error) // Agregar una imagen de error en caso de que no se pueda cargar la imagen
                        .into(imageView);

                // Crear el PopupWindow
                PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Mostrar el PopupWindow en el centro de la pantalla
                popupWindow.showAtLocation(button, Gravity.CENTER, 0, 0);
            }
        });
    }
}
