package de.developerpat.camundademo.process;

import de.developerpat.rest.BaufiProposal;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SenderDelegate")
public class SenderDelegate implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(SenderDelegate.class);

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Value("${rabbitmq.exchange}")
  private String exchange;

  private static final Queue queue = new Queue("Baufiqueue");

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    BaufiStatus status = (BaufiStatus) delegateExecution.getVariable("baufistatus");

    Event event = new Event(delegateExecution.getProcessInstanceId(), status);
    rabbitTemplate.convertAndSend(exchange,"", event, m -> {
      m.getMessageProperties().getHeaders().put("topic", "proposal.created");
      return m;
    });
    LOGGER.info("{x] Sent: " + event);
  }
}
