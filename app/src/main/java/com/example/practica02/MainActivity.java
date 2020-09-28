package com.example.practica02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {



    public static final int CAMERA_PIC_REQUEST = 1; //Para el funcionamiento de la camara
    EditText ET_Nombre, ET_Apellidos, ET_DNI, ET_Direccion, ET_Celular;
    ImageView foto;
    String[] direccion = new String[60];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView direccion = (TextView) findViewById(R.id.edt_Direccion);


        Button btn_Ubicar = (Button) findViewById(R.id.btn_Mapa);
        btn_Ubicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0.0?q="+ direccion.getText());
                Intent locationIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(locationIntent);
            }
        });

        Button botonGuardar = (Button)findViewById(R.id.btnGuardar);

        ((Button) findViewById(R.id.btnCapturar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camaraIntent, CAMERA_PIC_REQUEST);
            }
        });

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ET_Nombre = (EditText)findViewById(R.id.edt_Nombre);
                ET_Apellidos = (EditText)findViewById(R.id.edt_Apellidos);
                ET_DNI = (EditText)findViewById(R.id.edt_DNI);
                ET_Direccion = (EditText)findViewById(R.id.edt_Direccion);
                ET_Celular = (EditText)findViewById(R.id.edt_Celular);
                foto = (ImageView)findViewById(R.id.imgUsuario);

                Intent intent = new Intent(getApplicationContext(),Resultado.class);

                Bitmap bitmap = ((BitmapDrawable)foto.getDrawable()).getBitmap();

                getIntent().putExtra("danombre",ET_Nombre.getText().toString());
                getIntent().putExtra("daapellidos",ET_Apellidos.getText().toString());
                getIntent().putExtra("dadni",ET_DNI.getText().toString());
                getIntent().putExtra("dadireccion",ET_Direccion.getText().toString());
                getIntent().putExtra("dacelular",ET_Celular.getText().toString());
                intent.putExtra("foto",bitmap);

                intent.setType("/");
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent data) {
        super.onActivityResult(requestCode, resultcode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (resultcode == RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                ImageView iv_foto = (ImageView) findViewById(R.id.imgUsuario);
                iv_foto.setImageBitmap(bitmap);
            }
        }

    }


}