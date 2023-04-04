package app.ntnt.recycleviewfinalproject.adapter;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static android.view.View.OnClickListener;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

import app.ntnt.recycleviewfinalproject.IClickItem;
import app.ntnt.recycleviewfinalproject.R;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class SubjectAdapter extends  Adapter<SubjectAdapter.SubjectViewHolder> {
    private Context context;
    List<Subject> subjectList;
    private int lastCheckPosition=-1;

    private IClickItem iClickItem;

    public SubjectAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Subject> subjectList,IClickItem iClickItem)
    {
        this.iClickItem=iClickItem;
        this.subjectList = subjectList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer,parent,false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        if(subject ==null)
        {
            return;
        }
        holder.textView.setText(subject.getName());
        holder.radioButton.setChecked(position==lastCheckPosition);
//        holder.txtName.setText(subject.getName());
//        holder.txtSumTest.setText(String.valueOf("Số bài thi: "+subject.getSumTest()));
//        holder.txtSumQuestion.setText(String.valueOf(subject.getSumQuestion()));
//        holder.imageView.setImageResource(R.drawable.pic6);
//
//        holder.relativeLayout.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iClickItem.onClickItem();
//            }
//        });
    }


    @Override
    public int getItemCount() {
        if(subjectList!=null)
            return subjectList.size();
        return 0;
    }

    public class SubjectViewHolder extends ViewHolder {

//        private TextView txtName;
//        private TextView txtSumTest;
//        private TextView txtSumQuestion;
//        private ImageView imageView;
//        private RelativeLayout relativeLayout;
         private RadioButton radioButton;
         private TextView textView;
        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

//            txtName = itemView.findViewById(R.id.txt_subject);
//            txtSumTest = itemView.findViewById(R.id.txt_sumTest);
//            txtSumQuestion = itemView.findViewById(R.id.txt_sumQuestion);
//            relativeLayout = itemView.findViewById(R.id.relative_layout);
//            imageView = itemView.findViewById(R.id.imageView);
            radioButton = itemView.findViewById(R.id.btn_anwser);
            textView = itemView.findViewById(R.id.txt_anwser);
            radioButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    int copy = lastCheckPosition;
                    lastCheckPosition= getAdapterPosition();
                    notifyItemChanged(copy);
                    notifyItemChanged(lastCheckPosition);
                    Toast.makeText(itemView.getContext(),"Đang chọn"+subjectList.get(lastCheckPosition).getName(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
