package com.sandy.sandtracker.Activities.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sandy.sandtracker.Activities.Adapters.CountryListAdapter;
import com.sandy.sandtracker.Activities.Beans.CountryBeans;
import com.sandy.sandtracker.Activities.Tools.SandyColorizer;
import com.sandy.sandtracker.Activities.Tools.StringTrimmer;
import com.sandy.sandtracker.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {

    Context context;
    RecyclerView rvCountryList;
    ArrayList<CountryBeans> countryBeansArrayList = new ArrayList<>();
    CountryListAdapter countryListAdapter;
    CountryBeans countryBeans;
    View root;
    StringTrimmer stringTrimmer;
    SandyColorizer sandyColorizer;
    private HomeViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        stringTrimmer = new StringTrimmer();
        sandyColorizer = new SandyColorizer();
        initUI();
        reqToServer();


        return root;
    }

    private void reqToServer() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        try {
            String url = "https://api.covid19api.com/summary";
            JSONObject object = new JSONObject();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
               int num=0;

                @Override
                public void onResponse(JSONObject response) {

                    try {
                        JSONArray array = response.getJSONArray("Countries");
                        for (int i = 0; i <= array.length(); i++) {
                            JSONObject item = array.getJSONObject(i);
                            Log.i("Res", Integer.toString(num));
                            countryBeans = new CountryBeans();
                            countryBeans.setC_name(item.getString("Country"));
                            countryBeans.setRanking(Integer.toString(i));
                            countryBeans.setConfirmed(item.getString("TotalConfirmed"));
                            countryBeans.setRecovered(item.getString("TotalRecovered"));
                            countryBeans.setDeaths(item.getString("TotalDeaths"));
                            countryBeans.setTime(stringTrimmer.trimStr(item.getString("Date")));
                            countryBeans.setColorCv(sandyColorizer.putColor());


                            countryBeansArrayList.add(countryBeans);

                            countryListAdapter.notifyDataSetChanged();


                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        rvCountryList = root.findViewById(R.id.rvCountryList);
        countryListAdapter = new CountryListAdapter(context, countryBeansArrayList);
        rvCountryList.setAdapter(countryListAdapter);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
