package com.example.sensorratingscale;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorratingscale.Model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StarActivity extends AppCompatActivity {
    int rating;
    DatabaseReference databaseReference, mref;
    RatingBar ratingBar;
    // LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Firebase.setAndroidContext(this);
        ratingBar = findViewById(R.id.ratingbarid);
        setContentView(R.layout.activity_star);


        //databaseReference= Firebase.database.getReference("Products")
        databaseReference = FirebaseDatabase.getInstance().getReference("Products");
      //  mref = getInstance().getReference("RatedProducts");
        // animationView = findViewById(R.id.thanksAnimationId);

    }

    public void done (View view) {

        rating = (int) ratingBar.getRating();
        if (rating > 0) {
            Product currentProduct=new Product();
            float sumRating = currentProduct.getSumRating() + rating;
            int ratingCount = currentProduct.getRatingCount() + 1;
            float results = (float) (sumRating / ratingCount);
            databaseReference.child(String.valueOf(currentProduct.getRating())).child("ratingCount").setValue(ratingCount);
            databaseReference.child(String.valueOf(currentProduct.getRating())).child("rating").setValue(results);
            databaseReference.child(String.valueOf(currentProduct.getRating())).child("sumRating").setValue(sumRating);
            currentProduct.setRating(results);
            currentProduct.setRatingCount(ratingCount);
            currentProduct.setSumRating((int) sumRating);
          //  Firebase firebase;
           //firebase = new Firebase(config.url);
           // firebase.child("person").setvalue(currentProduct);
            Toast.makeText(getApplicationContext(), "Thanks for your feedback!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(StarActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(getApplicationContext(), "plz give ", Toast.LENGTH_LONG).show();

        }
    }

    }
