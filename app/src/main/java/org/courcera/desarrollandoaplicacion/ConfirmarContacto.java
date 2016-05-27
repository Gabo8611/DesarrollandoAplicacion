package org.courcera.desarrollandoaplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class ConfirmarContacto extends AppCompatActivity {

    private Button btnEditar;
    private TextView confirmarNombre, confirmarNacimiento, confirmarTelefono, confirmarCorreo, confirmarDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_contacto);

        //Asignacion de Views a variables
        btnEditar = (Button)findViewById(R.id.btnEditar);

        confirmarNombre = (TextView)findViewById(R.id.confirmarNombre);
        confirmarNacimiento = (TextView)findViewById(R.id.confirmarNacimiento);
        confirmarTelefono = (TextView)findViewById(R.id.confirmarTelefono);
        confirmarCorreo = (TextView)findViewById(R.id.confirmarCorreo);
        confirmarDescripcion = (TextView)findViewById(R.id.confirmarDescripcion);

        //Recuperacion de parametros en Intent
        Bundle parametros = getIntent().getExtras();

        final String nombre = parametros.getString("Nombre");
        final String Year = parametros.getString("Year");
        final String Month = parametros.getString("Month");
        final String Day = parametros.getString("Day");
        final String nacimiento = Year+"/"+Month+"/"+Day;

        final String telefono = parametros.getString("Telefono");
        final String correo = parametros.getString("Correo");
        final String descripcion = parametros.getString("Descripcion");

        //Asignar paramaetros Intent a Views

        confirmarNombre.setText(nombre);
        confirmarNacimiento.setText(getResources().getString(R.string.confirmar_nacimiento) + nacimiento);
        confirmarTelefono.setText(getResources().getString(R.string.confirmar_telefono) + telefono);
        confirmarCorreo.setText(getResources().getString(R.string.confirmar_correo) + correo);
        confirmarDescripcion.setText(getResources().getString(R.string.confirmar_descripcion) + descripcion);



        btnEditar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(ConfirmarContacto.this, MainActivity.class);
                i.putExtra("Nombre",nombre);
                i.putExtra("Year",Year);
                i.putExtra("Month",Month);
                i.putExtra("Day",Day);
                i.putExtra("Telefono",telefono);
                i.putExtra("Correo",correo);
                i.putExtra("Descripcion",descripcion);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
