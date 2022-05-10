package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22project.utils.TypeContentEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "content")
@JacksonXmlRootElement(localName = "content")
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private TypeContentEnum type;

    @JacksonXmlProperty(isAttribute = true, localName = "url")
    private String url;

}
