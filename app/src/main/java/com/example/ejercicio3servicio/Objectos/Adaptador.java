package com.example.ejercicio3servicio.Objectos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejercicio3servicio.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater=null;

    Context contexto;
    ArrayList<Producto> arrayList_producto;
    int ancho;
    CargaImagen cargaImagen=new CargaImagen();

    public Adaptador(Context contexto, ArrayList<Producto> arrayList) {
        this.contexto = contexto;
        this.arrayList_producto=arrayList;
        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList_producto.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList_producto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)arrayList_producto.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista=inflater.inflate(R.layout.prototipo,null);
        TextView tvNombre=vista.findViewById(R.id.tvNombre);
        TextView tvPrecio=vista.findViewById(R.id.tvPrecioProducto);
        TextView tvCosto=vista.findViewById(R.id.tvCosto);
        TextView tvProveedor=vista.findViewById(R.id.tvProveedor);
        ImageView imageView=vista.findViewById(R.id.imageView);
        //ImageView imageView=new ImageView(contexto);
        Picasso.with(contexto).load(arrayList_producto.get(position).getImagen()).into(imageView);
        tvNombre.setText(arrayList_producto.get(position).getNombbre());
        tvPrecio.setText("$"+String.valueOf(arrayList_producto.get(position).getPrecio()));
        tvCosto.setText("$"+String.valueOf(arrayList_producto.get(position).getCosto()));
        tvProveedor.setText(arrayList_producto.get(position).getProveedor());
        int id=arrayList_producto.get(position).getId();

//        imageView.setImageBitmap(cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(),arrayList_producto.get(position).getId(),100,100));
//        imageView.setLayoutParams(new ListView.LayoutParams(ancho/4-20,ancho/4-20));
//        imageView.setPadding(15,15,15,15);
//        imageView.setImageResource(position);
        return vista;
    }
    public Context getContexto() {
        return contexto;
    }
}
