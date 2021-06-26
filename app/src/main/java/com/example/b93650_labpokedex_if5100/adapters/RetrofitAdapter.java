package com.example.b93650_labpokedex_if5100.adapters;

import com.example.b93650_labpokedex_if5100.interfaces.PokemonServicios;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static Retrofit retrofit = null;
    private static Retrofit pokeApi = null;


    public static Retrofit getBlankApi() {
        OkHttpClient.Builder httpClient3 = new OkHttpClient.Builder();
        httpClient3.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        pokeApi= new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient3.build())
                .build();
        return pokeApi;
    }

    public static Retrofit getAdapter() {
        if (retrofit==null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            retrofit= new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static PokemonServicios acessar() {
        return getAdapter().create(PokemonServicios.class);
    }
}
