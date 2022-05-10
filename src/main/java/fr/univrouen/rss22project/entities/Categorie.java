package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "category")
@JacksonXmlRootElement(localName = "category")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @JacksonXmlProperty(isAttribute = true, localName = "term")
    private String term;

    @ManyToOne
    @JoinColumn(name = "id_item")
    @JsonIgnore
    private Item item;

}
