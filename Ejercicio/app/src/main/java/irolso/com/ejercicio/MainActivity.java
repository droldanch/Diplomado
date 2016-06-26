package irolso.com.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import irolso.com.ejercicio.sql.ItemDataSource;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Singin;
    EditText Edit_User,Edit_Pass;
    private ItemDataSource itemDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        findViewById(R.id.Button_SingIn).setOnClickListener(this);
        findViewById(R.id.Button_Register).setOnClickListener(this);
        itemDataSource= new ItemDataSource(this);
    }

    private void inicializarComponentes() {
        Edit_Pass = (EditText) findViewById(R.id.EditText_Pass);
        Edit_User = (EditText) findViewById(R.id.EditText_User);
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
        else
            Toast.makeText(getApplicationContext(),R.string.registrado,Toast.LENGTH_SHORT).show();
            itemDataSource.saveUser(user,pass,"0","0");

    }

    private void VerificarLogin() {

        String user =Edit_User.getText().toString();
        String pass =Edit_Pass.getText().toString();
        if(TextUtils.isEmpty(user))
            Toast.makeText(getApplicationContext(),R.string.login_empty,Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(pass))
            Toast.makeText(getApplicationContext(),R.string.pass_empty,Toast.LENGTH_SHORT).show();
        else if(itemDataSource.loginDB(user,pass))
            startActivity(new Intent(getApplicationContext(),ActivityContenido.class).putExtra("user",user));
        else
            Toast.makeText(getApplicationContext(),R.string.messege_need_register,Toast.LENGTH_SHORT).show();
    }

}
