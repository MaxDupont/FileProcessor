package com.max_dupont.file_system;

import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;

import java.io.File;

public class FileChecker implements ExistenceEnsuranceInterface {
    @Override
    public boolean exists(String name) {
        File f = new File(name);
        return f.exists();
    }
}
