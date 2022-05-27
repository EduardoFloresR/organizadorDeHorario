package mx.efr.organizadordehorario.recyclerview;

//region Bibliotecas
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import mx.efr.organizadordehorario.AsignaturaClass;
import mx.efr.organizadordehorario.R;
//endregion

public class AdaptadorAsignaturasClass extends FirestoreRecyclerAdapter<AsignaturaClass,AdaptadorAsignaturasClass.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    //region Atributos
    private Context context;
    //endregion
    //region Constructor
    public AdaptadorAsignaturasClass(@NonNull FirestoreRecyclerOptions<AsignaturaClass> options, Context context)
    {
        super(options);
        this.context = context;
    }
    //endregion
    //region Métodos
    // Sobreescritura del método onBindViewHolder
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull AsignaturaClass asignatura) {
        holder.txtvCVNombre.setText(asignatura.getNombre()+"  ");
        holder.txtvCVProfesor.setText(asignatura.getProfesor()+"  ");
        holder.txtvCVClave.setText(asignatura.getClave()+"  ");
        holder.txtvCVGrupo.setText(asignatura.getGrupo()+"  ");
    }
    // Sobreescritura del método onCreateViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_asignatura,parent,false);
        return new ViewHolder(v);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtvCVNombre;
        TextView txtvCVProfesor;
        TextView txtvCVClave;
        TextView txtvCVGrupo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtvCVNombre = itemView.findViewById(R.id.txtvCVNombre);
            txtvCVProfesor = itemView.findViewById(R.id.txtvCVProfesor);
            txtvCVClave = itemView.findViewById(R.id.txtvCVClave);
            txtvCVGrupo = itemView.findViewById(R.id.txtvCVGrupo);
        }
    }
    //endregion
}
