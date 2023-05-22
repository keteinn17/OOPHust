package aims.media;

public abstract class Media {
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getCategory() ;

    public abstract void setCategory(String category);

    public abstract float getCost() ;

    public abstract void setCost(float cost);

    public abstract String toString();
    public abstract boolean search(Media media, String title);
}
