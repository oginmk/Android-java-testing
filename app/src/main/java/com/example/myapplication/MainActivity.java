package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText edtName, edtEmail, edtPassword, edtPassRepeat;
    private Button btnImage, btnRegister;
    private TextView txtWarnEmail, txtWarnName, txtWarnPassword, txtWarnPassRepeat;
    private Spinner countrySpinner;
    private RadioGroup rgGender;
    private CheckBox chkAgreement;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "No idea bro.", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        Log.d(TAG, "initRegister: Started");

        if (validateData()) {
            if (chkAgreement.isChecked()) {
                loginActivity();
            } else
                Toast.makeText(this, "You need to accept the license agreement", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginActivity() {
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String country = countrySpinner.getSelectedItem().toString();
        String gender = "";
        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        };
        String textData = "Name: " + name + "\n " +
                "email : " + email + "\n"  + "Country " + country + "\n"+gender;
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key", textData);
        startActivity(intent);

        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 15-Mar-21 implement database
                        edtName.setText("");
                        edtEmail.setText("");
                        edtPassword.setText("");
                        edtPassRepeat.setText("");
                    }
                }).show();
    }

    private Boolean validateData() {
        Log.d(TAG, "validateData: started");
        if (edtName.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Username Invalid");
            return false;
        }
        if (edtEmail.getText().toString().equals("")) {
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Email Invalid");
            return false;
        }
        if (edtPassword.getText().toString().equals("")) {
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Invalid Password");
            return false;
        }
        if (edtPassRepeat.getText().toString().equals("") || edtPassRepeat.getText().toString().equals(txtWarnPassword.getText().toString())) {
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Passwords Dont Match");
            return false;
        }
        return true;
    }

    private void initViews() {
        Log.d(TAG, "initViews: Started");
        edtName = findViewById(R.id.editTextTextPersonName);
        edtEmail = findViewById(R.id.editTextTextEmailAddress);
        edtPassword = findViewById(R.id.editTextTextPassword);
        edtPassRepeat = findViewById(R.id.editTextTextPassword2);

        btnImage = findViewById(R.id.buttonAvatar);
        btnRegister = findViewById(R.id.buttonRegister);

        txtWarnEmail = findViewById(R.id.warningEmail);
        txtWarnName = findViewById(R.id.warningName);
        txtWarnPassword = findViewById(R.id.warningPassword);
        txtWarnPassRepeat = findViewById(R.id.warningPassMatch);

        countrySpinner = findViewById(R.id.spinnerCountry);
        rgGender = findViewById(R.id.radioGroup);
        chkAgreement = findViewById(R.id.checkBoxAgree);
        parent = findViewById(R.id.parent);
    }
}