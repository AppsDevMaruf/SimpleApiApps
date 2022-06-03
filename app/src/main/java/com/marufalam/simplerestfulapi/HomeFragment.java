package com.marufalam.simplerestfulapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private ApiInterface apiInterface;
    private PhotoModelAdapter adapter;
    private RecyclerView recyclerView;
    private List<PhotoModel> list = new ArrayList();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView =view.findViewById(R.id.recyclerView);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getPhotos().enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                Toast.makeText(requireActivity(), "Successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(requireActivity(), ""+response.body().get(0).getThumbnailUrl(), Toast.LENGTH_SHORT).show();
                adapter = new PhotoModelAdapter(response.body());
                LinearLayoutManager llm = new LinearLayoutManager(requireActivity());
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {
                Toast.makeText(requireActivity(), "Failed", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}