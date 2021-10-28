package com.example.t3_3.services;

import com.example.t3_3.pokemn.PokemonClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("pokemons/N00036447/")
    Call<List<PokemonClass>> getALL();

    @GET("pokemons/N00036447/")
    Call<List<PokemonClass>> getByQuery(@Query("query") String query);

    @POST("pokemons/N00036447/crear")
    Call<PokemonClass> create(@Body PokemonClass pokemon);
}
