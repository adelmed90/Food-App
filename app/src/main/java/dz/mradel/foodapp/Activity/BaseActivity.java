package dz.mradel.foodapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class BaseActivity extends AppCompatActivity {
FirebaseAuth mAuth;
FirebaseDatabase database;
public String TAG="mrAdel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
    }
}