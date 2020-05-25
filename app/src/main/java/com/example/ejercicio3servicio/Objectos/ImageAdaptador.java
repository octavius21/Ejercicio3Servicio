package com.example.ejercicio3servicio.Objectos;
//creo que no me ayuda... yo tampoco creo que ayude en nada
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdaptador extends BaseAdapter {
    Context context;
    int ancho;

    private int[]thumbs={};

    public ImageAdaptador(Context context, int acnho) {
        this.context = context;
        this.ancho = ancho;
    }

    @Override
    public int getCount() {
        return thumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return thumbs[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(ancho/4-20,ancho/4-20));
        imageView.setPadding(15,15,15,15);
        imageView.setImageResource(thumbs[position]);
        return imageView;
    }
}
