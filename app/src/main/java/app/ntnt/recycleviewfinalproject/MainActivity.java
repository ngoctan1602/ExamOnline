package app.ntnt.recycleviewfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.adapter.SubjectAdapter;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SubjectAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question);
        recyclerView = findViewById(R.id.rcv_anwser);
        userAdapter = new SubjectAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        userAdapter.setData(getListUser(), new IClickItem() {
            @Override
            public void onClickItem() {
                goToTopic();
            }
        });
        recyclerView.setAdapter(userAdapter);
    }
    private List<Subject> getListUser()
    {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject(1,"Vật lý",10,20));
        subjectList.add(new Subject(1,"́Toán",10,20));
        subjectList.add(new Subject(1,"Ngữ Văn",10,20));
        return  subjectList;

    }
    private void goToTopic()
    {
        Intent intent = new Intent(MainActivity.this,TopicActivity.class);
        startActivity(intent);
    }


}