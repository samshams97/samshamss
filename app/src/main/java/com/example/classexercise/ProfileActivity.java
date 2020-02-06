package com.example.classexercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText nameE = findViewById(R.id.nameE);
        final EditText familyE = findViewById(R.id.familyE);
        final EditText emailE = findViewById(R.id.emailE);
        final EditText phoneE = findViewById(R.id.phoneE);
        TextView nameT = findViewById(R.id.namet);
        TextView familyT = findViewById(R.id.familyT);
        TextView emailT = findViewById(R.id.emailT);
        TextView phoneT = findViewById(R.id.phoneT);

        String name = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Name","Unknown");
        nameT.setText(name);
        String family = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Family","Unknown");
        familyT.setText(family);
        String email = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Email","Unknown");
        emailT.setText(email);
        String phone = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).getString("Phone","Unknown");
        phoneT.setText(phone);


        Button btnSsve = findViewById(R.id.btnSave);
        btnSsve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(ProfileActivity.this)
                        .setTitle("Attention!!!!!!")
                        .setMessage("Do you want to save?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = nameE.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Name",name).apply();
                                String family = familyE.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Family",family).apply();
                                String email = emailE.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Email",email).apply();
                                String phoneNumber= phoneE.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit().putString("Phone",phoneNumber).apply();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ProfileActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNeutralButton("Remind me Later", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ProfileActivity.this, "No thanks", Toast.LENGTH_SHORT).show();

                            }
                        }).create();
                dialog.show();
            }

        });
    }
}


