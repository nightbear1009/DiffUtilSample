package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<User> mList = new ArrayList<>();
    private Button mButton;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList.addAll(getNormalList());
        setContentView(R.layout.activity_main);
        mButton  = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserCallBack(getChangePositionList(), mList));
                mList = getChangePositionList();
                diffResult.dispatchUpdatesTo(mAdapter);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserCallBack(getChangeDataList(), mList));
                mList = getChangeDataList();
                diffResult.dispatchUpdatesTo(mAdapter);
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.myadapter, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.textview)).setText(mList.get(position).getName());
                if(mList.get(position).getTel().contains("2")){
                    (holder.itemView.findViewById(R.id.img)).setVisibility(View.VISIBLE);
                }else {
                    (holder.itemView.findViewById(R.id.img)).setVisibility(View.GONE);
                }
            }

            @Override
            public int getItemCount() {
                return mList.size();
            }
        };
        recyclerView.setAdapter(mAdapter);
    }

    private List<User> getNormalList() {
        List<User> list = new ArrayList<>();
        list.add(new User("ted","0", "a"));
        list.add(new User("jack","1", "b"));
        list.add(new User("moris","2", "c"));
        list.add(new User("jam","3", "d"));
        list.add(new User("jame","4", "e"));
        list.add(new User("james","5", "f"));
        list.add(new User("cool","6", "g"));
        list.add(new User("cooss","7", "h"));
        list.add(new User("closs","8", "i"));
        list.add(new User("clossss","9", "j"));
        list.add(new User("clossaff","10", "k"));
        return list;
    }

    private List<User> getChangePositionList() {
        List<User> list = new ArrayList<>();
        list.add(new User("moris","2", "c"));
        list.add(new User("jam","3", "d"));
        list.add(new User("jame","4", "e"));
        list.add(new User("james","5", "f"));
        list.add(new User("cool","6", "g"));
        list.add(new User("cooss","7", "h"));
        list.add(new User("closs","8", "i"));
        list.add(new User("clossss","9", "j"));
        list.add(new User("clossaff","10", "k"));
        list.add(new User("ted","0", "a"));
        list.add(new User("jack","1", "b"));
        return list;
    }

    private List<User> getChangeDataList() {
        List<User> list = new ArrayList<>();
        list.add(new User("moris","2", "c"));
        list.add(new User("jam","3", "d"));
        list.add(new User("jame","4", "e"));
        list.add(new User("james","5", "f"));
        list.add(new User("cool","6", "g"));
        list.add(new User("cooss","7", "h"));
        list.add(new User("closs","8", "i"));
        list.add(new User("clossss","9", "j"));
        list.add(new User("clossaff","10", "k"));
        list.add(new User("ted","2222", "a"));
        list.add(new User("jack","111111", "b"));
        return list;
    }
}
