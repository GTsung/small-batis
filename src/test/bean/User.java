package test.bean;

/**
 * @author GTsung
 * @date 2021/10/18
 */
public class User {

    /**
     * the id
     */
    private String id;

    /**
     * the name
     */
    private String name;

    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
