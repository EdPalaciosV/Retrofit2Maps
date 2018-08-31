package com.example.usuario.googlemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.googlemaps.Service.LoadJson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements showResults {

    @BindView(R.id.edt_buscar_direccion)
    EditText edtBuscarDireccion;
    @BindView(R.id.btn_buscar_direccion)
    Button btnBuscarDireccion;

    final String TAG_LAT="LATITUD";
    final String TAG_LONG="LONGITUD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_buscar_direccion)
    public void onViewClicked() {

        LoadJson loadJson=new LoadJson(this,edtBuscarDireccion.getText().toString());
        loadJson.getValues();
    }

    @Override
    public void getLatLong(double latitud, double longitud) {

        Bundle bundle = new Bundle();
        bundle.putDouble(TAG_LAT,latitud);
        bundle.putDouble(TAG_LONG,longitud);

        Intent intent=new Intent(this,MapsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
