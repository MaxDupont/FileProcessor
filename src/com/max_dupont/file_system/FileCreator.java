package com.max_dupont.file_system;

import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;
import com.max_dupont.crud.CreatorInterface;

import java.io.File;
import java.io.IOException;

public class FileCreator implements CreatorInterface {

    private ExistenceEnsuranceInterface checker;

    public FileCreator(ExistenceEnsuranceInterface checkable) {
        this.checker = checkable;
    }

    @Override
    public boolean create(String name) throws IOException {

        if (checker.exists(name)) {
            return false;
        }

        File f = new File(name);
        return f.createNewFile();
    }
}
