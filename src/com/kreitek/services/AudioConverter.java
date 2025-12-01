package com.kreitek.services;

import com.kreitek.files.File;
import com.kreitek.files.FileItem;
import com.kreitek.files.FileSystemItem;
import com.kreitek.files.error.InvalidFileFormatException;

public class AudioConverter {

    private AudioConverter() {
    }

    public static FileSystemItem convertMp3ToWav(FileItem source) {
        if (!"mp3".equalsIgnoreCase(source.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        String name = source.getName();
        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }

        String newFileName = nameWithoutExtension + ".wav";

        FileSystemItem parent = source.getParent();
        FileItem result = new File(parent, newFileName);

        result.open();
        result.close();

        return result;
    }

    public static FileSystemItem convertWavToMp3(FileItem source) {
        if (!"wav".equalsIgnoreCase(source.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        String name = source.getName();
        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }

        String newFileName = nameWithoutExtension + ".mp3";

        FileSystemItem parent = source.getParent();
        FileItem result = new File(parent, newFileName);

        result.open();
        result.close();

        return result;
    }
}
