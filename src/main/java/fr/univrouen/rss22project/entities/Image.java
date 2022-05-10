package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22project.utils.TypeImageEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "image")
@JacksonXmlRootElement(localName = "Image")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private TypeImageEnum type;

    @JacksonXmlProperty(isAttribute = true, localName = "href")
    private String href;

    @JacksonXmlProperty(isAttribute = true, localName = "alt")
    private String alt;

    @JacksonXmlProperty(isAttribute = true, localName = "length")
    private int length;


}
