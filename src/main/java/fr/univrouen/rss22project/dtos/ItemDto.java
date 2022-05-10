package fr.univrouen.rss22project.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@JacksonXmlRootElement(localName = "item")
public class ItemDto implements Serializable {

    @JacksonXmlProperty
    private UUID guid;

    @JacksonXmlProperty
    private String titre;

    @JacksonXmlProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubOuMaj;

}
