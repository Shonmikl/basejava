package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume r, int index) {
        int insert = -index - 1;
        System.arraycopy(storage, insert, storage, insert + 1, size - insert);
        storage[insert] = r;
    }

    @Override
    protected Integer getKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void moveArray(int index) {
        int element = size - index - 1;
        if (element > 0) {
            System.arraycopy(storage, index + 1, storage, index, element);
        }
    }
}