package com.deitel.villacis_diego_supletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText correo,contraseña;
    String textCedula,textContrasenia;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        correo = findViewById(R.id.editText_correo);
        contraseña = findViewById(R.id.editText_contrasenia);
        aceptar = findViewById(R.id.button_iniciar_sesion);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textCedula = correo.getText().toString();
                textContrasenia = contraseña.getText().toString();
                if(!Patterns.EMAIL_ADDRESS.matcher(textCedula).matches()){
                    correo.setError("Verfifica que el correo esté bien escrito");
                    correo.requestFocus();
                }else if (textContrasenia.isEmpty()){
                    contraseña.setError("Intente ingresar su contraseña");
                    contraseña.requestFocus();
                }else{
                    ingresarPrincipal(textCedula,textContrasenia);
                }
            }


        });
    }

    private void ingresarPrincipal(String correob,String contraseñab) {
        Toast.makeText(MainActivity.this, textCedula+textContrasenia,
                Toast.LENGTH_SHORT).show();

                    

    }

    @Override
    public void onStart() {
        super.onStart();
        UsuarioLogeado();
    }
    private void UsuarioLogeado(){
        if(mAuth != null){
            //Toast.makeText(MenuPrincipal.this, "Usuario logeado", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
            finish();
        }
    }

}