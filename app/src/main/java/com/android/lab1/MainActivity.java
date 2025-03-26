package com.android.lab1;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText passwordEditText;
    private RadioGroup passwordVisibilityGroup;
    private RadioButton showPasswordRadioButton, starPasswordRadioButton;
    private Button submitButton, clearButton;
    private TextView passwordOutputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEditText = findViewById(R.id.passwordEditText);
        passwordVisibilityGroup = findViewById(R.id.passwordVisibilityGroup);
        showPasswordRadioButton = findViewById(R.id.showPasswordRadioButton);
        starPasswordRadioButton = findViewById(R.id.starPasswordRadioButton);
        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);
        passwordOutputTextView = findViewById(R.id.passwordOutputTextView);

        starPasswordRadioButton.setChecked(true);
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        passwordVisibilityGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.showPasswordRadioButton) {
                passwordEditText.setTransformationMethod(null);
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        submitButton.setOnClickListener(v -> {
            String password = passwordEditText.getText().toString().trim();

            if (password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Будь ласка, введіть пароль.", Toast.LENGTH_SHORT).show();
                return;
            }

            passwordOutputTextView.setText("Введений пароль: " + password);
            passwordOutputTextView.setVisibility(View.VISIBLE);
        });

        clearButton.setOnClickListener(v -> {
            passwordEditText.setText("");
            passwordOutputTextView.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Поле введення очищено.", Toast.LENGTH_SHORT).show();
        });
    }
}
