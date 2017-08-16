package com.example.admin.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, DinamicLinearActivity.class));

        rvLista = (RecyclerView) findViewById(R.id.rvLista);

        ArrayList<String> datos = new ArrayList<>();
        datos.add("A");
        datos.add("B");
        datos.add("C");
        datos.add("D");
        datos.add("E");
        datos.add("F");

        ListAdapter adapter = new ListAdapter(datos);
        rvLista.setAdapter(adapter);
        rvLista.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvLista.setLayoutManager(layoutManager);

        rvLista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
