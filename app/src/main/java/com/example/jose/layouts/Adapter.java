package com.example.jose.layouts;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Claudio on 04/03/2017.
 */

public class Adapter extends AppCompatActivity {
    public static Formularios documentoNecesario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.documentos_layout);

        MyAdapter adapter= new MyAdapter(documentoNecesario.getDocumentosNecesarios(), getApplicationContext());
        ListView lista=(ListView)findViewById(R.id.lista);

        lista.setAdapter(adapter);
    }



    public class MyAdapter extends BaseAdapter{
        private ArrayList<DocumentoNecesario> necesario;
        private LayoutInflater inflater;

        MyAdapter(ArrayList <DocumentoNecesario> formulario, Context context){
            this.inflater= LayoutInflater.from(context);
            this.necesario=formulario;
        }

        @Override
        public int getCount() {
            return necesario.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView=inflater.inflate(R.layout.operaciones_plantilla, null);
            }
            System.out.println(necesario.size());
            TextView documentacion=(TextView)convertView.findViewById(R.id.textView);
            ImageView imagen=(ImageView)convertView.findViewById(R.id.imageView);
            imagen.setImageResource(necesario.get(position).getImagenes());
            documentacion.setText(necesario.get(position).getDocumentacion());

            return convertView;
        }
    }


}

