package de.developerpat.camundademo.process;

import de.developerpat.rest.BaufiProposal;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "outputBean")
public class AusgabeDelegate implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(AusgabeDelegate.class);

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    BaufiProposal baufiProposal = (BaufiProposal) delegateExecution.getVariable("baufiProposal");
    delegateExecution.setVariable("baufistatus", BaufiStatus.DONE);
    LOGGER.info("Der Antrag lautet: " + baufiProposal);
  }
}
