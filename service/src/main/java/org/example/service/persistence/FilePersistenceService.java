package org.example.service.persistence;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersistenceService extends AbstractPersistenceService {

    String persistenceFilePath = "/Users/luigi/temp/persistence";


    @Override
    public <T> T insert(T object) throws Exception {
        Path path = getPathFromClassName(object.getClass());
        appendStringToFile(path, object.toString());
        return object;
    }


    @Override
    public <T> T get(String id, Class<T> clazz) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Path path = getPathFromClassName(clazz);

        String row = Files.lines(path)
                .filter(line -> line.startsWith(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));


        return (T) clazz.getMethod("fromString", String.class).invoke(null, row);


    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) throws Exception {
        Path path = getPathFromClassName(clazz);

        List<Object> result = Files.lines(path)
                .map(row -> {
                    try {
                        return clazz.getMethod("fromString", String.class).invoke(null, row);
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return (List<T>) result;

    }

    @Override
    public <T> T update(T object) {
        return null; // TODO
    }

    @Override
    public <T> T delete(String id, Class<T> clazz) {
        return null; // TODO
    }

    @Override
    public <T> void deleteAll(Class<T> clazz) throws IOException {
        cleanPersistenceFileForType(clazz);
    }

    private <T> Path getPathFromClassName(Class<T> clazz) throws IOException {
        String filename = clazz.getName();

        Path path = Paths.get(persistenceFilePath, filename);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        return path;
    }

    private void appendStringToFile(Path path, String data) throws IOException {
        Files.write(
                path,
                (data + "\n").getBytes(),
                StandardOpenOption.APPEND);
    }

    private void cleanPersistenceFileForType(Class orderClass) throws IOException {
        Path path = getPathFromClassName(orderClass);
        Files.delete(path);
    }
}
