package com.example.jose.layouts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private ListView ListaFor;
    private ArrayList<Formularios> formularios = new ArrayList<>();
    private MyAdapter adapter1;
    private SearchView sear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ArrayList<DocumentoNecesario> necesario = new ArrayList<>();
        necesario.add(new DocumentoNecesario("DNI", R.drawable.ic_explore_black_24dp));
        necesario.add(new DocumentoNecesario("Cuenta Bancaria", R.drawable.ic_explore_black_24dp));
        Formularios a = new Formularios("Transferencia", necesario, R.drawable.ic_explore_black_24dp);
        formularios.add(a);
        ArrayList<DocumentoNecesario> necesarioo = new ArrayList<>();
        necesarioo.add(new DocumentoNecesario("DNI", R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Cuenta Bancaria",R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Pasaporte", R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Abal", R.drawable.ic_explore_black_24dp));
        a=new Formularios("Cobrar Cheque", necesarioo, R.drawable.ic_explore_black_24dp);
        formularios.add(a);

        initialize();
        ListaFor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Adapter.documentoNecesario=formularios.get(position);
                System.out.println(formularios.get(position).getDocumentosNecesarios().size());
                Intent familyIntent=new Intent(Principal.this, Adapter.class);
                startActivity(familyIntent);

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //permite modificar el hint que el EditText muestra por defecto
        searchView.setQueryHint("Buscar");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //se oculta el EditText
                searchView.setQuery("", false);
                searchView.setIconified(true);



                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        adapter1.getFilter().filter(query);

                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapter1.getFilter().filter(newText);

                        return false;
                    }
                });
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void initialize() {
        ListaFor = (ListView)findViewById(R.id.lista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter1 = new MyAdapter(Principal.this, formularios);
        ListaFor.setAdapter(adapter1);
    }


    // Adapter Class
    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<Formularios> ListaOriginal;
        private ArrayList<Formularios> ListaActualizada;
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<Formularios> ListaFormularios) {
            this.ListaOriginal = ListaFormularios;
            this.ListaActualizada = ListaFormularios;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return ListaActualizada.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class VistaList {
            LinearLayout relativeLayout;
            TextView tvName;
            ImageView icono;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            VistaList holder = null;

            if (convertView == null) {

                holder = new VistaList();
                convertView = inflater.inflate(R.layout.operaciones_plantilla, null);
                holder.relativeLayout = (LinearLayout) convertView.findViewById(R.id.relative);
                holder.tvName = (TextView) convertView.findViewById(R.id.textView);
                holder.icono=(ImageView)convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);

            } else {
                holder = (VistaList) convertView.getTag();
            }
            holder.tvName.setText(ListaActualizada.get(position).getNombre());
            holder.icono.setImageResource(ListaActualizada.get(position).getImg());



            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,Filter.FilterResults results) {

                    ListaActualizada = (ArrayList<Formularios>) results.values;
                    notifyDataSetChanged();
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    ArrayList<Formularios> FilteredArrList = new ArrayList<>();
                    if (ListaOriginal == null) {
                        ListaOriginal = new ArrayList<>(ListaActualizada);
                    }
                    if (constraint == null || constraint.length() == 0) {

                        results.count = ListaOriginal.size();
                        results.values = ListaOriginal;
                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < ListaOriginal.size(); i++) {
                            String data = ListaOriginal.get(i).getNombre();
                            if (data.toLowerCase().startsWith(constraint.toString())) {
                                FilteredArrList.add(new Formularios(ListaOriginal.get(i).getNombre(), ListaOriginal.get(i).getDocumentosNecesarios(), ListaOriginal.get(i).getImg()));
                            }
                        }
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }

}
