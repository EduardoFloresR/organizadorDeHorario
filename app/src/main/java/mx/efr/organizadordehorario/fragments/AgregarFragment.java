package mx.efr.organizadordehorario.fragments;

//region Bibliotecas y elementos
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mx.efr.organizadordehorario.R;
//endregion

public class AgregarFragment extends Fragment {

    //region Atributos
    private static final String FILE_NAME = "actividades.txt";
    private Button btnGuardar;
    private EditText edtActividad;
    private AutoCompleteTextView actvHoraInicio, actvHoraFin;
    private RadioButton rbtnLunes, rbtnMartes, rbtnMiercoles, rbtnJueves, rbtnViernes, rbtnSabado, rbtnDomingo;
    //endregion

    //Sobrecarga del método onCreateView
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        View v = inflater.inflate(R.layout.fragment_agregar,container,false); //Vinculando al archivo xml "fragment_agregar"
        //region Relación de componentes (findViewById)
        btnGuardar = v.findViewById(R.id.btnGuardar); //Se relaciona el botón de la vista con el atributo "btnGuardar" antes declarado
        edtActividad = v.findViewById(R.id.edtActividad); //Se relaciona el EditText de la vista con el atributo "edtActividad" antes declarado
        rbtnLunes = v.findViewById(R.id.rbtnLunes); // Se relacionan los RadioButton de los días de la semana
        rbtnMartes = v.findViewById(R.id.rbtnMartes);
        rbtnMiercoles = v.findViewById(R.id.rbtnMiercoles);
        rbtnJueves = v.findViewById(R.id.rbtnJueves);
        rbtnViernes = v.findViewById(R.id.rbtnViernes);
        rbtnSabado = v.findViewById(R.id.rbtnSabado);
        rbtnDomingo = v.findViewById(R.id.rbtnDomingo);
        //endregion
        //region Relación de AutoCompleteTextView y TextInputLayout
        String[] horas = getResources().getStringArray(R.array.HorasInicio); // Obteniendo las horas del array HorasInicio
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.list_item, horas); // Se guardan las horas en el adaptador
        actvHoraInicio = v.findViewById(R.id.actvHoraInicio); // Se relaciona el AutoCompleteText
        actvHoraInicio.setAdapter(adapter); // Se establece el adaptador
        actvHoraInicio.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Selección de hora de inicio
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), "Hora de inicio: "+item, Toast.LENGTH_SHORT).show();
            }
        });
        actvHoraFin = v.findViewById(R.id.actvHoraFin); // Se relaciona el AutoCompleteText
        actvHoraFin.setAdapter(adapter); // Se establece el adaptador
        actvHoraFin.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Selección de hora de fin
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), "Hora de fin: "+item, Toast.LENGTH_SHORT).show();
            }
        });
        //endregion
        //region onClickListener
        btnGuardar.setOnClickListener(onClickGuardar); // //Se asigna un evento 'OnClickListener' al Buttton y a los RadioButton
        rbtnLunes.setOnClickListener(onClickrbtnLunes);
        rbtnMartes.setOnClickListener(onClickrbtnMartes);
        rbtnMiercoles.setOnClickListener(onClickrbtnMiercoles);
        rbtnJueves.setOnClickListener(onClickrbtnJueves);
        rbtnViernes.setOnClickListener(onClickrbtnViernes);
        rbtnSabado.setOnClickListener(onClickrbtnSabado);
        rbtnDomingo.setOnClickListener(onClickrbtnDomingo);
        //endregion
        return v; //Se devuelve la vista a mostrar
    }

    //region OnClickListener RadioButton
    View.OnClickListener onClickrbtnLunes =View-> //Métodos repetido para permitir seleccionar y deseleccionar los RadioButton
    {
        if(rbtnLunes.isSelected())
        {
            rbtnLunes.setChecked(false);
            rbtnLunes.setSelected(false);
        }
        else
        {
            rbtnLunes.setChecked(true);
            rbtnLunes.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnMartes =View->
    {
        if(rbtnMartes.isSelected())
        {
            rbtnMartes.setChecked(false);
            rbtnMartes.setSelected(false);
        }
        else
        {
            rbtnMartes.setChecked(true);
            rbtnMartes.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnMiercoles =View->
    {
        if(rbtnMiercoles.isSelected())
        {
            rbtnMiercoles.setChecked(false);
            rbtnMiercoles.setSelected(false);
        }
        else
        {
            rbtnMiercoles.setChecked(true);
            rbtnMiercoles.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnJueves =View->
    {
        if(rbtnJueves.isSelected())
        {
            rbtnJueves.setChecked(false);
            rbtnJueves.setSelected(false);
        }
        else
        {
            rbtnJueves.setChecked(true);
            rbtnJueves.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnViernes =View->
    {
        if(rbtnViernes.isSelected())
        {
            rbtnViernes.setChecked(false);
            rbtnViernes.setSelected(false);
        }
        else
        {
            rbtnViernes.setChecked(true);
            rbtnViernes.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnSabado =View->
    {
        if(rbtnSabado.isSelected())
        {
            rbtnSabado.setChecked(false);
            rbtnSabado.setSelected(false);
        }
        else
        {
            rbtnSabado.setChecked(true);
            rbtnSabado.setSelected(true);
        }
    };
    View.OnClickListener onClickrbtnDomingo =View->
    {
        if(rbtnDomingo.isSelected())
        {
            rbtnDomingo.setChecked(false);
            rbtnDomingo.setSelected(false);
        }
        else
        {
            rbtnDomingo.setChecked(true);
            rbtnDomingo.setSelected(true);
        }
    };
    //endregion
    //region OnClickListener btnGuardar y Salvar()
    //Evento OnClickListener que recibe un click (sobre el botón) para ser activado
    View.OnClickListener onClickGuardar = new View.OnClickListener() // Método para guardar las actividades y dar advertencias sobre los datos
    {
        //Sobrecarga del método onClick, el cual manda llamar el método Salvar()
        @Override
        public void onClick(View view) {
            if((!edtActividad.getText().toString().equals(""))&&(!edtActividad.getText().toString().equals("Ingresa el nombre de la actividad")))
            {
                if((rbtnLunes.isChecked())||(rbtnMartes.isChecked())||(rbtnMiercoles.isChecked())||(rbtnJueves.isChecked())||(rbtnViernes.isChecked())||(rbtnSabado.isChecked())||(rbtnDomingo.isChecked()))
                {
                    if((!actvHoraInicio.getText().toString().equals("Inicio")) && (!actvHoraFin.getText().toString().equals("Fin")))
                    {
                        Toast.makeText(getContext(),"Guardando actividad",Toast.LENGTH_SHORT).show();
                        Salvar();
                    }
                    else
                    {
                        Toast.makeText(getContext(),"Ingresa hora de inicio y fin",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Selecciona los días",Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getContext(),"Agrega el nombre",Toast.LENGTH_SHORT).show();
            }
        }
    };
    //Método Salvar. Directorios de almacenamiento interno
    private void Salvar()
    {
        FileOutputStream fos = null; // Archivo para escritura de la actividad
        try {
            fos = getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);
            String dias = "";
            if(rbtnLunes.isChecked())
            {
                dias = dias + "Lun";
            }
            if(rbtnMartes.isChecked())
            {
                if(dias.equals("")){
                    dias = "Mar";
                }
                else
                {
                    dias = dias + ", Mar";
                }
            }
            if(rbtnMiercoles.isChecked())
            {
                if(dias.equals("")){
                    dias = "Mie";
                }
                else
                {
                    dias = dias + ", Mie";
                }
            }
            if(rbtnJueves.isChecked())
            {
                if(dias.equals("")){
                    dias = "Jue";
                }
                else
                {
                    dias = dias + ", Jue";
                }
            }
            if(rbtnViernes.isChecked())
            {
                if(dias.equals("")){
                    dias = "Vie";
                }
                else
                {
                    dias = dias + ", Vie";
                }
            }
            if(rbtnSabado.isChecked())
            {
                if(dias.equals("")){
                    dias = "Sab";
                }
                else
                {
                    dias = dias + ", Sab";
                }
            }
            if(rbtnDomingo.isChecked())
            {
                if(dias == ""){
                    dias = "Dom";
                }
                else
                {
                    dias = dias + ", Dom";
                }
            }
            String texto = edtActividad.getText().toString()+"+"+dias+"+"+actvHoraInicio.getText().toString()+"+"+actvHoraFin.getText().toString()+"?";
            fos.write(texto.getBytes());
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