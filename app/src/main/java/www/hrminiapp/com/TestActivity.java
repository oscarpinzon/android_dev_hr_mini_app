package www.hrminiapp.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    TextView txtWelcome;
    SharedPreferences sharedPref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init();
    }

    private void init() {
        txtWelcome = findViewById(R.id.txtWelcome);
//        Intent intent1 = getIntent();
//        String userName = intent1.getStringExtra("USER_ID");
//        txtWelcome.setText("Welcome " + userName + "!");
        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
        txtWelcome.setText("Welcome " + sharedPref1.getString("USER_ID", "") + "!" + "\n" + sharedPref1.getString("EMAIL_ID", ""));
    }
}


