package de.developerpat.camundademo.process;

import java.io.Serializable;

public class Event implements Serializable {

  private String proposalId;

  private BaufiStatus baufistatus;

  public Event(String proposalId, BaufiStatus baufistatus) {
    this.proposalId = proposalId;
    this.baufistatus = baufistatus;
  }

  @Override
  public String toString() {
    return "Event{" +
        "proposalId='" + proposalId + '\'' +
        ", baufistatus=" + baufistatus +
        '}';
  }

  public String getProposalId() {
    return proposalId;
  }

  public void setProposalId(String proposalId) {
    this.proposalId = proposalId;
  }

  public BaufiStatus getBaufistatus() {
    return baufistatus;
  }

  public void setBaufistatus(BaufiStatus baufistatus) {
    this.baufistatus = baufistatus;
  }
}
