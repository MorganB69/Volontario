package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Benevole;

import java.util.List;

/**
 * Dao Benevole
 */
public interface BenevoleDAO {
    /**
     * Persist the entity
     * @param benevole The entity to persist
     */
    void persist(Benevole benevole);

    /**
     * Update the entity
     * @param benevole  The entity
     */
    void update(Benevole benevole);

    /**
     * Find the entity by id
     * @param id the id
     * @return an entity
     */
    Benevole findById(int id);

    /**
     * Delete the entity
     * @param benevole to delete
     */
    void delete(Benevole benevole);

    /**
     * Find all the entities without offset
     * @return All the entities in a List
     */
    List<Benevole> findAll();

    /**
     * Find all the entities with offset
     * @param offset The offset
     * @param nbPages page numbers
     * @return All the entities in a List
     */
    List<Benevole> findAllOffset(Integer offset, Integer nbPages);
}
