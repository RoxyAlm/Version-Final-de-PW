package cu.edu.cujae.pweb.service;

import java.util.List;
import cu.edu.cujae.pweb.dto.EvaluationDto;

public interface EvaluationService {

    void addEvaluation(EvaluationDto eval);
    void updateEvaluation(EvaluationDto eval);
    void deleteEvaluation(EvaluationDto student, EvaluationDto subject);
    List<EvaluationDto> getEvaluations();
}