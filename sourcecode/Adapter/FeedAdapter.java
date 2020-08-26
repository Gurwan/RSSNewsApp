package studio.okaria.fluxrss.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.net.URI;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import studio.okaria.fluxrss.Interface.ItemClickListener;
import studio.okaria.fluxrss.Model.RSSObject;
import studio.okaria.fluxrss.R;

class FeedViewHolder extends RecyclerView.ViewHolder
    {

        public TextView txtTitle,txtPubDate,txtContent;
        private MediaPlayer mediaPlayer = null;


        public FeedViewHolder(View itemView){
            super(itemView);



            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            txtPubDate = (TextView)itemView.findViewById(R.id.txtPubDate);
            txtContent = (TextView)itemView.findViewById(R.id.txtContent);




        }




    }

    public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

        private RSSObject rssObject;
        private Context mContext;
        private LayoutInflater inflater;
        private URL url;


        public FeedAdapter(RSSObject rssObject, Context mContext) {
            this.rssObject = rssObject;
            this.mContext = mContext;
            inflater = LayoutInflater.from(mContext);

        }

        @Override
        public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.row,parent,false);
            return new FeedViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {


            holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
            holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
            holder.txtContent.setText(rssObject.getItems().get(position).getDescription());



        }


        @Override
        public int getItemCount() {
            return rssObject.items.size();
        }
    }

