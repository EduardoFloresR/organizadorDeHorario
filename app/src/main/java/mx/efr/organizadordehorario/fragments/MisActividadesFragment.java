package mx.efr.organizadordehorario.fragments;

//region Bibliotecas
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//endregion

import mx.efr.organizadordehorario.R;

public class MisActividadesFragment extends Fragment {

    //region Atributos
    private static final String FILE_NAME = "actividades.txt";
    private Button btnBorrarLista;
    private String actividades[];
    private String datos;
    private TextView txtvMisActividades;
    //endregion

    //region Métodos
    // Sobrecarga del método onCreate
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        View v = inflater.inflate(R.layout.fragment_mis_actividades,container,false);
        datos = "";
        Leer(); // Se abre el archivo de texto para leerlo
        Imprimir(); // Se saca el contenido del archivo y se divide por actividad
        txtvMisActividades = v.findViewById(R.id.txtvMisActividades); // Se relaciona el TextView
        if(!datos.equals("[]\n")) // Se verifica que el archivo de texto no esté vacío
        {
            txtvMisActividades.setText(datos); // Se imprime el contido del archivo en el TextView
        }
        else
        {
            txtvMisActividades.setText("Prueba agregando una actividad"); // Se recomienda agregar una actividad
        }
        btnBorrarLista = v.findViewById(R.id.btnBorrar); // Se relaciona el botón Borrar
        btnBorrarLista.setOnClickListener(onClickBorrarLista); // Se establece el evento de Click
        return v;
    }

    // Evento OnClick del botón borrar
    View.OnClickListener onClickBorrarLista = new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            Borrar();
            txtvMisActividades.setText("");
        }
    };

    // Método de lectura del archivo
    private void Leer() {
        FileInputStream fis = null;
        try {
            fis = getActivity().openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String lineas;
            while ((lineas = br.readLine()) != null) {
                sb.append(lineas);
            }
            actividades = sb.toString().split("\\?");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método de vacíado de datos del archivo en la cadena
    private void Imprimir() {
        for(int i = 0; i < actividades.length; i++)
        {
            datos = datos + Arrays.toString(actividades[i].split("\\+")) + "\n";
        }
    }

    // Método de borrar el archivo
    private void Borrar() {
        FileOutputStream fos = null; // Se abre el archivo en modo de escritura
        try {
            fos = getActivity().openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            String texto = ""; // Se escribe una cadena vacía
            fos.write(texto.getBytes());
            Toast.makeText(getContext(),"Borrado",Toast.LENGTH_SHORT).show(); // Mensaje de confirmación de borrado
            Log.d("Ruta del archivo",getActivity().getFilesDir() + "/" + FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //endregion
}