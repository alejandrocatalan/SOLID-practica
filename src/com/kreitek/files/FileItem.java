package com.kreitek.files;

public interface FileItem extends FileSystemItem {
    String getExtension();
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);
}
