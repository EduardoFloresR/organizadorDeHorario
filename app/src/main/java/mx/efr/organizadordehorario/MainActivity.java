package mx.efr.organizadordehorario;

//region Bibliotecas
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//endregion

public class MainActivity extends AppCompatActivity {

    //region Atributos
    private Button btnHorariosFI;
    //endregion

    //region Métodos
    //Sobrecarga del método onCreate para la clase MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHorariosFI = findViewById(R.id.btnHorariosFI); //Se relaciona el botón "HORARIOS FI" de la pantalla principal con el atributo Button antes declarado
        btnHorariosFI.setOnClickListener(onClickHorariosFI); //Se asigna un evento 'onClickListener' al botón "HORARIOS FI"
    }
    //Evento OnClickListener que recibe un click (sobre el botón) para ser activado
    View.OnClickListener onClickHorariosFI = new View.OnClickListener()
    {
        //Sobrecarga del método onClick para la clase ActivityMain, el cual nos lleva a una nueva vista "AsignaturaActivity"
        @Override
        public void onClick(View view) {
            Intent intentMenu = new Intent(MainActivity.this, AsignaturaActivity.class);
            startActivity(intentMenu);
        }
    };
    //endregion
}