import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        // Путь к XML файлу
        Path path = Paths.get("random_structure_18.xml");

        try {
            // Чтение файла в строку
            String xml = Files.readString(path);

            // Парсинг файла
            Library library = parseXML(xml);

            // Вывод
            System.out.println(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library parseXML(String xml) {
        Library library = new Library();

        String[] books = xml.split("<book ");
        for (int i = 1; i < books.length; i++) {
            String bookXML = books[i];
            Book book = new Book();

            book.setId(extractValue(bookXML, "id=\"", "\""));
            book.setTitle(extractTagValue(bookXML, "title"));
            book.setAuthor(extractTagValue(bookXML, "author"));
            book.setYear(extractTagValue(bookXML, "year"));
            book.setGenre(extractTagValue(bookXML, "genre"));
            book.setPrice(extractPriceValue(bookXML, "price", extractValue(bookXML, "currency=\"", "\"")));
            book.setIsbn(extractTagValue(bookXML, "isbn"));
            book.setFormat(extractTagValue(bookXML, "format"));
            book.setTranslator(extractTagValue(bookXML, "translator"));

            String publisherXML = extractTagValue(bookXML, "publisher");
            if (publisherXML != null) {
                Publisher publisher = new Publisher();
                publisher.setName(extractTagValue(publisherXML, "name"));
                String addressXML = extractTagValue(bookXML, "address");
                if (addressXML != null) {
                    Address address = new Address();
                    address.setCity(extractTagValue(publisherXML, "city"));
                    address.setCountry(extractTagValue(publisherXML, "country"));
                    publisher.setAddress(address);
                }
                book.setPublisher(publisher);
            }

            String[] reviews = bookXML.split("<review>");
            for (int j = 1; j < reviews.length; j++) {
                String reviewXML = reviews[j];
                Review review = new Review();
                review.setUser(extractTagValue(reviewXML, "user"));
                review.setRating(extractTagValue(reviewXML, "rating"));
                review.setComment(extractTagValue(reviewXML, "comment"));
                book.getReviews().add(review);
            }

            library.addBook(book);
        }

        return library;
    }

    public static String extractValue(String xml, String start, String end) {
        int startIndex = xml.indexOf(start) + start.length();
        int endIndex = xml.indexOf(end, startIndex);
        return xml.substring(startIndex, endIndex);
    }

    public static String extractTagValue(String xml, String tag) {
        int startIndex = xml.indexOf("<" + tag + ">");
        if (startIndex == -1) return null;
        startIndex += tag.length() + 2;
        int endIndex = xml.indexOf("</" + tag + ">", startIndex);
        return xml.substring(startIndex, endIndex);
    }

    public static String extractPriceValue(String xml, String tag, String currency) {
        int startIndex = xml.indexOf("<" + tag + " currency=\"" + currency + "\">");
        if (startIndex == -1) return null;
        startIndex += tag.length() + currency.length() + 14;
        int endIndex = xml.indexOf("</" + tag + ">", startIndex);
        return xml.substring(startIndex, endIndex) + " " + currency;
    }
}
