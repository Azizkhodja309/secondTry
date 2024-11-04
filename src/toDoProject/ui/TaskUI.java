package toDoProject.ui;

import toDoProject.enums.TaskStatus;
import toDoProject.model.Task;
import toDoProject.service.TaskService;

public class TaskUI {
    private static TaskService taskService = new TaskService(2);


    public static void main(String[] args) {
        taskLoop: while (true){
            System.out.println("""
                    ===== Task menu =====
                    1.Show Tasks
                    2.Add Task
                    3.Delete
                    4.Update
                    0.Log Out
                    """);
            Integer choose = Utils.getInt("Choose : ");
            switch (choose){
                case 1->{
                    showTasks();
                }
                case 2->{
                    addTask();
                    }
                case 3->{
                     deleteTask();
                    }
                case 4->{
                     updateTask();
                    }
                case 0->{
                    break taskLoop;
                }
                default->
                    System.out.println("Wrong menu! Try again!!!");
            }
        }
    }

    private static void updateTask() {
        while (true) {
            System.out.println("===== Update Task =====");
            int taskLength = showTask();
            System.out.println("0. Back");
            int choose = Utils.getInt("Choose Menu: ");
            if(choose == 0){
                return;
            }else if(choose < 0 || choose >= taskLength){
                System.out.println("Wrong Menu! Try again!");
                continue;
            }
            Task task = taskService.getTask(choose);

            System.out.println("""
                    ===== Update Menu =====
                    1. Name
                    2. Description
                    3. Task Status
                    0. Back
                    """);
            int anInt = Utils.getInt("Choose Menu: ");

            switch (anInt) {
                case 1:
                    String newName = Utils.getStr("Enter Tasks New Name: ");
                    task.setName(newName);
                    break;
                case 2:
                    String newDescription = Utils.getStr("Enter Tasks New Description: ");
                    task.setDescription(newDescription);
                    break;
                case 3:
                    System.out.println(TaskStatus.getAllValuesAsString());
                    Integer statusOrder = Utils.getInt("Choose status: ");
                    TaskStatus newStatus = TaskStatus.getValueByOrder(statusOrder);
                    task.setStatus(newStatus);
                    break;
                default:
                    System.out.println("Something wrong! Try again !!!");
            }
        }
    }

    private static void deleteTask() {
        while (true) {
            System.out.println("==============================================");
            showTask();
            System.out.println("0. Back");
            System.out.println("==============================================");
            int anInt = Utils.getInt("Choose Menu: ");

            if (anInt == 0) {
                return;
            }else if(anInt < 0 || anInt > taskService.getCount()){
                System.out.println("Wrong menu! Try again !!!");
            }

            boolean delete = taskService.delete(anInt);

            if(delete){
                System.out.println("Deleted successfully.");
            }else{
                System.out.println("Something wrong!");
            }
        }
    }

    private static void addTask() {
        System.out.println("Please Enter Task Info: ");
        String name = Utils.getStr("Name: ");
        String description = Utils.getStr("Description: ");
        System.out.println("TaskStatus:");
        System.out.println(TaskStatus.getAllValuesAsString());
        int statusOrder = Utils.getInt("Choose status: ");
        TaskStatus status = TaskStatus.getValueByOrder(statusOrder);

        Task task = new Task(name,description,status);

        taskService.create(task);
        System.out.println("Successfully Created🎆🎆🎆🎆");

    }

    private static void showTasks() {
        while(true) {
            System.out.println("==============================================");
            showTask();
            System.out.println("0. Back");
            System.out.println("==============================================");
            int anInt = Utils.getInt("Choose menu: ");

            if(anInt == 0){
                return;
            }

            if (anInt <= 0 || anInt > taskService.getCount()) {
                System.out.println("Wrong menu! Try again !!!");
                continue;
            }
            System.out.println(taskService.getTask(anInt));
        }
    }

    private static int showTask(){
        System.out.println("===== Task Menu =====");
        Task[] all = taskService.getAllTasks();
        int count = 1;
        for (Task task : all) {
            System.out.println(count + ". " + task.getName());
            count++;
        }
        return count;
    }
}