package kr.sm.itaewon.travelmaker.model;

import lombok.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "Id_Generator", sequenceName = "Id", initialValue = 1, allocationSize = 1)
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="link_url")
    private String link;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id")
    @Column(name="link_id")
    private Long id;

    @Column(name="favicon_url")
    private String favicon;

    @Column(name="image_url")
    private String image;

    @Column(name="summary")
    private String summary;

    public void LinkApi() {
        System.out.println("url req");

        String url = getLink();

        try{
            if(url.indexOf("https://") == -1)
                url = "https://" + url;

            Document rawData = Jsoup.connect(url).get();

            String[] values = url.split("/");

            String base_url = "https://" + values[2];

            Elements icons = rawData.select("link[href~=.*\\.(ico|png)]");
            Elements imgs = rawData.select("meta[property=og:image]");

            String favImage = null;
            if (icons.size() == 0){
                icons = rawData.select("meta[itemprop=image]");

                if (icons.size() > 0){
                    favImage = icons.first().attr("content");
                }
            }
            else{
                favImage = icons.attr("href");
            }

            if(favImage == null)
                favImage = "No_Content";
            else if(favImage.indexOf("https://") == -1)
                favImage = base_url + favImage;

            String main_img;
            if(imgs.size() == 0){
                main_img = "No_Content";
            }else{
                main_img = imgs.first().attr("abs:content");
            }

            setSummary(rawData.title());
            setFavicon(favImage);
            setImage(main_img);

        }catch (IOException e){
            setLink(null);
        }
    }
}
