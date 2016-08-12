package irolso.com.nasaapp.data;

import irolso.com.nasaapp.model.Example;
import irolso.com.nasaapp.model.Photo;
import irolso.com.nasaapp.model.RespuestaJson;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Roldan on 30/07/16.
 */
public interface ApodService {
    @GET("planetary/apod?api_key=6DSXPiUK0o9AbSviVuUCHDNvdZ1hKHECW3CNirjJ")
    Call<RespuestaJson> getTodayApod();

    @GET("planetary/apod")
    Call<RespuestaJson>getTodayApodWithQuery(@Query("api_key")String apiKey);

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    Call<Example>getTodayApodWithQuery2(@Query("sol")String sol, @Query("api_key")String apiKey);
}
