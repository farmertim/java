package com.example.people;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_viewAll;
    EditText et_Name, et_Age;
    Switch sw_activeCustomer;
    ListView listView;
    ArrayAdapter arrayAdapter;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        et_Age = findViewById(R.id.et_Age);
        et_Name = findViewById(R.id.et_Name);
        sw_activeCustomer = findViewById(R.id.sw_activeCustomer);
        listView = findViewById(R.id.listView);
        dataBaseHelper=new DataBaseHelper(MainActivity.this);

        showCustomerListView(dataBaseHelper);
        btn_add.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;
            @Override
            public void onClick(View v) {
                try {
                    customerModel = new CustomerModel(-1, et_Name.getText().toString(), Integer.parseInt(et_Age.getText().toString()), sw_activeCustomer.isChecked());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    customerModel=new CustomerModel(-1,"Error",0,false);
                }
                DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
                boolean success=dataBaseHelper.addOne(customerModel);
                showCustomerListView(dataBaseHelper);
                //Toast.makeText(MainActivity.this, "success "+success, Toast.LENGTH_SHORT).show();
            }
        });
        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper=new DataBaseHelper(MainActivity.this);
                List<CustomerModel> everyOne=dataBaseHelper.showEvery();
                showCustomerListView(dataBaseHelper);
                arrayAdapter=new ArrayAdapter<CustomerModel>(MainActivity.this,android.R.layout.simple_list_item_1,everyOne);
                listView.setAdapter(arrayAdapter);
                //Toast.makeText(MainActivity.this, everyOne.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel customerModel= (CustomerModel) parent.getItemAtPosition(position);
                dataBaseHelper.deleteOne(customerModel);
                showCustomerListView(dataBaseHelper);
                Toast.makeText(MainActivity.this,"delete "+customerModel.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showCustomerListView(DataBaseHelper dataBaseHelper2) {
        arrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper2.showEvery());
        listView.setAdapter(arrayAdapter);
    }
}