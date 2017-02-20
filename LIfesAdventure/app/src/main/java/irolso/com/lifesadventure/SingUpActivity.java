package irolso.com.lifesadventure;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.lifesadventure.Data.ApodService;
import irolso.com.lifesadventure.Data.Data;
import irolso.com.lifesadventure.body.Register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.registerName)
    EditText registerName;
    @BindView(R.id.registerPaternal)
    EditText registerPaternal;
    @BindView(R.id.registerMaternal)
    EditText registerMaternal;
    @BindView(R.id.registerEmail)
    EditText registerEmail;
    @BindView(R.id.registerEmail2)
    EditText registerEmail2;
    @BindView(R.id.registerPass)
    EditText registerPass;
    @BindView(R.id.registerPass2)
    EditText registerPass2;
    @BindView(R.id.registerButtonSignUp)
    Button registerButton;
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        ButterKnife.bind(this);
        register = new Register();
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerButtonSignUp:
                if (!registerName.getText().toString().equals("") && !registerPaternal.getText().toString().equals("")  && !registerMaternal.getText().toString().equals("")  && !registerEmail.getText().toString().equals("")  && !registerPass.getText().toString().equals("")){
                    if (registerPass.getText().toString().equals(registerPass2.getText().toString())){
                        if (registerEmail.getText().toString().equals(registerEmail2.getText().toString())){
                            sendRegister();

                        }else{
                            Snackbar.make(findViewById(R.id.content_sing_up),getResources().getString(R.string.noConcidenEmail), Snackbar.LENGTH_LONG).show();
                        }
                    }else{
                        Snackbar.make(findViewById(R.id.content_sing_up),getResources().getString(R.string.noConcidenPass), Snackbar.LENGTH_LONG).show();
                    }
                }else{
                    Snackbar.make(findViewById(R.id.content_sing_up),getResources().getString(R.string.faltan), Snackbar.LENGTH_LONG).show();
                }

                break;
        }
    }

    public void sendRegister(){
        register.setName(registerName.getText().toString());
        register.setPaternalSurname(registerPaternal.getText().toString());
        register.setMaternalSurname(registerMaternal.getText().toString());
        register.setUsername(registerEmail.getText().toString());
        register.setPassword(registerPass.getText().toString());

        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        apodService.register(register).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
