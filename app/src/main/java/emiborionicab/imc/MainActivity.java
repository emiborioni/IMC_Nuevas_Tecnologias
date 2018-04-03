package emiborionicab.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    EditText etPeso, etAltura;
    TextView tvResultado;
    ImageView ivResultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        ivResultado = findViewById(R.id.ivResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interpretaIMC(imc(etPeso.getText().toString(), etAltura.getText().toString()));
            }
        });
    }
    private float imc(String Strpeso, String Straltura){
        float peso = Float.parseFloat(Strpeso);
        float altura = Float.parseFloat(Straltura);
        return peso/(altura*altura);
    }
    private void interpretaIMC(float imc){
        String Resultado = "";
        String urlFoto ="";
        if(imc<18.5){
            Resultado= "Bajo Peso";
            urlFoto="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkKcOGQtg3AhRPnpDosFliZtgRBoKmlWncOLIwZ4bBoa976Fb9";
        }
        if(imc>18.5 && imc<25){
            Resultado="Peso Normal";
            urlFoto="https://i.ytimg.com/vi/j56PN9yf7OU/maxresdefault.jpg";
        }
        if(imc>25){
            Resultado="Sobre Peso";
            urlFoto="https://st2.depositphotos.com/1252160/10253/i/950/depositphotos_102534762-stock-photo-overweight-person-enjoy-burger-and.jpg";
        }
        tvResultado.setText(Resultado);
        Picasso.get().load(urlFoto).into(ivResultado);
    }
}
