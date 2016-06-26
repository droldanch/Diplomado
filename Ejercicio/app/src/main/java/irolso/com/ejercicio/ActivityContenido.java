package irolso.com.ejercicio;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.NamedNodeMap;

import irolso.com.ejercicio.Fragment.FragmentList;
import irolso.com.ejercicio.Fragment.FragmentProfile;
import irolso.com.ejercicio.Sevice.ServiceFecha;
import irolso.com.ejercicio.sql.ItemDataSource;


public class ActivityContenido extends AppCompatActivity implements View.OnClickListener {

    String NamePerfil,fecha;
    String fechaDB;
    TextView time;
    private ItemDataSource itemDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        itemDataSource= new ItemDataSource(this);
        findViewById(R.id.botonPerfil).setOnClickListener(this);
        findViewById(R.id.botonList).setOnClickListener(this);
        time = (TextView) findViewById(R.id.MainTime);
        NamePerfil = getIntent().getExtras().getString("user");
        itemDataSource.Time(NamePerfil);

        fechaDB=  itemDataSource.Fecha(NamePerfil);

        fecha = getIntent().getExtras().getString("fecha");
        setFragment(FragmentProfile.newInstance(NamePerfil,fechaDB));
        startService(new Intent(getApplicationContext(),ServiceFecha.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.botonPerfil:
                setFragment(FragmentProfile.newInstance(NamePerfil,fechaDB));
                break;
            case R.id.botonList:
                setFragment(new FragmentList());
                break;
        }
    }

    private BroadcastReceiver mBroadcastReceiver= new BroadcastReceiver() {
        @Override public void onReceive(Context context, Intent intent) {
            int timeR = (int) intent.getExtras().getLong("time");
            int TiempoTotal = timeR ;
            time.setText(getString(R.string.sesion) +" "+String.valueOf(TiempoTotal));

        }
    };




    private void setFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment).commit();
    }

    @Override protected void onResume() {
        super.onResume();
        registerReceiver(mBroadcastReceiver,new IntentFilter(ServiceFecha.BROADCAST_SEND_TIME));
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(),ServiceFecha.class));
        String time2 = time.getText().toString();
        itemDataSource.saveTime(time2,NamePerfil);

    }

    @Override protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }
}
