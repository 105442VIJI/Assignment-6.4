package com.example.acadgild.assignment64;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

ListView listView;


    String[] names = {"viji", "vivek", "Usha", "Syeda", "manoj", "shivranjini", "Utkarsh"};
    String[] numbers = {"8971533344", "8197616611", "9412822845", "8971533344", "8197616611",
            "9412822845", "8971533344" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // List view

        listView = (ListView)findViewById(R.id.listview);

        CAdapter adapter = new CAdapter(this,names,numbers);
        listView.setAdapter(adapter);

        // context menu

        registerForContextMenu(listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //*************************Context menu*********************************************

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Send SMS");
    }

    //************************Context items selected**********************************


    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo contextMenuInfo= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        String phonenumber = numbers[contextMenuInfo.position];


        if(item.getTitle()=="Call")
        {
            Intent a = new Intent(Intent.ACTION_DIAL);
            a.setData(Uri.parse("tel:" +phonenumber ));
            startActivity(a);
            return true;
        }

        else if(item.getTitle()=="Send SMS")
        {
            Intent b = new Intent(Intent.ACTION_INSERT_OR_EDIT);
            b.setType("vnd.android-dir/mms-sms");
            b.putExtra("address",phonenumber);
            b.putExtra("sms_body", "Hi Dear");
            startActivity(Intent.createChooser(b, "Please select an app"));
            return true;

        }else{
            return false;
        }

    }
}

