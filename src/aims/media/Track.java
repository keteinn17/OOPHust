package aims.media;

import aims.service.Playable;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(title, track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

    @Override
    public void play() {
        System.out.println("Play track: "+getTitle());
        System.out.println("Track length: "+getLength());
    }
}
