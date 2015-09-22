package com.example.volleyokhttp;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.util.OkHttpStack;
import com.squareup.okhttp.OkHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	Button button = (Button) findViewById(R.id.button1);
	button.setOnClickListener(new OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		requestNetWork();
	    }
	});
    }

    private void requestNetWork() {
	OkHttpClient okHttpClient = new OkHttpClient();
	RequestQueue requestQueue = Volley.newRequestQueue(this, new OkHttpStack(okHttpClient));
//	RequestQueue requestQueue = Volley.newRequestQueue(this);
	StringRequest stringRequest = new StringRequest("https://www.baidu.com", new Response.Listener<String>() {

	    @Override
	    public void onResponse(String response) {
		 Log.d("TAG", response);  
	    }
	}, new Response.ErrorListener() {

	    @Override
	    public void onErrorResponse(VolleyError error) {
		 Log.e("TAG", error.getMessage(), error);  
	    }
	});
	requestQueue.add(stringRequest);
    }
}
