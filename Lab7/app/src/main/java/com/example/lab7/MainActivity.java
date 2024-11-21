package com.example.lab7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private EdificacionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos del layout
        EditText filtro = findViewById(R.id.filtroEdificaciones);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEdificaciones);

        // Dataset
        List<Edificacion> edificaciones = Arrays.asList(
                new Edificacion("Catedral", "Religiosa", "Edificación histórica del siglo XVI", R.drawable.catedral),
                new Edificacion("Museo", "Cultural", "Contiene arte precolombino", R.drawable.museo),
                new Edificacion("Castillo", "Defensiva", "Construcción medieval", R.drawable.castillo)
        );

        // Configurar el RecyclerView
        adapter = new EdificacionAdapter(edificaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Lógica para el filtro
        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filtrar(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}