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
import studio.okaria.fluxrss.Adapter.FeedAdapter;
import studio.okaria.fluxrss.Common.HTTPDataHandler;
import studio.okaria.fluxrss.Model.RSSObject;

public class FluxLigue1 extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RSSObject rssObject;

    private final String RSS_link="http://www.footmercato.net/flux-rss";
    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?rss_url=";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluxligue1);
        int pleinEcran = (int) WindowManager.LayoutParams.FLAG_FULLSCREEN ; getWindow().setFlags(pleinEcran,pleinEcran);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Football");
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadRSS();




    }

    private void loadRSS() {
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(FluxLigue1.this);

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Attendez s'il vous plait...");
                mDialog.show();

            }

            @Override
            protected String doInBackground(String... params){
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s){
                mDialog.dismiss();
                rssObject = new Gson().fromJson(s,RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject,getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

        };

        StringBuilder url_get_data = new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());

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
