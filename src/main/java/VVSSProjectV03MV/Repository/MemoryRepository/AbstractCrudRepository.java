package VVSSProjectV03MV.Repository.MemoryRepository;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.Repo;
import VVSSProjectV03MV.Validator.IValidator;

import java.util.*;

public abstract class AbstractCrudRepository<ID, E extends HasId<ID>> implements Repo<ID, E> {
    Map<ID, E> entities;
    IValidator<E> validator;
    public AbstractCrudRepository(IValidator v){
        entities=new HashMap<ID,E>();
        validator=v;
    }

    @Override
    public E findOne(ID id) {
        if (entities.get(id) == null) {
            return null;
        } else {
            if (id == null) {
                throw new IllegalArgumentException();
            } else {
                return entities.get(id);
            }
        }

    }

    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    @Override
    public E save(E entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity can not be null!\n");
        }
        try {
            validator.validate(entity);
            if (entities.containsKey(entity.getId())) {
                throw new IllegalArgumentException("Entity with this id already exists!\n");
            }
            return entities.put(entity.getId(), entity);
        } catch (ValidatorException ex) {
            throw new ValidatorException(ex.getMessage());
        }
    }

    @Override
    public E delete(ID id) {
        return entities.remove(id);
    }

    @Override
    public E update(E entity) {
        try {
            if (entity == null) {
                throw new IllegalArgumentException("Entity can not be null!\n");
            } else {
                validator.validate(entity);
                return entities.replace(entity.getId(), entity);
            }
        } catch (ValidatorException e) {
            return null;
        }
    }

    //@Override
    public long size() {
        return entities.size();
    }

}