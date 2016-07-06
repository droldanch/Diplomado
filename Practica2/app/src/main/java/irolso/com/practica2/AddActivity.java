package irolso.com.practica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import irolso.com.practica2.model.ModelListApp;
import irolso.com.practica2.sql.DataSource;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Nombre,Desarrollador,Detalle;
    CheckBox checkBox;
    Button button;
    DataSource dataSource;
    ModelListApp modelListApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        modelListApp = new ModelListApp();
        dataSource = new DataSource(this);
        Nombre = (TextView) findViewById(R.id.AddActivityNombre);
        Desarrollador = (TextView) findViewById(R.id.AddActivityDesarrollador);
        Detalle = (TextView) findViewById(R.id.AddActivityDetalle);
        checkBox = (CheckBox) findViewById(R.id.AddActivityCheckbox);
        findViewById(R.id.AddActivitySave).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AddActivitySave:
                if(!Nombre.getText().toString().equals("")&&!Desarrollador.getText().toString().equals("")&&!Detalle.getText().toString().equals("")) {
                    int min = 1;
                    int max = 9;

                    Random r = new Random();
                    int i1 = r.nextInt(max - min + 1) + min;
                modelListApp.Nombre = Nombre.getText().toString();
                modelListApp.Desarrollador = Desarrollador.getText().toString();
                modelListApp.Detalle = Detalle.getText().toString();
                if(checkBox.isChecked())
                    modelListApp.Update = 1;
                else
                    modelListApp.Update= 0;
                modelListApp.Instalada = 1;
                    modelListApp.Imagen = i1;
                dataSource.saveItem(modelListApp);
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                }else{
                    Toast.makeText(getApplicationContext(),getString(R.string.falta), Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
