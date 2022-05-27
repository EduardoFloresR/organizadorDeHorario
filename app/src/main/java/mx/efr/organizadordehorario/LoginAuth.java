package mx.efr.organizadordehorario;

//region Bibliotecas y elementos
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Arrays;
import java.util.List;
//endregion

public class LoginAuth extends AppCompatActivity {

    //region Atributos
    private static final int AUTH_REQUEST_CODE = 1205;
    private FirebaseAuth firebaseAuth; //Manipulará la sesión del usuario
    private FirebaseAuth.AuthStateListener listener; //Manipulará la sesión de acuerdo al ciclo de vida
    private List<AuthUI.IdpConfig> proveedores;
    //endregion

    //region Métodos
    //Sobrecarga del método onStart
    @Override
    protected void onStart()
    {
        super.onStart();
        firebaseAuth.addAuthStateListener(listener);
    }
    //Sobrecarga del método onStop
    @Override
    protected void onStop()
    {
        if(listener != null)
        {
            firebaseAuth.removeAuthStateListener(listener);
        }
        super.onStop();
    }
    //Sobrecarga del método onCreate. Manda llamar los métodos CargarProveedores() y login()
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        CargarProveedores();
        login();
    }
    //Método CargarProveedores()
    private void CargarProveedores()
    {
        proveedores = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build() //agrega el botón de Google
        );
    }
    //Método login()
    private void login() {
        firebaseAuth = FirebaseAuth.getInstance(); //Solamente se ejecuta una vez en toda la aplicación
        listener = new FirebaseAuth.AuthStateListener() {
            //Sorecarga del método onAuthStateChanged
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser usuario = firebaseAuth.getCurrentUser();
                if(usuario != null)
                {
                    Intent intMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intMain);
                }
                else
                {
                    startActivityForResult(AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(proveedores)
                            .build(), AUTH_REQUEST_CODE
                    );
                }
            }
        };
    }
    //endregion
}