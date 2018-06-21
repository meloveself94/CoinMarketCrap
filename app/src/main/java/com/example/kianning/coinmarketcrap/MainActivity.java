package com.example.kianning.coinmarketcrap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    private ArrayList<Items> mItems;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_market_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));

        mItems = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson() {
        String url="https://api.coinmarketcap.com/v1/ticker/";



        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++ ) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String coinName = jsonObject.getString("name");
                        String coinPrice = jsonObject.getString("price_usd");
                        String coinRank = jsonObject.getString("rank");
                        String coinChange = jsonObject.getString("percent_change_24h");
                        String coinPriceToBtc = jsonObject.getString("price_btc");

                        Log.d(TAG, "what name: " + coinName);

                        mItems.add(new Items(coinName,coinPrice,coinRank,coinChange,coinPriceToBtc));

                    }
                    mAdapter = new ItemAdapter(MainActivity.this , mItems);
                    mRecyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
