package model;

/**
 * Class includes all representation about container.
 *
 * @author Ihar Novik
 */
public class Container {
    private final int id = this.hashCode();
    private int weight;
    private String description;

    public Container(int weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public Container(int weight) {
        this.weight = weight;
        description = ProjectConstants.UNDEFINED_DESCRIPTION;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return ProjectConstants.CONTAINER + "{" +
                ProjectConstants.ID + "=" + id +
                ", " + ProjectConstants.WEIGHT + "=" + weight +
                ", " + ProjectConstants.DESCRIPTION + "='" + description + '\'' +
                '}';
    }
}
