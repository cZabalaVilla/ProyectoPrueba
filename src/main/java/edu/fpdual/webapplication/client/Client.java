package edu.fpdual.webapplication.client;

public abstract class Client<T> {

    /**
     * Tests connection between client and web service.
     *
     * @return a {@link String}
     */
    public abstract String ping();

    /**
     * Retrieve a representation of a resource.
     * Obtains information.
     *
     * @param str the resource.
     * @return a {@link T} entity.
     */
    public abstract T get(String str);

    /**
     * Update a resource.
     *
     * @param entity T entity to update.
     * @return a boolean indicating whether the update was successful.
     */
    public abstract boolean put(T entity);

    /**
     * Create a resource.
     *
     * @param entity T entity to create.
     * @return a boolean indicating whether the creation was successful.
     */
    public abstract boolean post(T entity);

    /**
     * Delete a resource.
     *
     * @param entity T entity to delete.
     * @return a boolean indicating whether the deletion was successful.
     */
    public abstract boolean delete(T entity);
}