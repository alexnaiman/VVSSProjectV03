package VVSSProjectV03MV.Service.TxtFileService;
import VVSSProjectV03MV.Domain.*;
import VVSSProjectV03MV.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
