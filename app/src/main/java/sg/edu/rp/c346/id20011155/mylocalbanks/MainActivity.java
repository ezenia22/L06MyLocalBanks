package sg.edu.rp.c346.id20011155.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String wordClicked="";

    boolean togglefavDBS=false;
    boolean togglefavOCBC=false;
    boolean togglefavUOB=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbs);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main2, menu);

        if (v==dbs){
            wordClicked="DBS";
        }
        else if(v==ocbc){
            wordClicked="OCBC";
        }
        else if(v==uob){
            wordClicked="UOB";
        }
        menu.setHeaderTitle(wordClicked + " is selected");
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("DBS")){
            if (item.getItemId()==R.id.web) {
                String web1 = getString(R.string.link1);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((web1)));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==R.id.phone) {
                String phone1 = getString(R.string.phone1);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse((phone1)));
                startActivity(intent);
                return true;
            }  else if(item.getItemId()==R.id.togglefav) {
                if(!togglefavDBS){
                    togglefavDBS=true;
                    dbs.setTextColor(Color.RED);
                } else {
                    togglefavDBS=false;
                    dbs.setTextColor(Color.BLACK);
                }
            }
        } else if(wordClicked.equalsIgnoreCase("OCBC")){
            if (item.getItemId()==R.id.web) {
                String web2 = getString(R.string.link2);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((web2)));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==R.id.phone) {
                String phone2 = getString(R.string.phone2);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse((phone2)));
                startActivity(intent);
                return true;
            } else if(item.getItemId()==R.id.togglefav) {
                if(!togglefavOCBC){
                    togglefavOCBC=true;
                    ocbc.setTextColor(Color.RED);
                } else {
                    togglefavDBS=false;
                    ocbc.setTextColor(Color.BLACK);
                }
            }
        } else if(wordClicked.equalsIgnoreCase("UOB")){
            if (item.getItemId()==R.id.web) {
                String web3 = getString(R.string.link3);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse((web3)));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==R.id.phone) {
                String phone3 = getString(R.string.phone3);
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse((phone3)));
                startActivity(intent);
                return true;
            } else if(item.getItemId()==R.id.togglefav) {
                if(!togglefavUOB){
                    togglefavUOB=true;
                    uob.setTextColor(Color.RED);
                } else {
                    togglefavUOB=false;
                    uob.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}