package devesh.com.engineerscalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sectionActivity extends AppCompatActivity {
    private Button b1,b2,b3;
    private DatabaseReference rootref;
    private ProgressDialog progressDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        b1=(Button)findViewById(R.id.btn_seca);
        b2=(Button)findViewById(R.id.btn_secc);

        progressDialog1= new ProgressDialog(sectionActivity.this);
        progressDialog1.setMessage("Loading");

        progressDialog1.setCanceledOnTouchOutside(false);
        progressDialog1.setCancelable(false);

        rootref= FirebaseDatabase.getInstance().getReference();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child(BranchActivity.branch).child("A").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        BranchActivity.TotalLecture = Integer.parseInt(value);
                        progressDialog1.dismiss();
                        startActivity(new Intent(sectionActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(sectionActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child(BranchActivity.branch).child("C").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        BranchActivity.TotalLecture = Integer.parseInt(value);
                        progressDialog1.dismiss();
                        startActivity(new Intent(sectionActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(sectionActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(sectionActivity.this,BranchActivity.class));
        finish();
    }
}
