package irolso.com.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import irolso.com.ejercicio.Model.Modelitem;
import irolso.com.ejercicio.Preferences.PreferencesUtil;
import irolso.com.ejercicio.sql.ItemDataSource;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Singin;
    EditText Edit_User,Edit_Pass;
    private ItemDataSource itemDataSource;
    CheckBox checkremember;
    private PreferencesUtil preferencesUtil;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        findViewById(R.id.Button_SingIn).setOnClickListener(this);
        findViewById(R.id.Button_Register).setOnClickListener(this);
        itemDataSource= new ItemDataSource(this);
        preferencesUtil= new PreferencesUtil(getApplicationContext());
        Modelitem modelItem = preferencesUtil.getUser();

        if(modelItem==null)
        {
            Toast.makeText(getApplicationContext(),R.string.welcome,Toast.LENGTH_SHORT).show();
        }else{
            checkremember.setChecked(true);
            Edit_User.setText(modelItem.name);
            Edit_Pass.setText(modelItem.pass);
            fecha.setText(getString(R.string.conexion) + modelItem.date);
        }
    }

    private void inicializarComponentes() {
        Edit_Pass = (EditText) findViewById(R.id.EditText_Pass);
        Edit_User = (EditText) findViewById(R.id.EditText_User);
        checkremember = (CheckBox) findViewById(R.id.CheckboxRemember);
        fecha = (TextView) findViewById(R.id.MainFecha);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button_SingIn:
                VerificarLogin();
                break;
            case R.id.Button_Register:
                Registrar();
                break;
        }
    }

    private void Registrar() {
        String user =Edit_User.getText().toString();
        String pass =Edit_Pass.getText().toString();
        if(TextUtils.isEmpty(user))
            Toast.makeText(getApplicationContext(),R.string.login_empty,Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(pass))
            Toast.makeText(getApplicationContext(),R.string.pass_empty,Toast.LENGTH_SHORT).show();
        else if (itemDataSource.loginDB(user,pass)){
            Toast.makeText(getApplicationContext(),R.string.existe,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.registrado, Toast.LENGTH_SHORT).show();
            itemDataSource.saveUser(user, pass,11 ,"9");
        }
    }

    private void VerificarLogin() {

        String user =Edit_User.getText().toString();
        String pass =Edit_Pass.getText().toString();
        String fecha = getCurrentTimeStamp();

        if(TextUtils.isEmpty(user))
            Toast.makeText(getApplicationContext(),R.string.login_empty,Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(pass))
            Toast.makeText(getApplicationContext(),R.string.pass_empty,Toast.LENGTH_SHORT).show();
        else if(itemDataSource.loginDB(user,pass)) {

            if(checkremember.isChecked()) {
                new PreferencesUtil(getApplicationContext()).saveUser(new Modelitem(user,pass,0,fecha));
            }
            itemDataSource.saveTime(fecha,user);
            startActivity(new Intent(getApplicationContext(), ActivityContenido.class).putExtra("user", user).putExtra("fecha",fecha));
            finish();
        }
        else
            Toast.makeText(getApplicationContext(),R.string.messege_need_register,Toast.LENGTH_SHORT).show();
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
