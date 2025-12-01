package com.kreitek.services;

import com.kreitek.files.FileSystemItem;

import java.util.List;
import java.util.Objects;

public class FileManager {

    public static int calculateSize(FileSystemItem item) {
        Objects.requireNonNull(item, "item no puede ser null");
        return item.getSize();
    }

    public static int calculateSize(List<? extends FileSystemItem> items) {
        Objects.requireNonNull(items, "items no puede ser null");
        int total = 0;
        for (FileSystemItem item : items) {
            total += item.getSize();
        }
        return total;
    }
}
