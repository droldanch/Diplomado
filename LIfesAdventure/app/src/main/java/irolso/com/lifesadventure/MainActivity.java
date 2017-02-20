package irolso.com.lifesadventure;

import android.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import irolso.com.lifesadventure.fragments.fragmentNuevo;
import irolso.com.lifesadventure.fragments.fragmentPerfil;
import irolso.com.lifesadventure.fragments.fragmentViajes;

public class MainActivity extends AppCompatActivity
        implements TabLayout.OnTabSelectedListener, View.OnClickListener {


    @BindView(R.id.tabs)
    TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        int tabIconColor = this.getResources().getColor(R.color.colorPrimaryDark);
        tabs.addTab(tabs.newTab().setText(getResources().getString(R.string.viajes)));
        tabs.addTab(tabs.newTab().setText(getResources().getString(R.string.perfil)));
        tabs.addTab(tabs.newTab().setText(getResources().getString(R.string.nuevo)));


        tabs.getTabAt(0).setIcon(R.drawable.ic_compass);
        tabs.getTabAt(1).setIcon(R.drawable.ic_singin_user);
        tabs.getTabAt(2).setIcon(R.drawable.ic_heart);


        tabs.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabs.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

        tabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
        tabs.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),getResources().getColor(R.color.white));
        tabs.setSelectedTabIndicatorHeight(5);
        tabs.setOnTabSelectedListener(this);

        onTabSelected(tabs.getTabAt(0));

    }


    private void setFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int tabIconColor = this.getResources().getColor(R.color.white);
        switch (tab.getPosition()){
            case 0:
                setFragment(new fragmentViajes());
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
            case 1:
                setFragment(new fragmentPerfil());
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                setFragment(new fragmentNuevo());
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        int tabIconColor = this.getResources().getColor(R.color.colorPrimaryDark);
        switch (tab.getPosition()){
            case 0:
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
            case 1:
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
            case 2:
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                break;
        }

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onBackPressed() {
       finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.sign_out_button:
                finish();
                break;

        }
    }
}
