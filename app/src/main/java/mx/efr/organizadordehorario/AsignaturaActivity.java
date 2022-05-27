package mx.efr.organizadordehorario;

//region Bibliotecas y elementos
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import mx.efr.organizadordehorario.fragments.AgregarFragment;
import mx.efr.organizadordehorario.fragments.AsignaturaFragment;
import mx.efr.organizadordehorario.fragments.BuscarFragment;
import mx.efr.organizadordehorario.fragments.MisActividadesFragment;
//endregion

public class AsignaturaActivity extends AppCompatActivity {

    //region Atributos de la Clase
    private AsignaturaFragment asignaturaFragment;
    private BuscarFragment buscarFragment;
    private AgregarFragment agregarFragment;
    private MisActividadesFragment misActividadesFragment;
    //endregion

    //region Métodos
    //Sobrecarga del método onCreate para la clase AsignaturaActivity
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        BottomNavigationView btmNavigationPrincipal; //Declarando variable local tipo BottomNavigationView
        btmNavigationPrincipal = findViewById(R.id.btmNavigationPrincipal); //Se relaciona el elemento BottomNavigationView de la vista con la variable antes declarada
        btmNavigationPrincipal.setOnItemSelectedListener(navListener); //Se asigna un evento de selección 'OnItemSelectedListener' al BottomNavigationView llamado "btmNavigationPrincipal"

        //Instanciando los fragments AsignaturaFragment, BuscarFragment, MisActividadesFragmet y AgregarFragment
        asignaturaFragment = new AsignaturaFragment();
        buscarFragment = new BuscarFragment();
        agregarFragment = new AgregarFragment();
        misActividadesFragment = new MisActividadesFragment();

        //Se relaciona al fragment contenedor de "activity_asignatura" y se reemplaza en un inicio por el fragment "asignaturaFragment"
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,asignaturaFragment).commit();
    }

    //Evento 'OnItemSelectedListener' que se activa cuando se selecciona alguno de los íconos del 'BottomNavigationView'
    NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        //Sobrecarga del método onNavigationItemSelected, que nos muestra uno de los 4 fragments anteriores dependiento del ícono del BottomNavigationView que se seleccione
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.nav_asignatura:
                    //Se reemplaza el fragment contenedor por el fragment "asignaturaFragment"
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,asignaturaFragment).commit();
                    break;
                case R.id.nav_buscar:
                    //Se reemplaza el fragment contenedor por el fragment "buscarFragment"
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,buscarFragment).commit();
                    break;
                case R.id.nav_agregar:
                    //Se reemplaza el fragment contenedor por el fragment "misActividadesFragment"
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,agregarFragment).commit();
                    break;
                case R.id.nav_misActividades:
                    //Se reemplaza el fragment contenedor por el fragment "agregarFragment"
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,misActividadesFragment).commit();
                    break;
            }
            return true;
        }
    };
    //endregion
}