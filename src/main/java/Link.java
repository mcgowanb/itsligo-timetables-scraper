import org.jsoup.nodes.Element;

public class Link {
    private String link, title;

    public Link(Element e){
        this.link = e.text();
        this.title = "My funky title";
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }


}
