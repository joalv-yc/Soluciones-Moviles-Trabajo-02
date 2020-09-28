package com.example.practica02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView txresultnombre, txresultapellido, txresultdni, txresultdireccion, txresultcelular;
    ImageView foto;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent receptor = getIntent();

        String nombre = getIntent().getStringExtra("danombre");
        String apellidos = getIntent().getStringExtra("daapellidos");
        String dni = getIntent().getStringExtra("dadni");
        String direccion = getIntent().getStringExtra("dadireccion");
        String celular = getIntent().getStringExtra("dacelular");

        Bitmap bitmap = (Bitmap) receptor.getParcelableExtra("foto");
        ImageView resultfoto = (ImageView)findViewById(R.id.imgUsuariofinal);
        resultfoto.setImageBitmap(bitmap);

        txresultnombre = findViewById(R.id.ResultadoNombre);
        txresultnombre.setText(nombre);

        txresultapellido = findViewById(R.id.ResultadoApellidos);
        txresultapellido.setText(apellidos);

        txresultdni = findViewById(R.id.ResultadosDNI);
        txresultdni.setText(dni);

        txresultdireccion = findViewById(R.id.ResultadoDireccion);
        txresultdireccion.setText(direccion);

        txresultcelular = findViewById(R.id.ResultadoCelular);
        txresultcelular.setText(celular);



    }
}