package administrator.example.com.welcomeview.WelCome2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import administrator.example.com.welcomeview.R;
import administrator.example.com.welcomeview.ce_la_menu.MenuListFragment;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    private FlowingDrawer mDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        ButterKnife.bind(this);
        mDrawer = (FlowingDrawer)findViewById(R.id.drawerlayout);

        setMenu();
    }

    private void setMenu() {

        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment menuListFragment = (MenuListFragment)fm.findFragmentById(R.id.id_container_menu);
        if(menuListFragment == null){
            menuListFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu,menuListFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(mDrawer.isMenuVisible()){
            mDrawer.closeMenu();
        }else{
            super.onBackPressed();
        }
    }

}
