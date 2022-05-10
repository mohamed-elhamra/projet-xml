package fr.univrouen.rss22project.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22project.dtos.ItemDto;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;


@Data
@JacksonXmlRootElement
public class Items implements Serializable {

    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<ItemDto> items = new ArrayList<>();

}
