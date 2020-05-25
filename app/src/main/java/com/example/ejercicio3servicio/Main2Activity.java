package com.example.ejercicio3servicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity implements Response.ErrorListener,Response.Listener<String>{
    private static final String LOGTAG="Informacion2";
    ImageView imageView2;
    TextView tvNombre,tvDesc;
    ProgressBar pbConexiona;
    String url;
    RequestQueue queue;
    StringRequest request;
    long aux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView2=findViewById(R.id.imageView2);
        pbConexiona=findViewById(R.id.pbConexiona);
        tvNombre=findViewById(R.id.tvNombre);
        tvDesc=findViewById(R.id.tvDesc);

        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        final long id=bundle.getLong("ID");
        aux=id;
        Log.i(LOGTAG, "ID original: "+id);
//        Toast.makeText(Main2Activity.this,"ID original: "+id, Toast.LENGTH_SHORT).show();

        queue= Volley.newRequestQueue(this);
        url=getResources().getString(R.string.url_base2)+id;

        request=new StringRequest(Request.Method.POST,url,this,this){
          protected Map<String,String> getParams(){
              Map<String,String> params=new HashMap<>();
              params.put("id",String.valueOf(id));
              return params;
            }
        };
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pbConexiona.setVisibility(View.GONE);
        finish();
    }

    @Override
    public void onResponse(String response) {
        pbConexiona.setVisibility(View.GONE);
        try {
            JSONObject jsonObject = new JSONObject(response);
            tvNombre.setText(jsonObject.getString("name"));
            tvDesc.setText(jsonObject.getString("desc"));
            //no me muestra la imagen :( NOSE por que
            Picasso.with(this).load(getResources().getString(R.string.url_base2)+aux+" "+jsonObject.getString("imag_url")).into(imageView2);
            Picasso.with(this).load(getResources().getString(R.string.url_base2)+aux+jsonObject.getString("imag_url")).into(imageView2);
            Picasso.with(this).load(getResources().getString(R.string.url_base2)+aux+""+jsonObject.getString("imag_url")).into(imageView2);
            Picasso.with(this).load(url+""+jsonObject.getString("imag_url")).into(imageView2);
            Picasso.with(this).load(url+" "+jsonObject.getString("imag_url")).into(imageView2);
            Log.i(LOGTAG, getResources().getString(R.string.url_base2)+aux+" "+jsonObject.getString("imag_url"));
            Log.i(LOGTAG, getResources().getString(R.string.url_base2)+" "+jsonObject.getString("imag_url"));
            Log.i(LOGTAG, url+""+jsonObject.getString("imag_url"));
        }catch(JSONException error){

        }
    }


}
