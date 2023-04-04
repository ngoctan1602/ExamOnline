package app.ntnt.recycleviewfinalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.model.Question;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class ViewPagerAdapter extends FragmentStateAdapter {
    List<List<Subject>> subjectList;
    List<Question> questionList;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,List<Question> questionList) {
        super(fragmentActivity);
        this.questionList=questionList;
    }
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,List<Question> questionList,List<List<Subject>> subjectList) {
        super(fragmentActivity);
        this.questionList=questionList;
        this.subjectList =subjectList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(questionList!=null)
        {
            Question question = questionList.get(position);
            List<Subject> subjects = subjectList.get(position);
            QuestionFragment questionFragment= new QuestionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("question_object",question);
            bundle.putSerializable("subjects_object", (Serializable) subjects);
            questionFragment.setArguments(bundle);
            return questionFragment;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if(questionList!=null)
            return questionList.size();
        return 0;
    }
}
