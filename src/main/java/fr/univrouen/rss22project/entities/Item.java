package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name = "item")
@JacksonXmlRootElement(localName = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    @JacksonXmlProperty(localName = "guid")
    private UUID guid;

    @JacksonXmlProperty(localName = "title")
    @Column(length = 64)
    private String titre;

    @JacksonXmlProperty(localName = "publishedOrUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date pubOuMaj;

    @JacksonXmlProperty(localName = "image")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image")
    private Image image;

    @JacksonXmlProperty(localName = "content")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_content")
    private Content content;

    @JacksonXmlProperty(localName = "auteurOuContributeurs")
    @OneToMany(targetEntity = Auteur.class, mappedBy = "item", cascade = CascadeType.ALL)
    private List<Auteur> auteurOuContributeur = new ArrayList<>();

    @JacksonXmlProperty(localName = "categories")
    @OneToMany(
            targetEntity = Categorie.class,
            mappedBy = "item",
            cascade = CascadeType.ALL
    )
    private List<Categorie> categorieListe = new ArrayList<>();

}
