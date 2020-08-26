package studio.okaria.fluxrss.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import studio.okaria.fluxrss.R;

/**
 * Allows to create a view of an article
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView txtTitle,txtPubDate,txtContent;

    public NewsViewHolder(View itemView){
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtPubDate = itemView.findViewById(R.id.txtPubDate);
        txtContent = itemView.findViewById(R.id.txtContent);
    }

}
