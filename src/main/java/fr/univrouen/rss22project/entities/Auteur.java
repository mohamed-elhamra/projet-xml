package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;


@Data
@Entity
@Table(name = "authorOrContributor")
@JacksonXmlRootElement(localName = "authorOuContributor")
public class Auteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @JacksonXmlProperty(localName = "nom")
    @Column(length = 64)
    private String nom;

    @JacksonXmlProperty(localName = "email")
    @Email
    private String email;

    @JacksonXmlProperty(localName = "uri")
    private String uri;

    @ManyToOne
    @JoinColumn(name = "id_item")
    @JsonIgnore
    private Item item;

}
