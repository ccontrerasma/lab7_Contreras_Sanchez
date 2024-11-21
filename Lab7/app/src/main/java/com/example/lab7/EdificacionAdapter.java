package com.example.lab7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EdificacionAdapter extends RecyclerView.Adapter<EdificacionAdapter.EdificacionViewHolder> {
    private List<Edificacion> edificaciones;
    private List<Edificacion> edificacionesFiltradas;

    public EdificacionAdapter(List<Edificacion> edificaciones) {
        this.edificaciones = edificaciones;
        this.edificacionesFiltradas = new ArrayList<>(edificaciones);
    }

    @NonNull
    @Override
    public EdificacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edificacion, parent, false);
        return new EdificacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EdificacionViewHolder holder, int position) {
        Edificacion edificacion = edificacionesFiltradas.get(position);
        holder.titulo.setText(edificacion.getTitulo());
        holder.categoria.setText(edificacion.getCategoria());
        holder.descripcion.setText(edificacion.getDescripcion());
        holder.imagen.setImageResource(edificacion.getImagen());
    }

    @Override
    public int getItemCount() {
        return edificacionesFiltradas.size();
    }

    public void filtrar(String texto) {
        edificacionesFiltradas.clear();
        if (texto.isEmpty()) {
            edificacionesFiltradas.addAll(edificaciones);
        } else {
            texto = texto.toLowerCase();
            for (Edificacion e : edificaciones) {
                if (e.getTitulo().toLowerCase().contains(texto)) {
                    edificacionesFiltradas.add(e);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class EdificacionViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, categoria, descripcion;
        ImageView imagen;

        public EdificacionViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloEdificacion);
            categoria = itemView.findViewById(R.id.categoriaEdificacion);
            descripcion = itemView.findViewById(R.id.descripcionEdificacion);
            imagen = itemView.findViewById(R.id.imagenEdificacion);
        }
    }
}
