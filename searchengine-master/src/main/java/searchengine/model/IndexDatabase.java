package searchengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "index")
@Getter
@Setter
public class IndexDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private PageDatabase page;

    @ManyToOne
    @JoinColumn(name = "lemma_id")
    private LemmaDatabase lemma;

    private float rank;
}
