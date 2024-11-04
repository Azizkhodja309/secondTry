package toDoProject.service;

import toDoProject.db.ObjectsDB;
import toDoProject.enums.TaskStatus;
import toDoProject.model.Task;

import java.util.ArrayList;

public class TaskService {

    private ObjectsDB<Task> tasks;

    public TaskService(int startLength) {
        this.tasks = new ObjectsDB(startLength);
        Task task = new Task("Salomber", "salomlash", TaskStatus.IN_PROGRESS);
        Task task1 = new Task("Xayrlash", "salomlash", TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Yugurish", "salomlash", TaskStatus.IN_PROGRESS);
        tasks.add(task);
        tasks.add(task1);
        tasks.add(task2);
    }

    public void create(Task task) {
        tasks.add(task);
    }

    public Task[] getAllTasks() {

        ArrayList allObj = tasks.getAll();
        Task[] res = new Task[allObj.size()];

        for (int i =0; i<allObj.size();i++) {
            Object o = allObj.get(i);
            if (o instanceof Task task){
                res[i]=task;
            }
        }
        return res;
    }

    public Task getTask(Integer index){
        return tasks.getObjTask(index - 1);
    }

    public boolean delete(Integer index){
        return tasks.delete(index - 1);
    }

    public int getCount(){
        return tasks.size();
    }
}
