package com.example.testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecommendD extends AppCompatActivity {

    CheckBox ap,cp,bp;
    CheckBox fever,nausea,cough;
    CheckBox dir,burn,vom;
    CheckBox cons,dur,pain;
    CheckBox bu,dut,uri;

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String j;
    String k;
    String v1,v2,v3,v4,v5;
    String v6,v7,v8,v9,v10;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rf = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_d);

        ap =  findViewById(R.id.ap);
        cp =  findViewById(R.id.cp);
        bp =  findViewById(R.id.bp);
        fever =  findViewById(R.id.fever);
        nausea =  findViewById(R.id.nausea);
        cough =  findViewById(R.id.cough);
        dir =  findViewById(R.id.diarhea);
        burn =  findViewById(R.id.burn);
        vom =  findViewById(R.id.vomiting);
        cons =  findViewById(R.id.constipation);
        dur =  findViewById(R.id.duratran);
        pain =  findViewById(R.id.pa);
        bu =  findViewById(R.id.burning);
        dut =  findViewById(R.id.dur);
        uri =  findViewById(R.id.urinary);


    }

    @Override
    protected void onStart() {
        super.onStart();


        dr1();
        dr2();
        dr3();
        dr4();
        dr5();
        dr6();
        dr7();
        dr8();
        dr9();
        dr10();
    }

    public void findPDr(View view) {


        if(ap.isChecked() && cp.isChecked() && bp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                         gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(ap.isChecked()&& cp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(a+"\n"+v1+"\n"+a1)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })

                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }


        else if(ap.isChecked()&& bp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(b+"\n"+v2+"\n"+a2)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(cp.isChecked()&& bp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(ap.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(a+"\n"+v1+"\n"+a1)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(bp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(c+"\n"+v3+"\n"+a3)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(cp.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(b+"\n"+v2+"\n"+a2)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }




    public void findFDr(View view) {

        if(fever.isChecked() && nausea.isChecked() && cough.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e+"\n"+v5+"\n"+a5)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(fever.isChecked()&& nausea.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(a+"\n"+v1+"\n"+a1)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }


        else if(fever.isChecked()&& cough.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(nausea.isChecked()&& cough.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(f+"\n"+v6+"\n"+a6)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(fever.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(nausea.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e+"\n"+v5+"\n"+a5)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(cough.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(f+"\n"+v6+"\n"+a6)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    public void findDDr(View view) {

        if(dir.isChecked() && burn.isChecked() && vom.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(dir.isChecked()&& burn.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(h+"\n"+v8+"\n"+a8)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }


        else if(dir.isChecked()&& vom.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(j+"\n"+v9+"\n"+a9)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(burn.isChecked()&& vom.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(f+"\n"+v6+"\n"+a6)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(dir.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(g+"\n"+v7+"\n"+a7)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(burn.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(h+"\n"+v8+"\n"+a8)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(vom.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(k+"\n"+v10+"\n"+a10)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    public void findCDr(View view) {

        if(cons.isChecked() && dur.isChecked() && pain.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(a+"\n"+v1+"\n"+a1)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(cons.isChecked()&& dur.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(j+"\n"+v9+"\n"+a9)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }


        else if(cons.isChecked()&& pain.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(b+"\n"+v2+"\n"+a2)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(dur.isChecked()&& pain.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(c+"\n"+v3+"\n"+a3)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(cons.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(h+"\n"+v8+"\n"+a8)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(dur.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(j+"\n"+v9+"\n"+a9)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(pain.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(k+"\n"+v10+"\n"+a10)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    public void findBDr(View view) {

        if(bu.isChecked() && dut.isChecked() && uri.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if(bu.isChecked()&& dut.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e+"\n"+v5+"\n"+a5)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }


        else if(bu.isChecked()&& uri.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(g+"\n"+v7+"\n"+a7)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(dut.isChecked()&& uri.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(d+"\n"+v4+"\n"+a4)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(bu.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(e+"\n"+v5+"\n"+a5)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }

        else if(dut.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(j+"\n"+v9+"\n"+a9)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            gps();
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(uri.isChecked())
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(j+"\n"+v9+"\n"+a9)
                    .setCancelable(false)
                    .setPositiveButton("Open in Map", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    public void dr1()
    {


        rf = db.getReference("Users").child("12iLY7x8VsbqxyScU8wkOpaGLDl2");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                a = snapshot.child("username").getValue().toString();

                v1 = snapshot.child("special").getValue().toString();

                a1 = snapshot.child("clinic").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void dr2()
    {


        rf = db.getReference("Users").child("2K8DT9GueSX4yUcYF0rUGTqDqAp1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                b = snapshot.child("username").getValue().toString();

                v2 = snapshot.child("special").getValue().toString();

                a2 = snapshot.child("clinic").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr3()
    {


        rf = db.getReference("Users").child("9b9eY384SZaDAn9w43K74rXRxBF3");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                c = snapshot.child("username").getValue().toString();

                v3 = snapshot.child("special").getValue().toString();

                a3 = snapshot.child("clinic").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr4()
    {


        rf = db.getReference("Users").child("EAUVowCPgxWQrtykt6fHKqMkXGr1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                d = snapshot.child("username").getValue().toString();

                v4 = snapshot.child("special").getValue().toString();

                a4 = snapshot.child("clinic").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr5()
    {


        rf = db.getReference("Users").child("NiVSIhZvauWYOl0mFdyt6XYDeZv1");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                e = snapshot.child("username").getValue().toString();

                v5 = snapshot.child("special").getValue().toString();

                a5 = snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr6()
    {


        rf = db.getReference("Users").child("OieszzqoL6Ufdhgcb4pqNvYPH0c2");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                f = snapshot.child("username").getValue().toString();

                v6 = snapshot.child("special").getValue().toString();

                a6 = snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr7()
    {


        rf = db.getReference("Users").child("PTzZ9WKXx5doNxKVhqgUlicxd6H3");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                g = snapshot.child("username").getValue().toString();

                v7 = snapshot.child("special").getValue().toString();

                a7 = snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr8()
    {


        rf = db.getReference("Users").child("Uuk6XYJPg7eZHlebT940U81NSeX2");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                h = snapshot.child("username").getValue().toString();

                v8 = snapshot.child("special").getValue().toString();

                a8= snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr9()
    {


        rf = db.getReference("Users").child("esQkFN9opKci11B0iwLfNFgEEq52");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                j = snapshot.child("username").getValue().toString();

                v9 = snapshot.child("special").getValue().toString();

                a9 = snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void dr10()
    {


        rf = db.getReference("Users").child("ephu2KlJBEfS8wdydnberYCNLpG2");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                k = snapshot.child("username").getValue().toString();

                v10 = snapshot.child("special").getValue().toString();

                a10 = snapshot.child("clinic").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    void gps()
    {

        String strUri = "http://maps.google.com/maps?q=loc:" + 33.9508592 + "," + 71.4323065 + " ()";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

}