package com.yourbrandname.demosqlite_recyc.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yourbrandname.demosqlite_recyc.Activity.UpdateActivty;
import com.yourbrandname.demosqlite_recyc.Database.MyDbhelper;
import com.yourbrandname.demosqlite_recyc.Model.Datamodel;
import com.yourbrandname.demosqlite_recyc.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    ArrayList<Datamodel> arrayList;
    Context context;
    Activity activity;

    public DataAdapter(Activity activity, ArrayList<Datamodel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtname.setText(arrayList.get(position).getStrname());
        holder.txtphone.setText(arrayList.get(position).getStrphonen());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Update Activty for data update
                String up_name = arrayList.get(position).getStrname();
                String up_pno = arrayList.get(position).getStrphonen();
                String up_id = String.valueOf(arrayList.get(position).getId());

                Intent intent = new Intent(activity, UpdateActivty.class);
                intent.putExtra("KEY_ID", up_id);
                intent.putExtra("CLIENT_NAME", up_name);
                intent.putExtra("CLIENT_PHNO", up_pno);
                activity.startActivityForResult(intent, 100);
                activity.finish();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtname, txtphone;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txt_itname);
            txtphone = itemView.findViewById(R.id.txt_itphone);
            cardView = itemView.findViewById(R.id.cardview);


        }
    }

}
