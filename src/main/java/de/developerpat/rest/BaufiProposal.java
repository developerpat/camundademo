package de.developerpat.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BaufiProposal implements Serializable {

  @JsonProperty("Vorname")
  private String vorname;

  @JsonProperty("Nachname")
  private String nachname;

  @JsonProperty("Geburtsdatum")
  private Date geburtsdatum;

  @JsonProperty("Baufinanzierungssumme")
  private int bauSumme;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaufiProposal that = (BaufiProposal) o;
    return bauSumme == that.bauSumme &&
        Objects.equals(vorname, that.vorname) &&
        Objects.equals(nachname, that.nachname) &&
        Objects.equals(geburtsdatum, that.geburtsdatum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vorname, nachname, geburtsdatum, bauSumme);
  }

  @Override
  public String toString() {
    return "BaufiProposal{" +
        "vorname='" + vorname + '\'' +
        ", nachname='" + nachname + '\'' +
        ", geburtsdatum=" + geburtsdatum +
        ", bauSumme=" + bauSumme +
        '}';
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public void setGeburtsdatum(Date geburtsdatum) {
    this.geburtsdatum = geburtsdatum;
  }

  public void setBauSumme(int bauSumme) {
    this.bauSumme = bauSumme;
  }

  public String getVorname() {
    return vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public Date getGeburtsdatum() {
    return geburtsdatum;
  }

  public int getBauSumme() {
    return bauSumme;
  }
}
