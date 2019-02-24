package devesh.com.engineerscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView t1,t2;
    private ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1=(TextView)findViewById(R.id.tv_result);
        t2=(TextView)findViewById(R.id.tv_percent);
        p1=(ProgressBar)findViewById(R.id.pro_reult);

        if(MainActivity.d<0){
            p1.setProgress(MainActivity.g);
            t2.setText(MainActivity.g+"%");

            t1.setText("Number of lectures you can bunk :- " + MainActivity.a +"\n"+ "No. of lectures You have to attend:- 0" );
        }
        else {
            p1.setProgress(MainActivity.g);
            t2.setText(MainActivity.g+"%");
            int n=MainActivity.a-5;
            int m= MainActivity.d+5;
            t1.setText("Number of lectures you can bunk : "+n+"-" + MainActivity.a + "\n" + "No. of lectures You have to attend: " + MainActivity.d+"-"+m);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }
}
