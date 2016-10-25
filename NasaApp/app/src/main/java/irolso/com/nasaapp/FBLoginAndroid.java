package irolso.com.nasaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.nasaapp.data.ApodService;
import irolso.com.nasaapp.data.Data;
import irolso.com.nasaapp.model.RespuestaJson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FBLoginAndroid extends AppCompatActivity implements FacebookCallback<LoginResult> {
    @BindView(R.id.login_button)
    LoginButton loginButton;

    @BindView(R.id.contenidoLogin)
    ImageView contenidoLogin;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fblogin);
        ButterKnife.bind(this);

        // patron Factory viene en un libre
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, this);
       // Intent intent = new Intent(FBLoginAndroid.this, MainActivity.class);
       // startActivity(intent);

        if (AccessToken.getCurrentAccessToken()!=null) {
            Snackbar.make(findViewById(android.R.id.content), "Una sesión", Snackbar.LENGTH_LONG);
        }

        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);

        apodService.getTodayApod().enqueue(new Callback<RespuestaJson>() {

            @Override
            public void onResponse(Call<RespuestaJson> call, Response<RespuestaJson> response) {
                // Log.d("APOD", String.valueOf(response.body().getPhotos()));
                Picasso.with(FBLoginAndroid.this).load(response.body().getHdurl().toString()).into(contenidoLogin);
            }

            @Override
            public void onFailure(Call<RespuestaJson> call, Throwable t) {

            }


        });

    }


    @Override
    public void onSuccess(LoginResult loginResult) {

        Snackbar.make(findViewById(android.R.id.content), "Login Succes", Snackbar.LENGTH_LONG);
        Intent intent = new Intent(FBLoginAndroid.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCancel() {
        Snackbar.make(findViewById(android.R.id.content), "Cancel login", Snackbar.LENGTH_LONG);
    }

    @Override
    public void onError(FacebookException error) {
        Snackbar.make(findViewById(android.R.id.content), error.getMessage(), Snackbar.LENGTH_LONG);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}