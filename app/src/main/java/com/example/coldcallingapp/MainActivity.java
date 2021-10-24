package com.example.coldcallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> picked = new ArrayList<>();
    private ArrayList<Integer> count = new ArrayList<>();
    private ArrayList<String> unpicked = new ArrayList<>();
    private ArrayList<Long> TimeArray = new ArrayList<>();
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cl_button = findViewById(R.id.cl_button);
        cl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalledLog();
            }
        });

        Button ucl_button = findViewById(R.id.ucl_button);
        ucl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUncalledLog();
            }
        });

        //Date Time Code
        TextView textView;
        textView = findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM/dd/yyyy   hh:mm a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);


        //TimeStuff
        // 2nd time - 1st time <= 2,400,000
        // counter = 2 in call log
        // get random -> name of student -> if picked.contains(name)...go through picked arraylist and find index of name...check count at index value
        // if count(index) == && time diff > 40
        // picked[] -> random -> name -> if picked(contains) then count + 1 -> else add name to pick and then count = 1

        //Get Random Image
        ImageView imageView;
        Button r_button;
        Random r;
        Integer[] images = {
                R.drawable.aamir_ali,
                R.drawable.adrian_yan,
                R.drawable.alex_aney,
                R.drawable.bipra_dey,
                R.drawable.darren_dong,
                R.drawable.dennis_wang,
                R.drawable.dhruv_amin,
                R.drawable.dultsin,
                R.drawable.eden_kogan,
                R.drawable.eli_bui,
                R.drawable.elie_belkin,
                R.drawable.evelyn_paskhaver,
                R.drawable.fardin_iqbal,
                R.drawable.jerry_he,
                R.drawable.kenny_cao,
                R.drawable.marc_rosenberg,
                R.drawable.matthew_chen,
                R.drawable.michael,
                R.drawable.ming_lin,
                R.drawable.mohammed_ihtisham,
                R.drawable.noam,
                R.drawable.ralf_pacia,
                R.drawable.samuel_iskhakov,
                R.drawable.sean,
                R.drawable.sebastian_marinescu,
                R.drawable.selina_li,
                R.drawable.shuyue_chen,
                R.drawable.tanushri_sundaram,
                R.drawable.tejas_ravi,
                R.drawable.vasu,
                R.drawable.xinrui_ge,
                R.drawable.zhian_maysoon
        };
        ArrayList <String> names = new ArrayList<>();
        names.add("Aamir Ali");
        names.add("Adrian Yan");
        names.add("Alex Aney");
        names.add("Bipra Dey");
        names.add("Darren Dong");
        names.add("Dennis Wang");
        names.add("Dhruv Amin");
        names.add("Daniel Dultsin");
        names.add("Eden Kogan");
        names.add("Eli Bui");
        names.add("Elie Belkin");
        names.add("Evelyn Paskhaver");
        names.add("Fardin Iqbal");
        names.add("Jerry He");
        names.add("Kenny Cao");
        names.add("Marc Rosenberg");
        names.add("Matthew Chen");
        names.add("Michael Wu");
        names.add("Ming Lin");
        names.add("Mohammed Ihtisham");
        names.add("Noam Canter");
        names.add("Ralf Pacia");
        names.add("Samuel Iskhakov");
        names.add("Sean Kerrigan");
        names.add("Sebastian Marinescu");
        names.add("Selina Li");
        names.add("Shuyue Chen");
        names.add("Tanushri Sundaram");
        names.add("Tejas Ravi");
        names.add("Vasu Patel");
        names.add("Xinrui Ge");
        names.add("Zhian Maysoon");

        for (int i = 0; i < names.size(); i++) {
            unpicked.add(names.get(i));
        }
        imageView = findViewById(R.id.imageView);
        r = new Random();
        r_button = findViewById(R.id.r_button);
        TextView student_name = findViewById(R.id.name);
        r_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //shows the random image
                int pickedImage = r.nextInt(images.length);
                time = System.currentTimeMillis();
                if (picked.contains(names.get(pickedImage))) {
                    int index = picked.indexOf(names.get(pickedImage));
                    while((count.get(index) == 2 && (time - TimeArray.get(index)) <= 2400000)) {
                        pickedImage = r.nextInt(images.length);
                        if (picked.contains(names.get(pickedImage))) {
                            index = picked.indexOf(names.get(pickedImage));
                        }
                    }
                    count.set(picked.indexOf(names.get(pickedImage)), count.get(picked.indexOf(names.get(pickedImage))) + 1);
                }
                else {
                    count.add(1);
                    TimeArray.add(time);
                    picked.add(names.get(pickedImage));
                }
                if (unpicked.contains(names.get(pickedImage))) {
                    unpicked.remove(unpicked.indexOf(names.get(pickedImage)));
                }
                imageView.setImageResource(images[pickedImage]);
                student_name.setText(names.get(pickedImage));
            }
        });

    }
    public void openCalledLog() {
        Intent i = new Intent(this, CalledLog.class);
        i.putExtra("key",picked);
        i.putExtra("num",count);
        startActivity(i);
    }
    public void openUncalledLog() {
        Intent i = new Intent(this, UncalledLog.class);
        i.putExtra("key", unpicked);
        startActivity(i);
    }

}