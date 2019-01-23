package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Association;

import java.util.List;

/**
 * DAO for Association
 */
public interface AssociationDAO {
    /**
     * Persist the entity
     * @param association The entity to persist
     */
    void persist(Association association);

    /**
     * Update the entity
     * @param association  The entity
     */
    void update(Association association);

    /**
     * Find the entity by id
     * @param id the id
     * @return an entity
     */
    Association findById(int id);

    /**
     * Delete the entity
     * @param association to delete
     */
    void delete(Association association);

    /**
     * Find all the entities without offset
     * @return All the entities in a List
     */
    List<Association> findAll();

    /**
     * Find all the entities with offset
     * @param offset The offset
     * @param nbPages page numbers
     * @return All the entities in a List
     */
    List<Association> findAllOffset(Integer offset, Integer nbPages);
}
