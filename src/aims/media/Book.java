package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors=new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean search(Media media, String title) {
        return media.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    List<String> addAuthor(String author){
        if(authors.isEmpty()){
            authors.add(author);
            return authors;
        }
        for(String s: authors){
            if(s.equalsIgnoreCase(author)){
                System.out.println("Author already exist!");
                return authors;
            }
        }
        authors.add(author);
        return authors;
    }

    List<String> removeAuthor(String author){
        if(authors.isEmpty()){
            System.out.println("List authors is empty!");
            return authors;
        }
        for(String s: authors){
            if(s.equalsIgnoreCase(author)){
                authors.remove(s);
                return authors;
            }
        }
        System.out.println("Author doesn't exist");
        return authors;
    }

}
