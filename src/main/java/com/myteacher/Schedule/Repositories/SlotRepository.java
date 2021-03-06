package com.myteacher.Schedule.Repositories;


import com.myteacher.Schedule.Models.Slot;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends MongoRepository<Slot, String> {
    List<Slot> findAllByUsername(String username);
    List<Slot> findAllByClassId(String classId);
    List<Slot> findAllByClassLevel(String level);
    List<Slot> findAllByStudentsContaining(String username);
    void deleteAllByClassId(String classId);
}
