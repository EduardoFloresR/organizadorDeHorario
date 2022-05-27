package mx.efr.organizadordehorario;

//region Bibliotecas y elementos
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//endregion

public class SesionActivity extends AppCompatActivity {

    //region Atributos
    private EditText edtNombre;
    private EditText edtPassword;
    private Button btnEntrar;
    private String usuario = "";
    private String password = "";
    private TextView txtvRegistro;
    //endregion

    //region Métodos
    //Sobrecarga del método onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        edtNombre = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtContrasena);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(onClickEntrar);
        txtvRegistro = findViewById(R.id.txtvRegistro);
        cargarPreferencias();
        txtvRegistro.setOnClickListener(onClickReg);
    }
    //Método cargar preferencias
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences(getResources().getString(R.string.strCredenciales),MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String user = preferences.getString(getResources().getString(R.string.strUser),"");
        String password = preferences.getString(getResources().getString(R.string.strPassword),"");

        edtNombre.setText(user);
        edtPassword.setText(password);
    }
    //Evento OnClickListener que recibe un click (sobre el botón) para ser activado
    View.OnClickListener onClickReg = View ->   //Expresión Lambda
    {
        // Lleva al activity "LoginAuth"
        Intent intentRegistro = new Intent(SesionActivity.this,LoginAuth.class);
        startActivity(intentRegistro);
    };
    //Evento OnClickListener que recibe un click (sobre el botón) para ser activado
    View.OnClickListener onClickEntrar = new View.OnClickListener()
    {
        //Sobrecarga del método onClick
        @Override
        public void onClick(View view)
        {
            //Si la validación es correcta, lleva a la patalla principal
            if(Valida())
            {
                Toast.makeText(getApplicationContext(),"おはようございます。",Toast.LENGTH_LONG).show();
                Intent intMain = new Intent(SesionActivity.this,MainActivity.class);
                startActivity(intMain);
            }
            //Si no se cumple condición, se muestra el mensaje "Usuario o contraseña incorrecta"
            else
            {
                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
            }
        }
    };
    //Método Valida(). Verifica que el usuario y contraseña sean correctos
    private boolean Valida()
    {
        try
        {
            usuario = edtNombre.getText().toString();
            password = edtPassword.getText().toString();
        }
        catch (Exception error)
        {
            Log.d("Loging:", "Error en los datos :" +error.toString());
        }

        if(usuario.equals("lalo") && password.equals("lalo"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //endregion
}