package com.example.trabalho1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptor extends BaseAdapter {
    private Context ctx;
    private int[]lista;

    public Adaptor(Context ctx, int[] lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv= new ImageView(ctx);
        iv.setImageResource(lista[i]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(500,500));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(5,5,5,5);

        return iv;
    }
}
