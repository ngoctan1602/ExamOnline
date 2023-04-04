package app.ntnt.recycleviewfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import app.ntnt.recycleviewfinalproject.adapter.SubjectAdapter;
import app.ntnt.recycleviewfinalproject.home.SliderAdapter;
import app.ntnt.recycleviewfinalproject.home.SliderItem;
import app.ntnt.recycleviewfinalproject.model.Subject;

public class HomeActivity extends Activity {
    ViewPager2 viewPager2;
    EditText editText;
    List<SliderItem> sliderItemList;
    List<Subject> subjectList;
    SliderAdapter sliderAdapter;
    private Timer timer;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;

    private RecyclerView recyclerView1;
    private SubjectAdapter subjectAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager2 = findViewById(R.id.view_rounded_image);
        sliderAdapter=new SliderAdapter(this);
        sliderAdapter.setData(getAllItem());
        viewPager2.setAdapter(sliderAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
        });
        autoSlider();

        editText = findViewById(R.id.search_view_home);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               editText.setText("Toán");
            }
        });

        recyclerView = findViewById(R.id.rcv_featured_exam);
        subjectAdapter = new SubjectAdapter(this);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,1, GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        subjectAdapter.setData(getListSubject(), new IClickItem() {
            @Override
            public void onClickItem() {

            }
        });
        recyclerView.setAdapter(subjectAdapter);


        recyclerView1 = findViewById(R.id.rcv_subject_home);
        subjectAdapter1 = new SubjectAdapter(this);
        GridLayoutManager gridLayoutManager1= new GridLayoutManager(this,3, GridLayoutManager.VERTICAL,false);
        recyclerView1.setLayoutManager(gridLayoutManager1);
        subjectAdapter1.setData(getListSubject(), new IClickItem() {
            @Override
            public void onClickItem() {

            }
        });
        recyclerView1.setAdapter(subjectAdapter1);
    }
    private List<SliderItem> getAllItem()
    {
        sliderItemList = new ArrayList<>();
        sliderItemList.add(new SliderItem(R.drawable.slider1));
        sliderItemList.add(new SliderItem(R.drawable.slider2));
        sliderItemList.add(new SliderItem(R.drawable.slider3));
        return sliderItemList;
    }


    private void autoSlider()
    {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager2.getCurrentItem();
                        int totalItem = sliderItemList.size()-1;
                        if(currentItem<totalItem)
                        {
                            currentItem++;
                            viewPager2.setCurrentItem(currentItem);

                        }
                        else {
                            viewPager2.setCurrentItem(0);
                        }
                    }
                });
            }
        },500, 2500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(timer!=null)
        {
            timer.cancel();
            timer=null;
        }
    }
    private List<Subject> getListSubject()
    {
        subjectList = new ArrayList<>();
        subjectList.add(new Subject(1,"Vật lý",10,20));
        subjectList.add(new Subject(1,"́Toán",10,20));
        subjectList.add(new Subject(1,"Ngữ Văn",10,20));
        subjectList.add(new Subject(1,"Vật lý",10,20));
        subjectList.add(new Subject(1,"́Toán",10,20));
        subjectList.add(new Subject(1,"Ngữ Văn",10,20));
        subjectList.add(new Subject(1,"Vật lý",10,20));
        subjectList.add(new Subject(1,"́Toán",10,20));
        subjectList.add(new Subject(1,"Ngữ Văn",10,20));
        return  subjectList;

    }
}
