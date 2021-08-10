package com.max_dupont.file_system;

import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;
import com.max_dupont.crud.DeleterInterface;

import java.io.File;

public class FileDeleter implements DeleterInterface {

    private ExistenceEnsuranceInterface checker;

    public FileDeleter(ExistenceEnsuranceInterface checker) {
        this.checker = checker;
    }

    @Override
    public boolean delete(String name) {

        if (!checker.exists(name)) {
            throw new RuntimeException("File doesn't exist");
        }

        File file = new File(name);
        return file.delete();
    }
}
