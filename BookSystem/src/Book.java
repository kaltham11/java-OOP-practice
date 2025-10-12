public class Book extends BaseEntity {
    private String title;
    private String author;
    private String publicationYear;
    private Double price;
    private String bookType;
    private Boolean isAvailable;
    private Integer chapters;


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

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return bookType;
    }

    public void setType(String type) {
        this.bookType = type;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", price=" + price +
                ", bookType='" + bookType + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
