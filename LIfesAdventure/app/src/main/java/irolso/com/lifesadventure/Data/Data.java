package irolso.com.lifesadventure.Data;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Roldan on 24/01/17.
 */

public class Data {
    public static Retrofit getRetrofitInstance(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient =new OkHttpClient.Builder();
        okHttpClient.addInterceptor(httpLoggingInterceptor);

        return new Retrofit.Builder().baseUrl("http://104.236.4.172:81")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }
}
