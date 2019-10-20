package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        final MyDataAdapter adapter = new MyDataAdapter(DataSource.getInstance().getData());
        int numberOfColumns = getResources().getBoolean(R.bool.is_horizontal) ? 4 : 3;
        recyclerView.setLayoutManager(new GridLayoutManager(context, numberOfColumns));
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSource.addnext();
                adapter.notifyItemInserted(adapter.mData.size());
            }
        });


        return view;
    }


    class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder> {
        List<DataSource.MyData> mData;

        public MyDataAdapter(List<DataSource.MyData> data) {
            mData = data;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataSource.MyData data = mData.get(position);
            holder.mText.setText(data.mnumber);
            holder.mText.setTextColor(data.mcolor);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mText;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.textView);
            mText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().beginTransaction().
                            replace(R.id.fragment_container,  SecondFragment.newInstance((String) mText.getText(), mText.getCurrentTextColor()))
                            .addToBackStack(null)
                            .commit();


                }
            });


        }


    }
}
