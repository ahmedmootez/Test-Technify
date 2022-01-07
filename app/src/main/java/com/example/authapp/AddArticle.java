package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class AddArticle extends AppCompatActivity implements View.OnClickListener{
    private Button reset, saveArticle;
    private EditText  editTextName, editTextPrice;
    private TextView home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);


        saveArticle = (Button) findViewById(R.id.saveArticle);
        saveArticle.setOnClickListener(this);

home =(TextView)findViewById(R.id.home);
home.setOnClickListener(this);
        editTextName = (EditText) findViewById(R.id.articleName);
        editTextPrice = (EditText) findViewById(R.id.articlePrice);






    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveArticle:
                save();
                break;
            case R.id.home:
                startActivity(new Intent(this,ProfileActivity.class));
        }

    }

    private void save() {
        String Price = editTextPrice.getText().toString().trim();
        String Name = editTextName.getText().toString().trim();



        if (Name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return;
        }
        if (Price.isEmpty()) {
            editTextPrice.setError("price is required");
            editTextPrice.requestFocus();
            return;
        }
        Article article =new Article(Name,Price);
        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("articles").push().setValue(article);
        startActivity(new Intent(this,ProfileActivity.class));




    }
    public void reset(View view){

        editTextPrice.setText("");
        editTextName.setText("");

    }







    }
