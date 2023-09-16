package com.qlearn.query_desk.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.qlearn.query_desk.Adapter.QueFeedAdapter;
import com.qlearn.query_desk.Model.Post;
import com.qlearn.query_desk.Model.QueFeedModel;
import com.qlearn.query_desk.R;

import java.util.ArrayList;
import java.util.List;

public class WriteAnswersFragment extends Fragment {

    ShimmerRecyclerView write_ansRV;
    ArrayList<Post> Postlist;
    FirebaseDatabase database;
    FirebaseAuth auth;

    public WriteAnswersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write_answers, container, false);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        write_ansRV = view.findViewById(R.id.write_ansRV);
        Postlist = new ArrayList<>();

//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));
//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));
//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));
//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));
//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));
//        QueFeedlist.add(new QueFeedModel(R.drawable.profile1,"Aditya Shinde","App Developer","What are some best study tips?"));

        QueFeedAdapter QueFeedAdapter = new QueFeedAdapter(Postlist,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        write_ansRV.setLayoutManager(layoutManager);
        write_ansRV.setNestedScrollingEnabled(false);
        write_ansRV.setAdapter(QueFeedAdapter);

        database.getReference().child("posts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                QueFeedList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Post post = dataSnapshot.getValue(Post.class);
                    post.setPostId(dataSnapshot.getKey());
                    Postlist.add(post);
                }
                write_ansRV.setAdapter(QueFeedAdapter);
                write_ansRV.hideShimmerAdapter();
                QueFeedAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        return view;
}}