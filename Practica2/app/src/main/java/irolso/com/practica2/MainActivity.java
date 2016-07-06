package irolso.com.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import irolso.com.practica2.adapter.AdapterListApp;
import irolso.com.practica2.model.ModelListApp;
import irolso.com.practica2.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    List<ModelListApp> modelItemList;
    ListView AppList;
    DataSource dataSource;
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSource = new DataSource(this);
        AppList = (ListView) findViewById(R.id.ActivityMainListApp);
        modelItemList = dataSource.getAllItems();

        mensaje = (TextView) findViewById(R.id.ActivityMainTextView);

        if(modelItemList.isEmpty()) {
            mensaje.setText(getString(R.string.sinApp));
        }
        else {
            mensaje.setText("");
        }

        AppList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("id",modelItemList.get(position).ID);
                startActivity(intent);
                finish();
            }
        });

        AppList.setAdapter(new AdapterListApp(this, modelItemList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
