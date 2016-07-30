package irolso.com.practica2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import irolso.com.practica2.sql.Notification;
import irolso.com.practica2.model.ModelListApp;
import irolso.com.practica2.sql.DataSource;

public class DetalleActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Desarrollador,Detalle;
    EditText DesarrolladorEdit,DetalleEdit,NombreEdit;
    CheckBox checkBoxEdit;
    LinearLayout detallelayout,editlayout;
    int id_recibido;
    DataSource dataSource;
    ModelListApp modelListApp;
    Button Abrir,Actualizar,Desistalar,Editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        recibirdatos();
        detallelayout = (LinearLayout) findViewById(R.id.DetalleActivityLayoutAgregar);
        editlayout = (LinearLayout) findViewById(R.id.DetalleActivityLayoutEditar);
        editlayout.setVisibility(LinearLayout.GONE);
        DesarrolladorEdit = (EditText) findViewById(R.id.DetalleActivityEditarDesarrollador);
        DetalleEdit = (EditText) findViewById(R.id.DetalleActivityEditarDetalle);
        NombreEdit = (EditText) findViewById(R.id.DetalleActivityEditarNombre);
        checkBoxEdit = (CheckBox) findViewById(R.id.DetalleActivityEditarCheckbox);
        modelListApp = new ModelListApp();
        dataSource = new DataSource(this);
        modelListApp = dataSource.llenarDetalles(id_recibido);
        Desarrollador = (TextView) findViewById(R.id.DetalleActivityDesarrollador);
        Detalle = (TextView) findViewById(R.id.DetalleActivityDetalle);
        Desarrollador.setText(modelListApp.Desarrollador);
        Detalle.setText(modelListApp.Detalle);
        setTitle(modelListApp.Nombre);

        Abrir = (Button) findViewById(R.id.DetalleActivityAbrir);
        Actualizar=(Button) findViewById(R.id.DetalleActivityActualizar);
        Desistalar=(Button) findViewById(R.id.DetalleActivityDesistanlar);
        Editar =(Button) findViewById(R.id.DetalleActivityEditar);

        if(modelListApp.Update ==1){
            Actualizar.setEnabled(false);
        }

        findViewById(R.id.DetalleActivityAbrir).setOnClickListener(this);
        findViewById(R.id.DetalleActivityActualizar).setOnClickListener(this);
        findViewById(R.id.DetalleActivityDesistanlar).setOnClickListener(this);
        findViewById(R.id.DetalleActivityEditar).setOnClickListener(this);
        findViewById(R.id.DetalleActivityEditarSave).setOnClickListener(this);
    }

    public void recibirdatos(){
        Bundle bundle = this.getIntent().getExtras();
        id_recibido = bundle.getInt("id");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetalleActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.DetalleActivityAbrir:
                String url = "https://play.google.com/store/search?q="+modelListApp.Nombre;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;

            case R.id.DetalleActivityActualizar:

                modelListApp.ID = id_recibido;
                modelListApp.Update = 1;
                dataSource.Actualizar(modelListApp);
                modelListApp = dataSource.llenarDetalles(id_recibido);

                if(modelListApp.Update == 1){
                    Actualizar.setEnabled(false);
                }

                startService(new Intent(getApplicationContext(), Notification.class));
                break;

            case R.id.DetalleActivityDesistanlar:
                modelListApp.ID = id_recibido;
                dataSource.deleteItem(modelListApp);
                Actualizar.setEnabled(false);
                Desistalar.setEnabled(false);
                Editar.setEnabled(false);
                Abrir.setEnabled(false);
                break;

            case R.id.DetalleActivityEditar:
                editlayout.setVisibility(LinearLayout.VISIBLE);
                detallelayout.setVisibility(LinearLayout.GONE);
                DesarrolladorEdit.setText(modelListApp.Desarrollador);
                DetalleEdit.setText(modelListApp.Detalle);
                NombreEdit.setText(modelListApp.Nombre);
                if(modelListApp.Update==1) {
                    checkBoxEdit.setChecked(true);
                    checkBoxEdit.setEnabled(false);
                }else if(modelListApp.Update==0)
                    checkBoxEdit.setChecked(false);
                break;

            case R.id.DetalleActivityEditarSave:

                if(!NombreEdit.getText().toString().equals("")&&!DesarrolladorEdit.getText().toString().equals("")&&!DetalleEdit.getText().toString().equals("")) {

                modelListApp.ID = id_recibido;
                modelListApp.Nombre = NombreEdit.getText().toString();
                modelListApp.Desarrollador = DesarrolladorEdit.getText().toString();
                modelListApp.Detalle = DetalleEdit.getText().toString();
                if(checkBoxEdit.isChecked()) {
                 modelListApp.Update = 1;
                    }else if(modelListApp.Update==0)
                    modelListApp.Update = 0;
                dataSource.editarApp(modelListApp);

                modelListApp = dataSource.llenarDetalles(id_recibido);
                Desarrollador.setText(modelListApp.Desarrollador);
                Detalle.setText(modelListApp.Detalle);
                setTitle(modelListApp.Nombre);
                    if(modelListApp.Update ==1){
                        Actualizar.setEnabled(false);
                    }
                editlayout.setVisibility(LinearLayout.GONE);
                detallelayout.setVisibility(LinearLayout.VISIBLE);

                }else
                    Toast.makeText(getApplicationContext(),getString(R.string.falta), Toast.LENGTH_SHORT).show();
                break;
        }

        }
}
