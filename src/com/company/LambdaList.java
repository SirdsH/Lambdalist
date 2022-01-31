package com.company;

import java.util.ArrayList;

public class LambdaList<T> {
    private final ArrayList<T> arrayList = new ArrayList<>();

    public void add(T item) {
        arrayList.add(item);
    }
    public T get(int i) {
        return arrayList.get(i);
    }
    public void remove(int i) {
        arrayList.remove(i);
    }

    public <E> LambdaList<E> map(IModify<T, E> modify) {
        LambdaList<E> list = new LambdaList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            list.add(modify.modify(arrayList.get(i)));
        } return list;
    }

    public boolean all(ICondition<T> condition) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (!condition.bool(arrayList.get(i))) return false;
        } return true;
    }

    public boolean any(ICondition<T> condition) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (condition.bool(arrayList.get(i))) return true;
        } return false;
    }

    public LambdaList<T> filter(ICondition<T> condition) {
        LambdaList<T> list = new LambdaList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (condition.bool(arrayList.get(i))) list.add(arrayList.get(i));
        } return list;
    }

    public T max(IComparator<T> comparator) {
        if (arrayList.isEmpty()) return null;
        T maxT = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (comparator.compare(arrayList.get(i), maxT) > 0) maxT = arrayList.get(i);
        } return maxT;
    }

    public T min(IComparator<T> comparator) {
        if (arrayList.isEmpty()) return null;
        T minT = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (comparator.compare(arrayList.get(i), minT) < 0) minT = arrayList.get(i);
        } return minT;
    }
}
