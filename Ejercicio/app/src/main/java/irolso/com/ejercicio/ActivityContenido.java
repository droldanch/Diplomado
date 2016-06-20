package irolso.com.ejercicio;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.NamedNodeMap;

import irolso.com.ejercicio.Fragment.FragmentList;
import irolso.com.ejercicio.Fragment.FragmentProfile;


public class ActivityContenido extends AppCompatActivity implements View.OnClickListener {

    String NamePerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        findViewById(R.id.botonPerfil).setOnClickListener(this);
        findViewById(R.id.botonList).setOnClickListener(this);
        NamePerfil = getIntent().getExtras().getString("user");
        setFragment(FragmentProfile.newInstance(NamePerfil));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.botonPerfil:
                setFragment(FragmentProfile.newInstance(NamePerfil));
                break;
            case R.id.botonList:
                setFragment(new FragmentList());
                break;
        }
    }




    private void setFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.Contenedor,fragment).commit();
    }
}
