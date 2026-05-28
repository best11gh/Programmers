import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genreCnt.put(
                genre, 
                genreCnt.getOrDefault(genre, 0) + play
            );
            
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }
        
        List<String> genreList = new ArrayList<>(genreCnt.keySet());
        genreList.sort((a, b) -> genreCnt.get(b) - genreCnt.get(a));
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : genreList){
            List<Song> songs = genreSongs.get(genre);
            
            Collections.sort(songs);
            
            for (int i = 0; i < Math.min(2, songs.size()); i++){
                answer.add(songs.get(i).idx);
            }
        }
        
        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
    
    
    class Song implements Comparable<Song>{
        int idx;
        int play;
        
        Song(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(o.play, this.play);
        }
    }
}