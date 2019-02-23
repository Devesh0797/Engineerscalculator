package devesh.com.engineerscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1=(TextView)findViewById(R.id.tv_result);
        if(MainActivity.d<0){
            t1.setText("Number of lectures you can bunk :- "+ MainActivity.a +"\n"+ "No. of lectures You have to attend:- 0" );
        }
        else {
            t1.setText("Number of lectures you can bunk :- " + MainActivity.a + "\n" + "No. of lectures You have to attend:- " + MainActivity.d);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }
}
