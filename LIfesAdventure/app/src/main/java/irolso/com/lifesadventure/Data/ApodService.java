package irolso.com.lifesadventure.Data;

import java.util.List;

import irolso.com.lifesadventure.Response.LoginResponse;
import irolso.com.lifesadventure.Response.ResponselistEvent;
import irolso.com.lifesadventure.body.Register;
import irolso.com.lifesadventure.body.user;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Roldan on 24/01/17.
 */

public interface ApodService {
    @POST("/app_dev.php/user/login")
    Call<List<LoginResponse>> login(@Body user body);

    @POST("/app_dev.php/getEvents")
    Call<List<ResponselistEvent>> listEvent();

    @POST("/app_dev.php/user/register")
    Call<String> register(@Body Register register);
}
