package com.example.t3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t3_3.pokemn.PokemonClass;
import com.example.t3_3.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Capturar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        EditText nombre = findViewById(R.id.editTextTextPersonName3);
        EditText tipo = findViewById(R.id.editTextTextPersonName5);
        EditText url = findViewById(R.id.editTextTextPersonName2);
        EditText latitud = findViewById(R.id.editTextTextPersonName);
        EditText longitud = findViewById(R.id.editTextTextPersonName4);
        Button btnEnviar = findViewById(R.id.button3);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PokemonClass pokemon = new PokemonClass();
                pokemon.setNombre(nombre.getText().toString());
                pokemon.setTipo(tipo.getText().toString());
                pokemon.setUrl_imagen(url.getText().toString());
                pokemon.setLatitude(Float.parseFloat(latitud.getText().toString()) * -1);
                pokemon.setLongitude(Float.parseFloat(longitud.getText().toString()) * -1);

                Call<PokemonClass> call = service.create(pokemon);

                call.enqueue(new Callback<PokemonClass>() {
                    @Override
                    public void onResponse(Call<PokemonClass> call, Response<PokemonClass> response) {
                        Intent intent = new Intent(Capturar.this, MainActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<PokemonClass> call, Throwable t) {
                    }
                });
            }
        });
    }
}