package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.remote.data.WeatherResponse;
import com.example.retrofit.remote.remoteretro.RetrofitClient;
import com.example.retrofit.remote.remoteretro.SOService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static String AppId = "2e65127e909e178d0af311a81f39948c";
    public static String lat = "35";
    public static String lon = "139";
    public RecyclerView recyclerView;
    List<WeatherResponse> listItem;
    AdapterWeather adapterWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list_weather);
        listItem=new ArrayList<>();
        fetchWeatherDetails();
        adapterWeather=new AdapterWeather(listItem,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapterWeather);
        recyclerView.setLayoutManager(mLayoutManager);

    }

    private void fetchWeatherDetails() {
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        SOService soService = retrofit.create(SOService.class);
        soService.getCurrentWeatherData(lat, lon, AppId).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("AAA","thành công");
                WeatherResponse weatherResponse=response.body();
                Toast.makeText(MainActivity.this, weatherResponse.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("BBB","Thất bại");
            }
        });
    }
}
