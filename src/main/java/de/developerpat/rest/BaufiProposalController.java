package de.developerpat.rest;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
public class BaufiProposalController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BaufiProposalController.class);

  @Autowired
  ProcessEngine camunda;

  @RequestMapping(method = RequestMethod.POST)
  public String PostProposal(@RequestBody BaufiProposal baufiproposal) {
    return placeProposal(baufiproposal).getProcessInstanceId();
  }

  @RequestMapping(method = RequestMethod.GET)
  public String test() {
    return "Hello World!";
  }

  private ProcessInstance placeProposal(BaufiProposal baufiproposal) {
    ObjectValue baufiDataValue = Variables.objectValue(baufiproposal)
        .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
        .create();
    return camunda.getRuntimeService().createProcessInstanceByKey("CreateProposal")
        .setVariable("baufiProposal", baufiDataValue).execute();
  }
}
