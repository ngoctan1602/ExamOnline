package app.ntnt.recycleviewfinalproject.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import app.ntnt.recycleviewfinalproject.IClickItem;
import app.ntnt.recycleviewfinalproject.R;
import app.ntnt.recycleviewfinalproject.adapter.SubjectAdapter;
import app.ntnt.recycleviewfinalproject.model.Question;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class MyButtomSheet extends BottomSheetDialogFragment {
    private List<Subject> subjectList;
    private IClickQuestion iClickQuestion;
    private SubjectAdapter subjectAdapter;

    public MyButtomSheet(List<Subject> questionList, IClickQuestion iClickQuestion) {
        this.subjectList = questionList;
        this.iClickQuestion = iClickQuestion;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog myButtomSheet= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_main,null);
        myButtomSheet.setContentView(view);
        RecyclerView recyclerView= view.findViewById(R.id.rcv_subject);
        subjectAdapter = new SubjectAdapter(getContext());
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        subjectAdapter.setData(subjectList, new IClickItem() {
            @Override
            public void onClickItem() {

            }
        });
        recyclerView.setAdapter(subjectAdapter);
        return myButtomSheet;
    }


}
