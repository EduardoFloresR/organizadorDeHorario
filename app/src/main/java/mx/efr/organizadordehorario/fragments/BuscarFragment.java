package mx.efr.organizadordehorario.fragments;

//region Bibliotecas y elementos
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import mx.efr.organizadordehorario.R;
//endregion

public class BuscarFragment extends Fragment {

    //region Atributos
    private Button btnBuscar;
    private EditText edtClaveB, edtGrupoB;
    //endregion

    //region Métodos
    //Sobrecarga del método onCreate
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        View v = inflater.inflate(R.layout.fragment_buscar,container,false); //Vinculando al archivo xml "fragment_buscar"
        btnBuscar = v.findViewById(R.id.btnBuscar); //Se relaciona el botón de la vista con el atributo "btnBuscar" antes declarado
        edtClaveB = v.findViewById(R.id.edtClaveB); //Se relaciona el EditText de la vista con el atributo "edtClaveB" antes declarado
        edtGrupoB = v.findViewById(R.id.edtGrupoB); //Se relaciona el EditText de la vista con el atributo "edtGrupoB" antes declarado
        btnBuscar.setOnClickListener(new View.OnClickListener() { // Se asigna un evento 'OnClickListener' al botón "btnBuscar"
            //Sobrecarga del método onClick
            @Override
            public void onClick(View view)
            {
                //Se verifica que la calve tenga 3 o 4 dígitos y el grupo no pase de 99 (no hay grupos de más dígitos)
                if(((edtClaveB.getText().length() == 4) || (edtClaveB.getText().length() == 3)) && ((edtGrupoB.getText().length() == 1) || (edtGrupoB.getText().length() == 2)))
                {
                    String stBusca = edtClaveB.getText().toString() +"+"+edtGrupoB.getText().toString(); //Se crea una cadena con el formato: clave+grupo
                    Bundle lazo = new Bundle(); //Declaración de variable local "lazo" de tipo Bundle
                    lazo.putString("stBusca",stBusca);
                    InfoFragment infoFragment = new InfoFragment(); //Instancia del fragment "InfoFragment"
                    infoFragment.setArguments(lazo);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragmentContenedor, infoFragment); //Se reemplaza el fragment contenedor por el fragment "InfoFragment"
                    Toast.makeText(getContext(),"Buscando",Toast.LENGTH_SHORT).show(); //Aparece mensaje "Buscando"
                    ft.commit();
                }
                else
                {
                    Toast.makeText(getContext(), "Revisa los datos", Toast.LENGTH_SHORT).show(); //Aparece mensaje "Rrevisa los datos"
                }
            }
        });
        return v; //Se devuelve la vista a mostrar
    }
    //endregion
}