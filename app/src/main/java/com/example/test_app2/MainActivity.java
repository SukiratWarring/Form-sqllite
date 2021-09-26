package com.example.test_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    dataBase obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        obj= new dataBase(getApplicationContext());
        Button Save =findViewById(R.id.SAVEbutton);
        Save.setOnClickListener(this);
        Button Refresh=findViewById(R.id.REFRESHbuttonbutton);
        Refresh.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.SAVEbutton){
            EditText Name=findViewById(R.id.Nameedittext);
            EditText ID = findViewById(R.id.IDedittext);
            EditText ADD = findViewById(R.id.Addressedittext);
            EditText SAL = findViewById(R.id.Salaryedittext);

            String name=Name.getText().toString();
            int id=Integer.parseInt(ID.getText().toString());
            int salary=Integer.parseInt(SAL.getText().toString());
            String address=ADD.getText().toString();
            obj.saveemp(id,name,address,salary);
            Name.setText("");
            ID.setText("");
            ADD.setText("");
            SAL.setText("");

        }
        else{
            int count = obj.getcount();
            TextView textView=findViewById(R.id.showedittext);
            textView.setText(count+"");
        }

    }
}