package app.ntnt.recycleviewfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.bottomsheet.IClickQuestion;
import app.ntnt.recycleviewfinalproject.bottomsheet.MyButtomSheet;
import app.ntnt.recycleviewfinalproject.model.Question;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class LoadQuestionActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Button button;
    private List<Question> questionList;
    private TextView txtBack, txtNext, txtCurrent, txtSumQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_question);
        init();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,getQuestion(),getListUser());
        viewPager.setAdapter(viewPagerAdapter);
        txtCurrent.setText("1");
        txtSumQuestion.setText(String.valueOf(questionList.size()));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Question question = questionList.get(position);
                txtCurrent.setText(String.valueOf(question.getId()));
                if(position==0)
                {
                    txtBack.setVisibility(View.GONE);
                    txtNext.setVisibility(View.VISIBLE);

                }
                else if(position==questionList.size()-1)
                {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.GONE);

                }
                else
                {
                    txtBack.setVisibility(View.VISIBLE);
                    txtNext.setVisibility(View.VISIBLE);
                }
            }
        });
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a= 6;
                MyButtomSheet myButtomSheet = new MyButtomSheet(getListSubject(), new IClickQuestion() {
                    @Override
                    public int onClick(Question question) {
                        viewPager.setCurrentItem(a);
                        return a;
                    }
                });


                myButtomSheet.show(getSupportFragmentManager(),myButtomSheet.getTag());

            }

        });

    }
    private void init()
    {
        txtBack = findViewById(R.id.txt_back);
        txtCurrent = findViewById(R.id.txt_curent);
        txtNext= findViewById(R.id.txt_next);
        txtSumQuestion= findViewById(R.id.txt_sumquestion);
        viewPager = findViewById(R.id.view_pager);
        button = findViewById(R.id.btn_sheet);
    }
    private List<Question> getQuestion()
    {
        questionList = new ArrayList<>();
        for(int i=1;i<11;i++)
        {
            questionList.add(new Question(i,"Câu hỏi số "+i));
        }

        return questionList;
    }
    private List<List<Subject>> getListUser()
    {
        List<List<Subject>> list = new ArrayList<List<Subject>>();
        for( int i=1;i<11;i++)
        {
            List<Subject> subjectList = new ArrayList<>();
            subjectList.add(new Subject(1,"Vật lý",10,20));
            subjectList.add(new Subject(1,"́Toán",10,20));
            subjectList.add(new Subject(1,"Ngữ Văn",10,20));
            list.add(subjectList);
        }

        return  list;

    }

    private List<Subject> getListSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject(1,"Vật lý",10,20));
        subjectList.add(new Subject(1,"́Toán",10,20));
        subjectList.add(new Subject(1,"Ngữ Văn",10,20));
        return  subjectList;
    }

}