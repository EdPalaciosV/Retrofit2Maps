package com.example.usuario.googlemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_buscar_direccion)
    EditText edtBuscarDireccion;
    @BindView(R.id.btn_buscar_direccion)
    Button btnBuscarDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_buscar_direccion)
    public void onViewClicked() {
        Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
    }
}
