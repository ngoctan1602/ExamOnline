package app.ntnt.recycleviewfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.adapter.SubjectAdapter;
import app.ntnt.recycleviewfinalproject.adapter.TopicAdapter;
import app.ntnt.recycleviewfinalproject.model.Subject;
import app.ntnt.recycleviewfinalproject.model.Topic;
import app.ntnt.recycleviewfinalproject.service.TestAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        recyclerView = findViewById(R.id.rcv_topic);
        topicAdapter = new TopicAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        //topicAdapter.setData(getListTopic());
        callAPI();
        recyclerView.setAdapter(topicAdapter);
    }
    private List<Topic> getListTopic()
    {
        List<Topic> topicList = new ArrayList<>();
//        topicList.add(new Topic(1,"Sóng cơ",10,20));
//        topicList.add(new Topic(1,"́Sóng điện từ",10,20));
//        topicList.add(new Topic(1,"Quang học",10,20));
        return  topicList;

    }

    private void callAPI()
    {
        TestAPI.testApi.getListTopic(1).enqueue(new Callback<List<Topic>>() {
            @Override
            public void onResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                List<Topic> topicList = new ArrayList<>();
                topicList = response.body();
                topicAdapter.setData(topicList);
            }

            @Override
            public void onFailure(Call<List<Topic>> call, Throwable t) {

            }
        });
    }


}