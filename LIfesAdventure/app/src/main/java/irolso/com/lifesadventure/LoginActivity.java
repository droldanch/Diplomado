package irolso.com.lifesadventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.lifesadventure.CustomsElements.TextViewMedium;
import irolso.com.lifesadventure.Data.ApodService;
import irolso.com.lifesadventure.Data.Data;
import irolso.com.lifesadventure.Response.LoginResponse;
import irolso.com.lifesadventure.body.Register;
import irolso.com.lifesadventure.body.user;
import irolso.com.lifesadventure.util.PreferenceUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.password)
    TextView password;
    @BindView(R.id.email_sign_in_button)
    Button buttonEmailSignIn;

    @BindView(R.id.textViewRegister)
    TextViewMedium textViewRegister;
    PreferenceUser util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        util = new PreferenceUser(LoginActivity.this);
        buttonEmailSignIn.setOnClickListener(this);
        textViewRegister.setOnClickListener(this);
        Register register = util.getUser();
        if(register!= null){
            Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentLogin);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                if (!email.getText().toString().equals("") && !password.getText().toString().equals("")){
                    loginRequest(email.getText().toString(), password.getText().toString());
                }else{
                    Snackbar.make(findViewById(R.id.content_login),getResources().getString(R.string.faltan), Snackbar.LENGTH_LONG).show();
                }
                break;

            case  R.id.textViewRegister:
                Intent intentRegister = new Intent(LoginActivity.this, SingUpActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    public void loginRequest(String user,String pass){
        user usuario = new user(user,pass);
        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        apodService.login(usuario).enqueue(new Callback<List<LoginResponse>>() {
            @Override
            public void onResponse(Call<List<LoginResponse>> call, Response<List<LoginResponse>> response) {

                util.saveUser(new Register(response.body().get(0).getName(),response.body().get(0).getPaternalsurname(),response.body().get(0).getMaternalsurname(),response.body().get(0).getUsername()));
               if(response.body().get(0).getName()!=null){
                    Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intentLogin);
                   finish();
                }
            }

            @Override
            public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                Snackbar.make(findViewById(R.id.content_login),getResources().getString(R.string.problemas), Snackbar.LENGTH_LONG).show();
            }
        });

    }
}

