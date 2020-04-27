package VVSSProjectV03MV.Service.TxtFileService;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.TxtFileRepository.AbstractFileRepository;
import VVSSProjectV03MV.Validator.IValidator;

public abstract class AbstractService<ID, E extends HasId<ID>> {
    private IValidator<E> v;
    private AbstractFileRepository<ID, E> repo;

    public AbstractService(AbstractFileRepository repo) {
        this.repo = repo;
    }

    public void add(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.save(entity);
    }

    public void delete(ID id) {
        repo.delete(id);
    }

    public void update(String[] params)  {
        E entity = repo.extractEntity(params);
        repo.update(entity);
    }

    public Iterable<E> getAll() {
        return repo.findAll();
    }

    public E getById(ID id) {
        return repo.findOne(id);
    }

    public int size() {
        return (int) repo.size();
    }
}