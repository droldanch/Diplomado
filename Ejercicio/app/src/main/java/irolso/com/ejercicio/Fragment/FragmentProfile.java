package irolso.com.ejercicio.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import irolso.com.ejercicio.R;

public class FragmentProfile extends Fragment {
    TextView PerfilName;
    ImageView PerfilImage;
    public static FragmentProfile newInstance(String user)
    {
        FragmentProfile f= new FragmentProfile();
        Bundle b = new Bundle();
        b.putString("user",user);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_blank,container,false);
        String userName = getArguments().getString("user","Vacio");

        PerfilName = (TextView) view.findViewById(R.id.PerfilUser);
        PerfilName.setText(userName);
        PerfilImage = (ImageView) view.findViewById(R.id.imagenPerfil);

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

}
