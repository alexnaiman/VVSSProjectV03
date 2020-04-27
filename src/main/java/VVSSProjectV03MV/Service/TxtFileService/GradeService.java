package VVSSProjectV03MV.Service.TxtFileService;

import VVSSProjectV03MV.Domain.Grade;
import VVSSProjectV03MV.Repository.TxtFileRepository.GradeFileRepository;

public class GradeService extends AbstractService<Integer, Grade> {
    public GradeService(GradeFileRepository gradeFileRepository) {
        super(gradeFileRepository);
    }
}
