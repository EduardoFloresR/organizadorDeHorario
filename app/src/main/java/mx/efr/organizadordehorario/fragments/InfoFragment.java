package mx.efr.organizadordehorario.fragments;

//region Bilbiotecas y elementos
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
import mx.efr.organizadordehorario.recyclerview.AdaptadorBuscaClass;
//endregion

public class InfoFragment extends Fragment {

    //region Atributos
    private RecyclerView rcvBusqueda;
    private AdaptadorBuscaClass mAdapter;
    private FirebaseFirestore mFirestore;
    private String stBusca = "0508+3";
    //endregion

    //region Métodos
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance)
    {
        View v = inflater.inflate(R.layout.fragment_info,container,false); //Vinculando al archivo xml "fragment_info"
        rcvBusqueda = v.findViewById(R.id.rcvBusqueda); //Relacionando el 'RecyclerView' "rcvBbusqueda"
        Bundle lazo = this.getArguments(); //Declaración de variable local "lazo" de tipo Bundle
        stBusca = lazo.getString("stBusca");
        LinearLayoutManager llm = new LinearLayoutManager(getContext()); //Instancia de LinerLayoutManager
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvBusqueda.setLayoutManager(llm);

        mFirestore = FirebaseFirestore.getInstance(); //Abriendo conexión con la base de datos
        InicializarAdaptador(); //Se llama al método InicialziarAdaptador
        return v; //Se devuelve la vista a mostrar
    }

    //Método InicializarAdaptador
    private void InicializarAdaptador()
    {
        mAdapter = new AdaptadorBuscaClass(Consulta(),getContext());
        mAdapter.notifyDataSetChanged();
        rcvBusqueda.setAdapter(mAdapter);
    }

    //Método Consulta
    private FirestoreRecyclerOptions Consulta()
    {
        Query query = mFirestore.collection("Asignatura").whereEqualTo("claveGrupo",stBusca);
        FirestoreRecyclerOptions<AsignaturaClass> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<AsignaturaClass>()
                .setQuery(query,AsignaturaClass.class).build();
        return firestoreRecyclerOptions;
    }
    //Sobrecarga del método onStart
    @Override
    public void onStart()
    {
        super.onStart();
        mAdapter.startListening();
    }
    //endregion
}