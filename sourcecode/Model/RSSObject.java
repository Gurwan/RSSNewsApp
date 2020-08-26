package studio.okaria.fluxrss.Model;

import java.util.List;

/**
 * Object of an article
 */
public class RSSObject {
    public String status;
    public Feed feed;
    public List<Item> items;

    public RSSObject(String status, Feed feed, List<Item> items){
        this.status = status;
        this.feed = feed;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

}
