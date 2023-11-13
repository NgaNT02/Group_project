package vn.edu.usth.englishapp.model;

public class Category {
    private int resourceId;
    private String name;
    private String intent;

    public Category(int resourceId, String name, String intent) {
        this.resourceId = resourceId;
        this.name = name;
        this.intent = intent;
    }

    public Category() {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }
}
