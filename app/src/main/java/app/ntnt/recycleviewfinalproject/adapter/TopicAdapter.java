package app.ntnt.recycleviewfinalproject.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import app.ntnt.recycleviewfinalproject.R;
import app.ntnt.recycleviewfinalproject.model.Subject;
import app.ntnt.recycleviewfinalproject.model.Topic;

public class TopicAdapter extends  Adapter<TopicAdapter.TopicViewHolder> {
    private Context context;
    List<Topic> topicList;
    //private IClickItem iClickItem;

    public TopicAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Topic> topicList)//,IClickItem iClickItem)
    {
        //this.iClickItem=iClickItem;
        this.topicList = topicList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic,parent,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topicList.get(position);
        if(topic ==null)
        {
            return;
        }
//        holder.txtName.setText(topic.getName());
//        holder.txtSumTest.setText(String.valueOf(topic.getSumTest()));
//        holder.txtSumQuestion.setText(String.valueOf(topic.getSumQuestion()));
        holder.txtName.setText(topic.getBody());
        holder.txtSumTest.setText(String.valueOf(topic.getId()));
        holder.txtSumQuestion.setText(topic.getTitle());
    }



    @Override
    public int getItemCount() {
        if(topicList!=null)
            return topicList.size();
        return 0;
    }

    public class TopicViewHolder extends ViewHolder {

        private TextView txtName;
        private TextView txtSumTest;
        private TextView txtSumQuestion;


        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_topic);
            txtSumTest = itemView.findViewById(R.id.txt_sumTest_topic);
            txtSumQuestion = itemView.findViewById(R.id.txt_sumQuestion_topic);


        }
    }
}
