package aims.media;

import aims.service.Playable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompactDisc extends Dics implements Playable {
    private String artist;
    private int length=0;
    private final List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track){
        if(tracks.isEmpty()) {
            tracks.add(track);
            return;
        }
        for (Track track1: tracks){
            if(track1.equals(track)){
                System.out.println("This track exist!");
                return;
            }
        }

        tracks.add(track);
        System.out.println("Add success");
    }

    public void removeTrack(Track track){
        if(tracks.isEmpty()){
            System.out.println("List tracks is empty");
            return;
        }
        for(Track track1:tracks){
            if(track1.equals(track)){
                tracks.remove(track1);
                System.out.println("Remove success");
                return;
            }
        }

        System.out.println("This track doesn't exist");
    }

    public String toString(){
        return "CompactDisc{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", length=" + length +
                ", cost=" + cost +
                '}';
    }

    public int getLength(){
        if(tracks.isEmpty()) return 0;
        for(Track track:tracks){
            length+=track.getLength();
        }
        return length;
    }

    @Override
    public void play() {
        if(tracks.isEmpty()){
            System.out.println("CD is empty!");
            return;
        }
        for (Track track:tracks){
            track.play();
        }
    }
}
