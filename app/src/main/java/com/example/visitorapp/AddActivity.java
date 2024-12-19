package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1,b2;
    String getF,getL,getP,getW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        e1=(EditText) findViewById(R.id.fn);
        e2=(EditText) findViewById(R.id.ln);
        e3=(EditText) findViewById(R.id.pp);
        e4=(EditText) findViewById(R.id.wm);
        b1=(Button) findViewById(R.id.sb);
        b2=(Button) findViewById(R.id.bm);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getF=e1.getText().toString();
                getL=e2.getText().toString();
                getP=e3.getText().toString();
                getW=e4.getText().toString();
                
                if(getF.isEmpty()||getL.isEmpty()||getP.isEmpty()||getW.isEmpty()){
                    Toast.makeText(getApplicationContext(),)
                }
                else 
                    callApi();
                 


            }

            private void callApi() {
                String Apiurl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",getF);
                    data.put("lastname",getL);
                    data.put("purpose",getP);
                    data.put("whomToMeet",getW);
                } catch (JSONException e) {
                    throw new RuntimeException(e);

                }

                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        Apiurl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"successfully Added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                        queue.add(request);


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ob);
            }
        });



    }
}