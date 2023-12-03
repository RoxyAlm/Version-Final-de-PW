package cu.edu.cujae.pweb.bean;

import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.EvaluationDto;
import cu.edu.cujae.pweb.service.EvaluationService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped

public class ManageEvaluationBean {

    private EvaluationDto evalDto;
    private EvaluationDto selectedEval;
    private List<EvaluationDto> evals;

    @Autowired
    private EvaluationService evalService;

    public ManageEvaluationBean() {

    }

    @PostConstruct
    public void init() {
        evals = evals == null ? evalService.getEvaluations() : evals;

    }

    public void openNew() {
        this.selectedEval = new EvaluationDto();
    }

    public void saveEval() {
        if (this.selectedEval.getId() == null) {
            this.selectedEval.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.selectedEval.setNewRecord(true);
            this.evals.add(this.selectedEval);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_eval_added");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_eval_edited");
        }

    }

    public void deleteEval() {
        try {
            this.evals.remove(this.selectedEval);
            this.selectedEval = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_eval_removed");
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
        }

    }

    public EvaluationDto getEvalDto() {
        return evalDto;
    }

    public void setEvalDto(EvaluationDto evalDto) {
        this.evalDto = evalDto;
    }

    public EvaluationDto getSelectedEval() {
        return selectedEval;
    }

    public void setSelectedEval(EvaluationDto selectedEval) {
        this.selectedEval = selectedEval;
    }

    public List<EvaluationDto> getEvals() {
        return evals;
    }

    public void setEvals(List<EvaluationDto> evals) {
        this.evals = evals;
    }

    public EvaluationService getEvalService() {
        return evalService;
    }

    public void setEvalService(EvaluationService evalService) {
        this.evalService = evalService;
    }

}
