package app.ntnt.recycleviewfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.ntnt.recycleviewfinalproject.model.Question;


public class TestActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    Button button;
    List<String> arr = new ArrayList<String>();

    List<Question> questionList;

    Boolean aBoolean=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        Map<Integer, String> data = new HashMap<Integer, String>();
        data.put(1,"Bạn có đói không?");
        data.put(2,"Chắc chắn là có!");
        data.put(3,"Hì hì");
        data.put(4,"Bạn có đói không?");
        data.put(5,"Hì hì");
        data.put(6,"Bạn có đói không?");
        data.put(7,"Hì hì");
        data.put(8,"Bạn có đói không?");
        data.put(9,"Bạn có đói không?");
        data.put(10,"Chắc chắn là có!");
        data.put(11,"Hì hì");
        data.put(12,"Bạn có đói không?");
        data.put(13,"Hì hì");
        data.put(14,"Bạn có đói không?");
        data.put(15,"Hì hì");
        data.put(16,"Bạn có đói không?");



        for(Map.Entry entry:data.entrySet()){
             arr.add((String) entry.getValue());
        }


        listView = findViewById(R.id.lst_item);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arr);
        listView.setAdapter(adapter);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestionDialog(Gravity.CENTER);
//                String itemSelected = "";
//                for( int i=0;i<listView.getCount();i++) {
//                    if (listView.isItemChecked(i))
//                        //itemSelected += listView.getItemAtPosition(i) + "\n";
//                    {
//                        int tmp = getKey(data,(String)listView.getItemAtPosition(i));
//                        itemSelected+= String.valueOf(tmp)+"\n";
//                    }
//                }
//                button.setText(itemSelected);
            }
        });

    }
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (K key: map.keySet())
        {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public void openQuestionDialog(int gravity)
    {
        final Dialog dialog = new Dialog (  this);
        dialog.requestWindowFeature (Window. FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_question_layout);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout (WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable (new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity= gravity;
        window.setAttributes (windowAttributes);
        if (Gravity.BOTTOM== gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable (false);
        }
        dialog.show();
    }
}