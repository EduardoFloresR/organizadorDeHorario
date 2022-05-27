package mx.efr.organizadordehorario.fragments;

//region Bibliotecas y elementos
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import mx.efr.organizadordehorario.AsignaturaClass;
import mx.efr.organizadordehorario.R;
import mx.efr.organizadordehorario.recyclerview.AdaptadorAsignaturasClass;
//endregion

public class AsignaturaFragment extends Fragment {

    //region Atributos
    private RecyclerView rcvAsignaturas;
    private AdaptadorAsignaturasClass mAdapter;
    private FirebaseFirestore mFirestore;
    //endregion

    //region Métodos
    //Sobrecarga del método onCreateView para la clase AsignaturaFragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        View v = inflater.inflate(R.layout.fragment_asignatura,container,false); //Vinculando al archivo xml "fragment_asignatura"
        rcvAsignaturas = v.findViewById(R.id.rcvAsignaturas); //Relacionando el 'RecyclerView' "rcvAsignaturas"
        mFirestore = FirebaseFirestore.getInstance(); //Abriendo conexión con la base de datos
        LinearLayoutManager llm = new LinearLayoutManager(getContext()); //Instancia de LinerLayoutManager
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvAsignaturas.setLayoutManager(llm);
        InicializarAdaptador(); //Se llama al método InicialziarAdaptador
        return v; //Se devuelve la vista a mostrar
    }

    private void InicializarAdaptador() //Método InicializarAdaptador
    {
        mAdapter = new AdaptadorAsignaturasClass(Consulta(),getContext());
        mAdapter.notifyDataSetChanged();
        rcvAsignaturas.setAdapter(mAdapter);
    }

    private FirestoreRecyclerOptions Consulta() //Método Consulta
    {
        Query query = mFirestore.collection("Asignatura").orderBy("clave");
        FirestoreRecyclerOptions<AsignaturaClass> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<AsignaturaClass>()
                .setQuery(query,AsignaturaClass.class).build();
        return firestoreRecyclerOptions;
    }

    @Override
    public void onStart() //Sobrecarga del método onStart
    {
        super.onStart();
        mAdapter.startListening();
    }
    //endregion
}