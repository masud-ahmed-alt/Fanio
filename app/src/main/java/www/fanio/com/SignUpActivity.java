package www.fanio.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private Button signUp;
    private TextView login;
    private EditText signup_email, signup_mobile, signup_password, signup_confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        signUp = findViewById(R.id.btn_signup);
        login = findViewById(R.id.switch_login);
        signup_email = findViewById(R.id.signup_email);
        signup_mobile = findViewById(R.id.signup_mobile);
        signup_password = findViewById(R.id.signup_password);
        signup_confirmPass = findViewById(R.id.signup_confirmPass);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateDate();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void validateDate() {
        String email = signup_email.getText().toString();
        String mobile = signup_mobile.getText().toString();
        String password = signup_password.getText().toString();
        String confirmPass = signup_confirmPass.getText().toString();

        if (email.isEmpty()){
            signup_email.setError("Field can't be empty");
            signup_email.requestFocus();
        }else if (mobile.isEmpty()){
            signup_mobile.setError("Field can't be empty");
            signup_mobile.requestFocus();
        }else if (mobile.length()!=10){
            signup_mobile.setError("Invalid Mobile Number");
            signup_mobile.requestFocus();
        }else if (password.isEmpty()){
            signup_password.setError("Field can't be empty");
            signup_password.requestFocus();
        }else if (confirmPass.isEmpty()){
            signup_confirmPass.setError("Field can't be empty");
            signup_confirmPass.requestFocus();
        }else if (!confirmPass.equals(password)){
            signup_confirmPass.setError("Password not matched");
            signup_confirmPass.requestFocus();
        }else {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }
    }
}