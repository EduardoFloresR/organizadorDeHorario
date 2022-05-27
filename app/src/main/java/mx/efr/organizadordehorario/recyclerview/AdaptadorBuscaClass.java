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

public class AdaptadorBuscaClass extends FirestoreRecyclerAdapter<AsignaturaClass,AdaptadorBuscaClass.ViewHolder> {
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
    public AdaptadorBuscaClass(@NonNull FirestoreRecyclerOptions<AsignaturaClass> options, Context context)
    {
        super(options);
        this.context = context;
    }
    //endregion
    //region Métodos
    // Sobreescritura del método onBindViewHolder
    @Override
    protected void onBindViewHolder(@NonNull AdaptadorBuscaClass.ViewHolder holder, int position, @NonNull AsignaturaClass asignatura) {
        holder.txtvCVNombreInfo.setText(asignatura.getNombre()+"  ");
        holder.txtvCVProfesorInfo.setText(asignatura.getProfesor()+"  ");
        holder.txtvCVClaveInfo.setText(asignatura.getClave()+"  ");
        holder.txtvCVGrupoInfo.setText(asignatura.getGrupo()+"  ");
        holder.txtvCVDiasInfo.setText(asignatura.getDias()+"  ");
        holder.txtvCVHorarioInfoI.setText(asignatura.getHoraInicio()+"  ");
        holder.txtvCVHorarioInfoF.setText(asignatura.getHoraFinal()+"  ");
    }
    // Sobreescritura del método onCreateViewHolder
    @NonNull
    @Override
    public AdaptadorBuscaClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_infor,parent,false);
        return new ViewHolder(v);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtvCVNombreInfo;
        TextView txtvCVProfesorInfo;
        TextView txtvCVClaveInfo;
        TextView txtvCVGrupoInfo;
        TextView txtvCVDiasInfo;
        TextView txtvCVHorarioInfoI;
        TextView txtvCVHorarioInfoF;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtvCVNombreInfo = itemView.findViewById(R.id.txtvCVNombreInfo);
            txtvCVProfesorInfo = itemView.findViewById(R.id.txtvCVProfesorInfo);
            txtvCVClaveInfo = itemView.findViewById(R.id.txtvCVClaveInfo);
            txtvCVGrupoInfo = itemView.findViewById(R.id.txtvCVGrupoInfo);
            txtvCVDiasInfo = itemView.findViewById(R.id.txtvCVDiasInfo);
            txtvCVHorarioInfoI = itemView.findViewById(R.id.txtvCVHorarioInfoI);
            txtvCVHorarioInfoF = itemView.findViewById(R.id.txtvCVHorarioInfoF);
        }
    }
    //endregion
}
