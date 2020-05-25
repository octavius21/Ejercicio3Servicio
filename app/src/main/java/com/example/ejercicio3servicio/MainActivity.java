package com.example.ejercicio3servicio;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejercicio3servicio.Objectos.Adaptador;
import com.example.ejercicio3servicio.Objectos.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener,Response.Listener<JSONArray> {
    ListView lvtienda;
    Producto producto;
    ArrayList<Producto> arrayList;
    ProgressBar pbConexion;
    String url;
    RequestQueue queue;
    JsonArrayRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvtienda=findViewById(R.id.lvTienda);
        pbConexion=findViewById(R.id.pbConexion);

        arrayList=new ArrayList<Producto>();
        queue= Volley.newRequestQueue(this);
        url=getResources().getString(R.string.url_base);
        request= new JsonArrayRequest(Request.Method.GET,url,null,this,this);
        queue.add(request);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pbConexion.setVisibility(View.GONE);
        finish();
    }

    @Override
    public void onResponse(JSONArray response) {
        pbConexion.setVisibility(View.GONE);
        Log.d("RESPUESTA",response.toString());

        JSONObject jsonObject;
        try{
            for(int i=0; i<response.length();i++){
                jsonObject=response.getJSONObject(i);
                int id=jsonObject.getInt("id");
                String name=jsonObject.getString("name");
                String thumbnail_url=jsonObject.getString("thumbnail_url");
                int price=jsonObject.getInt("price");
                String provider=jsonObject.getString("provider");
                int delivery=jsonObject.getInt("delivery");

                producto=new Producto(id,price,delivery,name,provider,thumbnail_url,this);
                arrayList.add(producto);
            }
            final Adaptador adaptador=new Adaptador(this,arrayList);
            lvtienda.setAdapter(adaptador);
            lvtienda.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("ID",id);
                    startActivity(intent);
                }});


        }catch(JSONException e){

        }
    }
}
