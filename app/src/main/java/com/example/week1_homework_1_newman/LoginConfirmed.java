package com.example.week1_homework_1_newman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginConfirmed extends AppCompatActivity {
    public static String TAG = "DEBUG";
    public String IdInput;
    public int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_confirmed);
        TextView welcome = findViewById(R.id.textWelcome);
        Intent g = getIntent();
        IdInput = g.getStringExtra("I");

        t = Integer.parseInt(IdInput);
        getSupportActionBar().setTitle("Welcome UserId: " + t);

        TextView tv = findViewById(R.id.idDisplay);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    tv.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for(Post post: posts){
                    if(post.getUserId() == t) {
                        String content = "";
                        content += "ID: " + post.getId() + "\n";
                        content += "User ID: " + post.getUserId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Text: " + post.getText() + "\n\n";
                        tv.append(content);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });

    }
}