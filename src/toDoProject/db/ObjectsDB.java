package toDoProject.db;

import toDoProject.model.Task;

import java.util.ArrayList;
import java.util.Arrays;

public class ObjectsDB<T> {
    private Object[] objects;
    private int count;

    private ArrayList<T> arrayList = new ArrayList();

    public ObjectsDB(int startLength) {
        this.objects = new Object[startLength];
        this.count = 0;
    }

    public void add(T object) {
        arrayList.add(object);
    }

    public int size(){
        return arrayList.size();
    }

    public boolean delete(Integer index){
        if(index >= 0 && index < arrayList.size()){
            arrayList.remove(index);
            return true;
        }
        return false;
    }

    public Task getObjTask(Integer index){
        if(arrayList.get(index) instanceof Task)
            return (Task) arrayList.get(index);

        return null;
    }

    public ArrayList getAll() {
        return arrayList;
    }
}
