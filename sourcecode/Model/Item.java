package studio.okaria.fluxrss.Model;

import java.util.List;

/**
 * All data of an article
 */
public class Item {
    public String title;
    public String pubDate;
    public String link;
    public String guid;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public List<String> categories;


    public Item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, List<String> categories) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.categories = categories;

    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
