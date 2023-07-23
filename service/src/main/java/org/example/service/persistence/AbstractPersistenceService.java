package org.example.service.persistence;


import java.io.IOException;
import java.util.List;

public abstract class AbstractPersistenceService {

    /**
     * This method is used to store an object
     *
     * @param object the object to store
     * @param <T>    the type of the object to store
     * @return the object stored
     */
    public abstract <T> T insert(T object) throws Exception;

    /**
     * This method is used to retrieve an object
     *
     * @param id    the id of the object to retrieve
     * @param clazz the class of the object to retrieve
     * @param <T>   the type of the object to retrieve
     * @return the object retrieved
     */
    public abstract <T> T get(String id, Class<T> clazz) throws Exception;

    /**
     * This method is used to retrieve all the objects of a certain type
     *
     * @param clazz the class of the object to retrieve
     * @param <T>   the type of the object to retrieve
     * @return the object retrieved
     */
    public abstract <T> List<T> getAll(Class<T> clazz) throws Exception;


    /**
     * This method is used to update an object
     *
     * @param object the object to update
     * @param <T>    the type of the object to update
     * @return the object updated
     */
    public abstract <T> T update(T object) throws Exception;

    /**
     * This method is used to delete an object
     *
     * @param id    the id of the object to delete
     * @param clazz the class of the object to delete
     * @param <T>   the type of the object to delete
     * @return the object deleted
     */
    public abstract <T> T delete(String id, Class<T> clazz) throws Exception;


    public abstract <T> void deleteAll(Class<T> clazz) throws IOException;


}
