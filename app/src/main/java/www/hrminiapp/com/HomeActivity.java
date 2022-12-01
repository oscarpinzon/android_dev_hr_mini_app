package www.hrminiapp.com;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView txtWelcome;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    NavigationView navView;
    SharedPreferences sharedPref1;
    BottomNavigationView bottomNavView;
    PowerBroadcastReceiver receiver = new PowerBroadcastReceiver();

    // registers the broadcast receiver
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(receiver, filter);
    }

    // unregisters the broadcast receiver
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    // basic onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    // initializes the views and sets the onclick listener for the navigation drawer
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // initializes the views and sets the onclick listener for the navigation drawer
    private void init() {
        txtWelcome = findViewById(R.id.txtWelcome);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        bottomNavView = findViewById(R.id.bottom_navigatin_view);

        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
        txtWelcome.setText("Welcome " + sharedPref1.getString("username", "") + "!");

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.nav_open, R.string.nav_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SetNavigationDrawer();
        SetBottomNavigation();
    }

    // sets the onclick listener for the navigation drawer
    private void SetNavigationDrawer() {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_add_emp) {
                    frag = new AddEmpFragment();
                } else if (itemId == R.id.nav_delete_emp) {
                    frag = new DeleteEmpFragment();
                } else if (itemId == R.id.nav_list_emp) {
                    frag = new ListEmpFragment();
                } else if (itemId == R.id.nav_update_emp) {
                    // frag = new UpdateEmpFragment();
                }
                if (frag != null) {
                    FragmentTransaction frgTrans = getSupportFragmentManager().beginTransaction();
                    frgTrans.replace(R.id.frame, frag);
                    frgTrans.commit();
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    // sets the onclick listener for the bottom navigation
    private void SetBottomNavigation() {
        bottomNavView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null;

                switch (item.getItemId()) {
                    case R.id.nav_bottom_search:
                        // open search fragment
                        break;
                    case R.id.nav_bottom_account:
                        // open account fragment
                        break;
                    case R.id.nav_bottom_profile:
                        // open profile fragment
                        frag = new ProfileFragment();
                        break;
                }
                if (frag != null) {
                    FragmentTransaction frgTrans = getSupportFragmentManager().beginTransaction();
                    frgTrans.replace(R.id.frame, frag);
                    frgTrans.commit();
                    return true;
                }
                return false;
            }
        });
    }
}
