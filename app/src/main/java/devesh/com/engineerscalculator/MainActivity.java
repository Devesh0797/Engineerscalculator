package devesh.com.engineerscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2,e3;
    private TextView t1;
    private Button b1;
    public static int a,d,g,Absent;
    public static String Lecture1,Percent1,present1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.et_present);
        e2=(EditText)findViewById(R.id.et_lecture);
        e3=(EditText)findViewById(R.id.et_percent);

        t1=(TextView)findViewById(R.id.tv_dept);

        b1=(Button)findViewById(R.id.btn_cal);

        if(BranchActivity.a==1){
            t1.setText("Information Technology");
        }
        else if(BranchActivity.a==2){
            t1.setText("Mechanical");
        }
        else if(BranchActivity.a==3){
            t1.setText("Electronics");
        }
        else if(BranchActivity.a==4){
            t1.setText("Computer Science");
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                present1 = e1.getText().toString();
                Lecture1 = e2.getText().toString();
                Percent1= e3.getText().toString();
                if(TextUtils.isEmpty(present1)){
                    Toast.makeText(MainActivity.this, "Enter the no. of Lectures Attended", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(Lecture1)){
                    Toast.makeText(MainActivity.this, "Enter the no. of Lectures held", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(Percent1)){
                    Toast.makeText(MainActivity.this, "Enter the percentage you Want to maintain", Toast.LENGTH_SHORT).show();
                }
                else if(Percent1.length()>3){
                    Toast.makeText(MainActivity.this, "Enter correct Data", Toast.LENGTH_SHORT).show();
                }
                else{
                    int present = Integer.parseInt(present1);
                    int Lecture = Integer.parseInt(Lecture1);
                    int percent= Integer.parseInt(Percent1);

                     Absent = Lecture - present;
                    float y1 = (float)percent/100;

                    y1=y1*BranchActivity.TotalLecture;
                    int y = (int)y1;

                    int z = BranchActivity.TotalLecture - y;
                    a= z - Absent;
                    int b = present + a;
                    int c = BranchActivity.TotalLecture - b;
                    d= c - Absent;
                    float e = (float) present/Lecture;
                    e=e*100;
                    float f = e - (int)e;
                    if(f>=0.5){
                         g = (int)e +1;
                    }
                    if(f<0.5){
                         g = (int)e;
                    }

                    if(percent>100){
                        Toast.makeText(MainActivity.this, "Enter the correct Percentage", Toast.LENGTH_SHORT).show();
                    }
                    else if(Absent<0){
                        Toast.makeText(MainActivity.this, "Enter the Data in correct way..", Toast.LENGTH_SHORT).show();
                    }
                    else if(Lecture>BranchActivity.TotalLecture){
                        Toast.makeText(MainActivity.this, "Working on update...", Toast.LENGTH_SHORT).show();
                    }
                    else if(a<0){
                        Toast.makeText(MainActivity.this, "Unable to achieve required Percentage..", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        startActivity(new Intent(MainActivity.this,ResultActivity.class));
                        finish();
                    }

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MainActivity.this,BranchActivity.class));
        finish();
    }
}
