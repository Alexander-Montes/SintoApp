package co.edu.unab.misiontic2022.sintoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.R;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerLista;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerReportes;

public class ListaAdapter extends BaseAdapter {
    private List<ObtenerLista> listas;
    private Context context;

    public ListaAdapter(Context context, List<ObtenerLista> listas) {
        this.context=context;
        this.listas = listas;
    }

    @Override
    public int getCount() {
        return listas.size();
    }

    @Override
    public Object getItem(int position) {
        return listas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_estudiantes, null);
        }
        ObtenerLista lista = listas.get(position);

        TextView txtNombreEs = convertView.findViewById(R.id.txtNombreEs);
        TextView txtEstadoEs = convertView.findViewById(R.id.txtEstadoEs);

        txtNombreEs.setText(lista.getNombres());
        txtEstadoEs.setText("" + lista.getEstado());

        return convertView;
    }
}
