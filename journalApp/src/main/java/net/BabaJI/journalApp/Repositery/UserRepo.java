package net.BabaJI.journalApp.Repositery;

import net.BabaJI.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    /**
     * UserRepo is a Data Access Layer for the "User" collection in MongoDB.
     * By extending MongoRepository, we automatically get built-in CRUD methods
     * like save(), findById(), findAll(), deleteById(), etc.
     * The method findByUserName() below is NOT defined in MongoDB itself.
     * Instead, Spring Data MongoDB parses the method name at runtime and
     * generates the appropriate query automatically:
     *   findByUserName("john123")
     *      --> runs MongoDB query: { "userName" : "john123" }
     * This is called "Query Method Derivation".
     * You just declare the method, and Spring Data builds the query for you.
     */
    User findByUserName(String username);

    void deleteByUserName(String userName);
}
