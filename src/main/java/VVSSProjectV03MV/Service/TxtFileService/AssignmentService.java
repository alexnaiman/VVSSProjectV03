package VVSSProjectV03MV.Service.TxtFileService;

import VVSSProjectV03MV.Domain.Assignment;
import VVSSProjectV03MV.Exceptions.ValidatorException;
import VVSSProjectV03MV.Repository.TxtFileRepository.AssignmentFileRepository;

public class AssignmentService extends AbstractService<Integer, Assignment> {
    public AssignmentService(AssignmentFileRepository tmLbRepo) {
        super(tmLbRepo);
    }

    public void changeDeadline(String id,
                               String description,
                               String startline,
                               String deadline,
                               int current) throws ValidatorException {
        if (current <= Integer.parseInt(deadline)) {
            String sln = Integer.toString(Integer.parseInt(startline) + 1);
            String[] params = {id, description, sln, startline};
            update(params);
        }
    }
}
