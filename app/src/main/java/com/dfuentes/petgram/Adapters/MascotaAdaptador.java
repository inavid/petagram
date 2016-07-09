package com.dfuentes.petgram.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dfuentes.petgram.Pojo.ConstructorMascotas;
import com.dfuentes.petgram.Pojo.Mascotas;
import com.dfuentes.petgram.R;

import java.util.ArrayList;

/**
 * Created by inavid on 25/06/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascotas mascota = mascotas.get(position);

        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.nombre.setText(mascota.getNombre());
        holder.rate.setText(String.valueOf(mascota.getRate()) + " Likes");
        holder.rateImage.setImageResource(R.drawable.dog_bone_48);

        holder.rateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.rate.setText(constructorMascotas.obtenerLikesMascota(mascota) + " Likes");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView nombre;
        private TextView rate;
        private ImageButton rateImage;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            nombre = (TextView) itemView.findViewById(R.id.tvnombre);
            rate = (TextView) itemView.findViewById(R.id.tvrate);
            rateImage = (ImageButton) itemView.findViewById(R.id.ibLike);
        }

    }
}
