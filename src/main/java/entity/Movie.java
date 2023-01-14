package entity;

import constants.MovieType;

public class Movie {

    private String id;
    private String title;
    private MovieType type;

    public Movie(String id,String title, MovieType type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
            return title;
        }
        public MovieType getType() { return type;
        }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
