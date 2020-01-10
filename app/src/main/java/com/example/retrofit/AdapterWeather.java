package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.remote.data.WeatherResponse;

import java.util.List;

public class AdapterWeather extends RecyclerView.Adapter<AdapterWeather.WeatherViewHolder> {
    List<WeatherResponse> listWeather;
    Context context;

    public AdapterWeather(List<WeatherResponse> listWeather, Context context) {
        this.listWeather = listWeather;
        this.context = context;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_weather,parent,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherResponse itemWeather=listWeather.get(position);
        holder.nameCiTy.setText(itemWeather.getName());
        holder.infoCiTy.setText(itemWeather.getId());
        holder.doAm.setText(itemWeather.getMain().getHumidity());
        holder.nhietDo.setText((int) itemWeather.getMain().getTemp());
        holder.knm.setText(itemWeather.getClouds().toString());
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        private TextView nameCiTy;
        private TextView infoCiTy;
        private TextView doAm;
        private TextView nhietDo;
        private TextView knm;
        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCiTy = itemView.findViewById(R.id.name_city);
            infoCiTy = itemView.findViewById(R.id.info_city);
            doAm = itemView.findViewById(R.id.doAm);
            nhietDo = itemView.findViewById(R.id.template);
            knm = itemView.findViewById(R.id.kNM);
        }
    }
}
