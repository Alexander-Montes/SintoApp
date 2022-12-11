package co.edu.unab.misiontic2022.sintoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.R;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerCursos;

public class CursosAdapter extends BaseAdapter {
    private List<ObtenerCursos> cursos;
    private Context context;

    public CursosAdapter(Context context, List<ObtenerCursos> cursos) {
        this.context=context;
        this.cursos = cursos;
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cursos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cursos, null);
        }
        ObtenerCursos curso = cursos.get(position);

        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        TextView txtCodigo = convertView.findViewById(R.id.txtCodigo);
        TextView txtDias = convertView.findViewById(R.id.txtDias);

        txtNombre.setText(curso.getNombre());
        txtCodigo.setText(curso.getCodigo());
        txtDias.setText(curso.getDias());
        return convertView;
    }
}
