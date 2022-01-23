package com.example.CustomerService.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExceptionResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class ExceptionResponse  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("errorMessage")
  private String errorMessage = null;

  @JsonProperty("requestedURI")
  private String requestedURI = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("errorCode")
  private Integer errorCode = null;

  public ExceptionResponse errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   * @return errorMessage
  **/
  @ApiModelProperty(value = "")
  
    public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ExceptionResponse requestedURI(String requestedURI) {
    this.requestedURI = requestedURI;
    return this;
  }

  /**
   * Get requestedURI
   * @return requestedURI
  **/
  @ApiModelProperty(value = "")
  
    public String getRequestedURI() {
    return requestedURI;
  }

  public void setRequestedURI(String requestedURI) {
    this.requestedURI = requestedURI;
  }

  public ExceptionResponse reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
  **/
  @ApiModelProperty(value = "")
  
    public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ExceptionResponse errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
  **/
  @ApiModelProperty(value = "")
  
    public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExceptionResponse exceptionResponse = (ExceptionResponse) o;
    return Objects.equals(this.errorMessage, exceptionResponse.errorMessage) &&
        Objects.equals(this.requestedURI, exceptionResponse.requestedURI) &&
        Objects.equals(this.reason, exceptionResponse.reason) &&
        Objects.equals(this.errorCode, exceptionResponse.errorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessage, requestedURI, reason, errorCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceptionResponse {\n");
    
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    requestedURI: ").append(toIndentedString(requestedURI)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
