package com.max_dupont.file_system;

import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;
import com.max_dupont.crud.ReaderInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements ReaderInterface {

    private ExistenceEnsuranceInterface checker;

    public FileReader(ExistenceEnsuranceInterface checkable) {
        this.checker = checkable;
    }

    @Override
    public String read(String name) throws IOException {
        if (!checker.exists(name)) {
            throw new RuntimeException("File already exists");
        }

        return Files.readString(Path.of(name));
    }
}
