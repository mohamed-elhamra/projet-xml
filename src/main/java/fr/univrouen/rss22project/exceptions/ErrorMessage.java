package fr.univrouen.rss22project.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@JacksonXmlRootElement(localName = "Error")
public class ErrorMessage {


    @JacksonXmlProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    @JacksonXmlProperty
    private String exception;

    @JacksonXmlProperty
    private String message;

    @JacksonXmlProperty
    private String cause;

}