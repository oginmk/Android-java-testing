package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText edtName, edtEmail,edtPassword,edtPassRepeat;
    private Button btnImage,btnRegister;
    private TextView txtWarnEmail,txtWarnName,txtWarnPassword,txtWarnPassRepeat;
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
    }
    private void initViews(){
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