package com.example.biometrics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class FingerprintAuthenticator extends AppCompatActivity {

    private Button logoutButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_authenticator);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Reference the logout button
        logoutButton = findViewById(R.id.logOut);

        // Set click listener for the logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log the user out
                mAuth.signOut();

                // Redirect to LoginActivity
                Intent intent = new Intent(FingerprintAuthenticator.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clears the activity stack
                startActivity(intent);

                // Optionally, display a message
                finish(); // End this activity
            }
        });
    }
}