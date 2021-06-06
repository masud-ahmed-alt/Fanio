package www.fanio.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    private ImageView login;
    private TextView signUp;
    private EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        login = findViewById(R.id.login);
        signUp = findViewById(R.id.switch_signup);
        email = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser();
            }
        });
    }

    private void validateUser() {
        String username, user_password;
        username = email.getText().toString();
        user_password = password.getText().toString();

        if (username.isEmpty()){
            email.setError("Username Empty");
            email.requestFocus();
        }else if (user_password.isEmpty()){
            password.setError("Password Empty");
            password.requestFocus();
        }else{
            Intent intent= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}