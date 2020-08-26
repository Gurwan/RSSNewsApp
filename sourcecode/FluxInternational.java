package studio.okaria.fluxrss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import studio.okaria.fluxrss.Adapter.NewsAdapter;
import studio.okaria.fluxrss.Common.HTTPDataHandler;
import studio.okaria.fluxrss.Model.RSSObject;

public class FluxInternational extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RSSObject rssObject;

    private final String RSS_link = "https://www.lemonde.fr/international/rss_full.xml";
    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?rss_url=";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluxinternational);
        int pleinEcran = WindowManager.LayoutParams.FLAG_FULLSCREEN ; getWindow().setFlags(pleinEcran,pleinEcran);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("International");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadRSS();
    }

    private void loadRSS() {
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog progressDialog = new ProgressDialog(FluxInternational.this);

            @Override
            protected void onPreExecute() {
                progressDialog.setMessage("Attendez s'il vous plait...");
                progressDialog.show();

            }

            @Override
            protected String doInBackground(String... params){
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.getData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s){
                progressDialog.dismiss();
                rssObject = new Gson().fromJson(s,RSSObject.class);
                NewsAdapter adapter = new NewsAdapter(rssObject,getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

        };

        loadRSSAsync.execute(RSS_to_Json_API + RSS_link);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.menu_refresh)
            loadRSS();

        if (item.getItemId() == R.id.menu_return)
            loadMain();
        return true;
    }

    private void loadMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}