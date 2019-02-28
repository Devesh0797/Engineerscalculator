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

public class BranchActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5;
    public static int TotalLecture;
    public static int a=0;
    private DatabaseReference rootref;
    private ProgressDialog progressDialog1;
    public static String branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        b1=(Button)findViewById(R.id.btn_it);
        b2=(Button)findViewById(R.id.btn_me);
        b3=(Button)findViewById(R.id.btn_ec);
        b4=(Button)findViewById(R.id.btn_cs);
        b5=(Button)findViewById(R.id.btn_en);


        progressDialog1= new ProgressDialog(BranchActivity.this);
        progressDialog1.setMessage("Loading");

        progressDialog1.setCanceledOnTouchOutside(false);
        progressDialog1.setCancelable(false);

        rootref= FirebaseDatabase.getInstance().getReference();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child("IT").child("A").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                         TotalLecture = Integer.parseInt(value);
                         a=1;
                         progressDialog1.dismiss();
                        startActivity(new Intent(BranchActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(BranchActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });




            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child("ME").child("B").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        TotalLecture = Integer.parseInt(value);
                        a=2;
                        progressDialog1.dismiss();
                        startActivity(new Intent(BranchActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(BranchActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child("EC").child("C").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        TotalLecture = Integer.parseInt(value);
                        a=3;
                        progressDialog1.dismiss();
                        startActivity(new Intent(BranchActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(BranchActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog1.show();

                rootref.child("CS").child("B").child("value").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        TotalLecture = Integer.parseInt(value);
                        a=4;
                        progressDialog1.dismiss();
                        startActivity(new Intent(BranchActivity.this,MainActivity.class));
                        finish();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(BranchActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                branch="EN";
                a=5;
                startActivity(new Intent(BranchActivity.this,sectionActivity.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        finish();
    }

}
