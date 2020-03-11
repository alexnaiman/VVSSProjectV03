package VVSSProjectV03MV.Repository.MemoryRepository;

import VVSSProjectV03MV.Validator.IValidator;
import VVSSProjectV03MV.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}