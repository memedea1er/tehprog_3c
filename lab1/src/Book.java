import java.util.ArrayList;
import java.util.List;

class Book {
    String id, title, author, year, genre, price, isbn, format, translator;
    Publisher publisher;
    List<Review> reviews = new ArrayList<>();

    @Override
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