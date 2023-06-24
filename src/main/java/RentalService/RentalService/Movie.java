package RentalService.RentalService;


public class Movie {

    private Long id;
    private String name;

    private Category category;
    private Boolean isAvailable;

    public Movie(){

    }

    public Movie(Long id, String name, Category category,Boolean isAvailable){
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}

