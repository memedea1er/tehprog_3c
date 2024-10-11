class Review {
    private String user, rating, comment;

    // Геттеры и сеттеры
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User: " + user + ", Rating: " + rating + ", Comment: " + comment;
    }
}