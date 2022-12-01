package www.hrminiapp.com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    Button btnNext, btnSkip;
    int[] layouts;
    ViewsSliderAdapter mAdapter;
    Intent intent1;

    // basic onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // initializes the views and sets the onclick listener for the next and skip buttons
    private void init() {
        layouts = new int[]{
                R.layout.slide_screen_1,
                R.layout.slide_screen_2,
                R.layout.slide_screen_3,
        };

        viewPager2 = findViewById(R.id.view_pager);

        mAdapter = new ViewsSliderAdapter(layouts);
        viewPager2.setAdapter(mAdapter);

        btnNext = findViewById(R.id.btn_next);
        btnSkip = findViewById(R.id.btn_skip);

        btnSkip.setOnClickListener(v -> launchLoginScreen());

        btnNext.setOnClickListener(v -> {
            int current = viewPager2.getCurrentItem() + 1;
            if (current < layouts.length) {
                viewPager2.setCurrentItem(current);
                if (current == layouts.length - 1) {
                    btnNext.setText(R.string.cont);
                }
            } else {
                launchLoginScreen();
            }
        });
    }

    // launches the login screen
    private void launchLoginScreen() {
        intent1 = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent1);
        finish();
    }
}