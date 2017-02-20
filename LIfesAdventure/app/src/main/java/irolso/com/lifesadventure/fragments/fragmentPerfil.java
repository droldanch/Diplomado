package irolso.com.lifesadventure.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import irolso.com.lifesadventure.CustomsElements.TextViewMedium;
import irolso.com.lifesadventure.R;
import irolso.com.lifesadventure.body.Register;
import irolso.com.lifesadventure.util.PreferenceUser;

public class fragmentPerfil extends Fragment {

    @BindView(R.id.profileName)
    TextViewMedium profileName;
    @BindView(R.id.profileApellidoP)
    TextViewMedium profileApellidoP;
    @BindView(R.id.profileApellidoM)
    TextViewMedium profileApellidoM;
    @BindView(R.id.profileEmail)
    TextViewMedium profileEmail;
    @BindView(R.id.sign_out_button)
    Button singOutButton;
    PreferenceUser preferenceUser;

    private Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        unbinder = ButterKnife.bind(this, view);

        preferenceUser = new PreferenceUser(getActivity());

        Register registerUser = preferenceUser.getUser();

         profileName.setText(registerUser.getName());
         profileApellidoP.setText(registerUser.getPaternalSurname());
         profileApellidoM.setText(registerUser.getMaternalSurname());
         profileEmail.setText(registerUser.getUsername());
        singOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSharedPreferences("user_pref", 0).edit().clear().commit();
                getActivity().finish();
            }
        });
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.menulistfavoritos, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
       /*     case R.id.menu_share_list_apod:
                Dialog(R.string.borrarFavoritos);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}



