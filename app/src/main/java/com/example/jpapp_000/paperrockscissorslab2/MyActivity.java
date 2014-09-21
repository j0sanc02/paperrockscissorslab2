package com.example.jpapp_000.paperrockscissorslab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ImageView rockButton = (ImageView)findViewById(R.id.imageRock);
        rockButton.setOnClickListener((View.OnClickListener) this);



        ImageView paperButton = (ImageView)findViewById(R.id.imagePaper);
        paperButton.setOnClickListener((View.OnClickListener) this);
        ImageView scissorsButton = (ImageView)findViewById(R.id.imageScissor);
        paperButton.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onLongClick(View view) {

        if (view.getId()== R.id.imageRock) {
            showMessage(view, "You clicked rock");
        }
        else if (view.getId()==R.id.imagePaper){
                showMessage(view, "You click Paper");

            }
        else{
                showMessage(view, "You click Scissors");
            }


        return false;
    }

    Intent intent = new Intent (this, WinLoseActivity.class);
    intent.putExtra(RockpaperscissorsConstant, view.getId());
    startActivity(intent);

    private void showMessage(View view, String message) {
        Toast toast = Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
