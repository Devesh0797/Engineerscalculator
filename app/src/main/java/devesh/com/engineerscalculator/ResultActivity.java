package devesh.com.engineerscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5;
    private ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1=(TextView)findViewById(R.id.tv_result);
        t2=(TextView)findViewById(R.id.tv_percent);
        t3=(TextView)findViewById(R.id.tv_pre);
        t4=(TextView) findViewById(R.id.tv_abs);
        t5=(TextView)findViewById(R.id.tv_lect);
        p1=(ProgressBar)findViewById(R.id.pro_reult);

        t3.setText(" Present-      " + MainActivity.present1 );
        t4.setText("  Absent-       "+MainActivity.Absent);
        t5.setText("Lectures-     "+MainActivity.Lecture1);

        if(MainActivity.d<0){
            p1.setProgress(MainActivity.g);
            t2.setText(MainActivity.g+"%");

            t1.setText("Number of lectures you can bunk :- " + MainActivity.a +"\n"+ "No. of lectures You have to attend:- 0" );
        }

        else {
            p1.setProgress(MainActivity.g);
            t2.setText(MainActivity.g + "%");
            int n = MainActivity.a - 5;
            int m = MainActivity.d + 5;
            if (n < 0) {
                t1.setText("Number of lectures you can bunk : " + MainActivity.a + "\n" + "No. of lectures You have to attend: " + MainActivity.d + "-" + m);
            }
            else if(MainActivity.d==0){
                t1.setText("Number of lectures you can bunk : 0"  + "\n" + "No. of lectures You have to attend: " + MainActivity.d);
            } else{
                t1.setText("Number of lectures you can bunk : " + n + "-" + MainActivity.a + "\n" + "No. of lectures You have to attend: " + MainActivity.d + "-" + m);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }
}
