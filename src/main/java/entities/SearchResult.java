package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchResult implements Serializable {

    private String count;
    private String next;
    private String previous;
    private List<Planet> results;
}
