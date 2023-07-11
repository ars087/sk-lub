import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class JsonSerialize {
 private  String name;
 private  String line;
 @JsonInclude(JsonInclude.Include.NON_NULL)
 private LocalDate dateOfCreation;
 @JsonInclude(JsonInclude.Include.NON_NULL)
 private  String dapth;
 private  boolean hasConnection;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getLine() {
  return line;
 }

 public void setLine(String line) {
  this.line = line;
 }

 public LocalDate getDateOfCreation() {
  return dateOfCreation;
 }

 public void setDateOfCreation(LocalDate dateOfCreation) {
  this.dateOfCreation = dateOfCreation;
 }

 public String getDapth() {
  return dapth;
 }

 public void setDapth(String dapth) {
  this.dapth = dapth;
 }

 public boolean isHasConnection() {
  return hasConnection;
 }

 public void setHasConnection(boolean hasConnection) {
  this.hasConnection = hasConnection;
 }
}
