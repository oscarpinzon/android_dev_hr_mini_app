package www.hrminiapp.com;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUid, edtEmail, edtPwd;
    Button btnLogin;
    Intent intent1;
    SharedPreferences sharedPref1;

    // basic onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    // initializes the views and sets the onclick listener for the login button
    private void init() {
        edtUid = findViewById(R.id.edtUid);
        edtEmail = findViewById(R.id.edtEmailId);
        edtPwd = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            if (edtUid.getText().toString().trim().equals("thomas") && edtEmail.getText().toString().equals("test")) {
                intent1 = new Intent(LoginActivity.this, HomeActivity.class);
//                intent1.putExtra("USER_ID", edtUid.getText().toString().trim());
//                startActivity(intent1);
//                finish();
                SharedPreferences.Editor editor1 = sharedPref1.edit();
                editor1.putString("USER_ID", edtUid.getText().toString().trim());
                editor1.putString("EMAIL_ID", edtEmail.getText().toString().trim());
                editor1.commit();
                startActivity(intent1);
            } else {
//                Toast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show();
                InvalidDialog dialog1 = new InvalidDialog();
                dialog1.show(getSupportFragmentManager(), "InvalidDialog");
            }
        });
    }
}