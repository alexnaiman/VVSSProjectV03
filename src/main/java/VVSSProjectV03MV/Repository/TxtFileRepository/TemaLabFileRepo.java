package VVSSProjectV03MV.Repository.TxtFileRepository;

import VVSSProjectV03MV.Domain.HasId;
import VVSSProjectV03MV.Domain.TemaLab;
import VVSSProjectV03MV.Validator.TemaLabValidator;

import java.io.*;

public class TemaLabFileRepo extends AbstractFileRepository {
    public TemaLabFileRepo(String filename, TemaLabValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        int id = Integer.parseInt(info[0]);
        String descr = info[1];
        int sptLim = Integer.parseInt(info[2]);
        int sptPred = Integer.parseInt(info[3]);
        TemaLab t = new TemaLab(id, descr, sptLim, sptPred);
        return t;

    }
}