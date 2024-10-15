import java.util.ArrayList;
import java.util.List;

class Book {
    private String id, title, author, year, genre, price, isbn, format, translator;
    private String currency; // Валюта
    private Publisher publisher;
    private List<Review> reviews = new ArrayList<>();

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book ID: ").append(id).append("\n");
        sb.append("  Title: ").append(title).append("\n");
        sb.append("  Author: ").append(author).append("\n");
        sb.append("  Year: ").append(year).append("\n");
        sb.append("  Genre: ").append(genre).append("\n");
        sb.append("  Price: ").append(price).append("\n");
        if (isbn != null) {
            sb.append("  ISBN: ").append(isbn).append("\n");
        }
        if (format != null) {
            sb.append("  Format: ").append(format).append("\n");
        }
        if (translator != null) {
            sb.append("  Translator: ").append(translator).append("\n");
        }
        if (publisher != null) {
            sb.append("  Publisher: ").append(publisher).append("\n");
        }
        if (!reviews.isEmpty()) {
            sb.append("  Reviews:\n");
            for (Review review : reviews) {
                sb.append("    ").append(review).append("\n");
            }
        }
        return sb.toString();
    }
}
