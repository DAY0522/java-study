package chapter03;

public class SongTest {
    public static void main(String[] args) {
        Song song = new Song("좋은날", "아이유", "Real", "이민수", 2010, 3);

//        song.setAlbum("Real");
//        song.setArtist("아이유");
//        song.setTitle("좋은날");
//        song.setComposer("이민수");
//        song.setYear(2010);
//        song.setTrack(3);

        song.show();

        Song song2 = new Song("New Jeans", "Ditto");
        song2.show();
    }
}
