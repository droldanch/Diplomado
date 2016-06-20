package irolso.com.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Singin;
    EditText Edit_User,Edit_Pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        findViewById(R.id.Button_SingIn).setOnClickListener(this);
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
        }
    }

    private void VerificarLogin() {
        //no nececitamos validar si mUser o mPassword ==null, nunca será nulo si fue "inflado" en el setcontentview
        String user =Edit_User.getText().toString();
        String pass =Edit_Pass.getText().toString();
        if(TextUtils.isEmpty(user))
            Toast.makeText(getApplicationContext(),R.string.login_empty,Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(pass))
            Toast.makeText(getApplicationContext(),R.string.pass_empty,Toast.LENGTH_SHORT).show();
        else
            startActivity(new Intent(getApplicationContext(),ActivityContenido.class).putExtra("user",user));
    }

}
