package co.edu.unab.misiontic2022.sintoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.R;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerReportes;

public class HistorialAdapter extends BaseAdapter {
    private List<ObtenerReportes> reportes;
    private Context context;

    public HistorialAdapter(Context context, List<ObtenerReportes> reportes) {
        this.context=context;
        this.reportes = reportes;
    }

    @Override
    public int getCount() {
        return reportes.size();
    }

    @Override
    public Object getItem(int position) {
        return reportes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reportes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_historial, null);
        }
        ObtenerReportes reporte = reportes.get(position);

        TextView txtFecha = convertView.findViewById(R.id.txtFecha);
        TextView txtR1 = convertView.findViewById(R.id.txtR1);
        TextView txtR2 = convertView.findViewById(R.id.txtR2);
        TextView txtR3 = convertView.findViewById(R.id.txtR3);
        TextView txtR4 = convertView.findViewById(R.id.txtR4);
        TextView txtR5 = convertView.findViewById(R.id.txtR5);
        TextView txtREstado = convertView.findViewById(R.id.txtREstado);

        txtFecha.setText(reporte.getFecha());
        txtR1.setText("" + reporte.getP1());
        txtR2.setText("" + reporte.getP2());
        txtR3.setText("" + reporte.getP3());
        txtR4.setText("" + reporte.getP4());
        txtR5.setText("" + reporte.getP5());
        txtREstado.setText(String.valueOf(reporte.getEstado()));
        //{String.valueOf() == "" + }

        return convertView;
    }
}
