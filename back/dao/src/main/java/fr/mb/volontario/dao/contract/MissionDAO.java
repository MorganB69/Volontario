package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Mission;

import java.util.List;

/**
 *Dao For Mission
 */
public interface MissionDAO {

    /**
     * Persist the entity
     * @param mission a Mission entity to persist
     */
    void persist(Mission mission);

    /**
     * Update the entity
     * @param mission A mission entity
     */
    void update(Mission mission);

    /**
     * Find the entity by id
     * @param id the id
     * @return a Mission entity
     */
    Mission findById(int id);

    /**
     * Delete the entity
     * @param mission to delete
     */
    void delete(Mission mission);

    /**
     * Find all the entities without offset
     * @return All the entities in a List
     */
    List<Mission> findAll();

    /**
     * Find all the entities with offset
     * @param offset The offset
     * @param nbPages page numbers
     * @return All the entities in a List
     */
    List<Mission> findAllOffset(Integer offset, Integer nbPages);
}
