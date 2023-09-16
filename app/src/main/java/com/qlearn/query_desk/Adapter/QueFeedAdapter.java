package com.qlearn.query_desk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.qlearn.query_desk.Model.Post;
import com.qlearn.query_desk.Model.QueFeedModel;
import com.qlearn.query_desk.QueAnswerActivity;
import com.qlearn.query_desk.R;
import com.qlearn.query_desk.User;
import com.qlearn.query_desk.databinding.WriteAnsRvBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QueFeedAdapter extends RecyclerView.Adapter<QueFeedAdapter.viewHolder>{

    ArrayList<Post> list;
    Context context;


    public QueFeedAdapter(ArrayList<Post> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.write_ans_rv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Post model = list.get(position);

        holder.binding.userQue.setText(model.getPostedQue());

        FirebaseDatabase.getInstance().getReference().child("Users")
                .child(model.getPostedBy()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                Picasso.get()
                        .load(user.getProfile())
                        .placeholder(R.drawable.img4)
                        .into(holder.binding.profileImage);
                holder.binding.userName.setText(user.getName());
                holder.binding.bio.setText(user.getOccupation());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        holder.profile.setImageResource(model.getProfile());
//        holder.userName.setText(model.getUserName());
//        holder.bio.setText(model.getBio());
//        holder.userQue.setText(model.getUserQue());

        holder.binding.Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QueAnswerActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


        WriteAnsRvBinding binding;



//        ImageView profile;
//        TextView userName, bio, userQue;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = WriteAnsRvBinding.bind(itemView);



//            profile = itemView.findViewById(R.id.profile_image);
//            userName = itemView.findViewById(R.id.userName);
//            bio = itemView.findViewById(R.id.bio);
//            userQue = itemView.findViewById(R.id.userQue);



        }
    }

}
