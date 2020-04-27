package VVSSProjectV03MV.Service.XMLFileService;

import VVSSProjectV03MV.Domain.*;
import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.XMLFileRepository.AbstractXMLRepository;

public abstract class AbstractXMLService<ID, E extends HasId<ID>> {
    private AbstractXMLRepository xmlRepository;

    public AbstractXMLService(AbstractXMLRepository xmlRepository) {
        this.xmlRepository = xmlRepository;
    }

    protected abstract E extractEntity(String[] params);

    public void add(String params[]) throws ValidatorException {
        E entity = extractEntity(params);
        xmlRepository.save(entity);
    }

    public void remove(ID id) {
        xmlRepository.delete(id);
    }

    public void update(String params[]) {
        E entity = extractEntity(params);
        xmlRepository.update(entity);
    }

    public E findOne(ID id) {
        return (E) xmlRepository.findOne(id);
    }

    public Iterable<E> findAll() {
        return xmlRepository.findAll();
    }

    public int getSize() {
        return xmlRepository.getSize();
    }
}