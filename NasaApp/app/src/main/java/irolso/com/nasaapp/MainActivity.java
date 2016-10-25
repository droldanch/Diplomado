package irolso.com.nasaapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.nasaapp.fragments.fragmentFavoritos;
import irolso.com.nasaapp.fragments.fragmentList;
import irolso.com.nasaapp.fragments.fragmentToday;

public class MainActivity extends AppCompatActivity {

    //TextView title,date,explanation,copyright;
  //  ImageView imagenNasa;

  /*  @BindView(R.id.recyclerViewList)
    RecyclerView recyclerView;

    @BindView(R.id.toolbarMain)
    Toolbar toolbarMain;*/

    @BindView(R.id.listing_toobar)
    Toolbar toolbar;
    @BindView(R.id.listing_navigation_view)
    NavigationView navigationView;
    @BindView(R.id.listing_navigation_drawer)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_navigation_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.logo5);


        setFragment(new fragmentToday());
        getFBUserInfo();
     //   toolbarMain.setTitle("Nasa App");*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                switch (item.getItemId()){
                    case R.id.rover:
                        setFragment(new fragmentList());
                        break;

                    case R.id.today:
                        setFragment(new fragmentToday());
                        break;

                    case R.id.favorite:
                        setFragment(new fragmentFavoritos());
                        break;

                    default:
                        return true;
                }
                return false;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

      /*  LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);

        recyclerView.setLayoutManager(gridLayoutManager);

        final NasaApodAdapter nasaApodAdapter = new NasaApodAdapter();

        nasaApodAdapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener(){


            @Override
            public void onItemCLick(Photo photo) {

                Intent intent = new Intent(MainActivity.this, ActivityDetalles.class);

             //   Bundle bundle = new Bundle();
              //  bundle.putSerializable("photo", photo);
              //  intent.putExtras(bundle);

                  intent.putExtra("imagen",photo.getImgSrc());
                  intent.putExtra("titleNasa", photo.getRover().getName());
                  intent.putExtra("fecha",photo.getEarthDate());
                  intent.putExtra("contenido",photo.getCamera().getFullName());
                startActivity(intent);
            }
        });


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);

        apodService.getTodayApodWithQuery2("1000",BuildConfig.API_KEY).enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
               // Log.d("APOD", String.valueOf(response.body().getPhotos()));
               /* title.setText(response.body().getPhotos().toString());
                date.setText(response.body().getDate().toString());
                explanation.setText(response.body().getExplanation().toString());
                copyRight.setText(response.body().getCopyright().toString());
                Picasso.with(MainActivity.this).load(response.body().getHdurl().toString()).into(imagenNasa);
*/     /*        nasaApodAdapter.setApods(response.body().getPhotos());
                recyclerView.setAdapter(nasaApodAdapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }

        });*/
    }

    private void setFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
    }
    private void getFBUserInfo(){
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    SimpleDraweeView userImage = (SimpleDraweeView) findViewById(R.id.userImage);
                    userImage.setImageURI("http://graph.facebook.com/"+object.getString("id")+"/picture?type=large");
                    TextView userName = (TextView) findViewById(R.id.userName);
                    userName.setText(object.getString("name"));
                    Log.d("name",object.getString("name"));
                    Log.d("id",object.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        request.executeAsync();
    }

}


