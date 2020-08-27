package studio.okaria.fluxrss.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import studio.okaria.fluxrss.Model.RSSObject;
import studio.okaria.fluxrss.R;

/**
 * Manages the recycler part of the app in order to refresh the NewsViewHolder
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private RSSObject rssObj;
    private LayoutInflater inflater;

    public NewsAdapter(RSSObject rssObj, Context context) {
        this.rssObj = rssObj;
        inflater = LayoutInflater.from(context);
    }

    // create view of a news
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row,parent,false);
        NewsViewHolder ret = new NewsViewHolder(itemView);
        return ret;
    }

    // refresh the recyclerView with anothers news
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int i) {

        holder.txtTitle.setText(rssObj.getItems().get(i).getTitle());
        holder.txtPubDate.setText(rssObj.getItems().get(i).getPubDate());
        holder.txtContent.setText(rssObj.getItems().get(i).getDescription());
    }


    @Override
    public int getItemCount() {
        return rssObj.items.size();
    }
}
