package com.kreitek.files;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem parent);
    String getFullPath();
    int getSize();
}
