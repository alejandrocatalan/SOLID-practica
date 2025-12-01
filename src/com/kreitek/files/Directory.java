package com.kreitek.files;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractFileSystemItem implements DirectoryItem {

    private final List<FileSystemItem> files = new ArrayList<>();

    public Directory(FileSystemItem parent, String name) {
        super(parent, name);
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemItem item : files) {
            total += item.getSize();
        }
        return total;
    }

    @Override
    public List<FileSystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItem file) {
        files.remove(file);
    }
}
