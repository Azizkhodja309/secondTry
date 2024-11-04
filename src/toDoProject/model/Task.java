package toDoProject.model;

import toDoProject.enums.TaskStatus;

public class Task {

    private String name;
    private String description;
    private TaskStatus status;

    public Task(String name, String description, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{\n" +
                "name = '" + name + '\'' + ",\n"  +
                "description = '" + description + '\'' + ",\n"  +
                "status = " + status + "\n"  +
                '}';
    }
}
