package app.ntnt.recycleviewfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.adapter.SubjectAdapter;
import app.ntnt.recycleviewfinalproject.model.Question;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class QuestionFragment extends Fragment {
    private TextView textView;
    private View view;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;

    public QuestionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_question, container, false);
        textView= view.findViewById(R.id.txt_ques);
        recyclerView = view.findViewById(R.id.rcv_anwser);


        subjectAdapter = new SubjectAdapter(getContext());
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        List<Subject> list = new ArrayList<Subject>();
        Bundle bundle = getArguments();
        if(bundle !=null)
        {
            Question question = (Question) bundle.getSerializable("question_object");
            list = (List<Subject>) bundle.getSerializable("subjects_object");
            if(question!=null)
            {
                textView.setText(question.getName());
            }
        }
        subjectAdapter.setData(list, new IClickItem() {
            @Override
            public void onClickItem() {

            }
        });
        recyclerView.setAdapter(subjectAdapter);
        return view;
    }
}