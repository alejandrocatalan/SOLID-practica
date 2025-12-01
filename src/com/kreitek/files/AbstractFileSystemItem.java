package com.kreitek.files;

public abstract class AbstractFileSystemItem implements FileSystemItem {

    protected static final String PATH_SEPARATOR = "/";

    protected String name;
    protected FileSystemItem parent;

    protected AbstractFileSystemItem(FileSystemItem parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.name = name;
    }

    @Override
    public FileSystemItem getParent() {
        return parent;
    }

    @Override
    public void setParent(FileSystemItem parent) {
        if (parent != null && !(parent instanceof DirectoryItem)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        this.parent = parent;
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parentFullPath + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }
}
