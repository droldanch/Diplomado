package irolso.com.ejercicio.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import irolso.com.ejercicio.ActivityContenido;
import irolso.com.ejercicio.MainActivity;
import irolso.com.ejercicio.Model.Modelitem;
import irolso.com.ejercicio.Preferences.PreferencesUtil;
import irolso.com.ejercicio.R;

public class FragmentProfile extends Fragment implements View.OnClickListener {
    TextView PerfilName;
    ImageView PerfilImage;
    TextView fechaView;
    Button cerrar;
    public static FragmentProfile newInstance(String user,String fecha)
    {
        FragmentProfile f= new FragmentProfile();
        Bundle b = new Bundle();
        b.putString("fecha",fecha);
        b.putString("user",user);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_blank,container,false);
        String userName = getArguments().getString("user","Vacio");
        String fecha = getArguments().getString("fecha","-");
        PerfilName = (TextView) view.findViewById(R.id.PerfilUser);
        PerfilName.setText(userName);
        PerfilImage = (ImageView) view.findViewById(R.id.imagenPerfil);
        fechaView = (TextView) view.findViewById(R.id.Date);
        fechaView.setText(fecha);
        cerrar = (Button) view.findViewById(R.id.Button_SingOut);
        cerrar.setOnClickListener(this);
        char primero=userName.charAt(0);
        int letraInicial = (int) primero;

        if(letraInicial>96 && letraInicial<110) {
            PerfilImage.setImageResource(R.drawable.ic_perfil_1);
        }
        else if(letraInicial>109 && letraInicial<123) {
            PerfilImage.setImageResource(R.drawable.ic_perfil_2);
        }
        
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button_SingOut:
                new PreferencesUtil(getActivity()).saveUser(new Modelitem("","",0,""));
           getActivity().finish();
                break;
        }
    }
}
