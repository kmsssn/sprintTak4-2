package kz.bitlab.sprintTask.db;

public class Items {
    private Long id;
    private String name;
    private String description;
    private double price;

    public Items(){}

    public Items(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        String newDescription=null;
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sprinttask4-2",
                    "root",
                    "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT REPLACE(description, '\\n', '<br>') " +
                            "AS newDescription FROM items");
            while (resultSet.next()) {
                newDescription = resultSet.getString("newDescription");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
